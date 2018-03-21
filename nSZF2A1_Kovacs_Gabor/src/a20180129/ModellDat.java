/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a20180129;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Misaka
 */
public class ModellDat {
     private File datFajl = new File("./files/megyek_telepulesek.dat");
    private ArrayList<Telepules> geoLista
            = new ArrayList<>();

    public ModellDat() {
        geoLista = geoListaFeltolt();
        teszt();
    }

    private void teszt() {
        for (Telepules t : geoLista) {
            System.out.println(t.getMegyekodMegyenev().getMegyenev());
        }
    }

    private ArrayList<Telepules> geoListaFeltolt() {
        ArrayList<Telepules> lista = new ArrayList<>();
        ObjectInputStream ois=null;
        try {
            ois=new ObjectInputStream(new FileInputStream(datFajl));
            while(true){
                //System.out.println(((Telepules)ois.readObject()).getTelepulesnev());
                Object o= ois.readObject();
                //System.out.println(o.getClass().getSimpleName());
                if (o instanceof Telepules) {
                    Telepules t=(Telepules)o;
                    lista.add(t);
                }
            }
            //ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nincs meg a file!");
        }
        catch(EOFException e){
        }
        catch(IOException e){
            System.out.println("Hiba az olvasás során");
        }
        catch(ClassNotFoundException e){
            System.out.println("Hiba: konverziós hiba");
        }
        finally{
            if (ois!=null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.out.println("Hiba fájl lezárásakor!");
                }
            }
            
        }
        Collections.sort(lista, new Comparator<Telepules>(){
                        @Override 
                        public int compare(Telepules t1, Telepules t2){
                        String s1 = t1.getMegyekodMegyenev().getMegyenev()+t1.getTelepulesnev();
                        String s2 = t2.getMegyekodMegyenev().getMegyenev()+t2.getTelepulesnev();
                        return (s1).compareTo(s2);
                        }
                }
        );
        return lista; //null;
    }

    public ArrayList<Telepules> getGeoLista() {
        return geoLista;
    }
}
