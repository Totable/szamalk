/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a20180129;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Misaka
 */
class TelepulesTelepulesresz implements Comparable<TelepulesTelepulesresz>{
    private String telepules, telepulesresz;

    private TelepulesTelepulesresz(String telepules, String telepulesresz) {
        this.telepules = telepules;
        this.telepulesresz = telepulesresz;
    }
    
    public static TelepulesTelepulesresz gyarto(String sor) {
        String[] daraboltsor=sor.split(";");
        String telepules=daraboltsor[1];
        String telepulesresz=daraboltsor[2];
        return new TelepulesTelepulesresz(telepules,telepulesresz);
    }

    public String getTelepules() {
        return telepules;
    }

    public String getTelepulesresz() {
        return telepulesresz;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder(); 
        sb.append((getClass().getSimpleName())).append(": ");
        sb.append(telepules).append("->").append(telepulesresz);
        return sb.toString();
    }

    @Override
    public int compareTo(TelepulesTelepulesresz ttr) {
        String s1 = new StringBuilder(this.telepules).append(this.telepulesresz).toString();
        String s2 = new StringBuilder(ttr.getTelepules()).append(ttr.getTelepulesresz()).toString();
        return s1.compareTo(s2);
    }
    
}

public class Modell {

    private File csvf = new File("./files/geolista.csv");
    private ArrayList<TelepulesTelepulesresz> geoLista = new ArrayList<>();

    public Modell() {
        geoLista = geoListaFeltolt();
        teszt();
    }

    private ArrayList<TelepulesTelepulesresz> geoListaFeltolt() {
        ArrayList<TelepulesTelepulesresz>lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvf), "ISO-8859-2"));
            //System.out.println(br.readLine());
            br.readLine();//fejléc
            String sor="";
            while((sor=br.readLine())!=null){
            //System.out.println(sor);
            lista.add(TelepulesTelepulesresz.gyarto(sor));
            }
            
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hiba: nincs meg a fájl.(96464)");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Hiba: karakterkódolás során.(6468476)");
        } catch (IOException e) {
            System.out.println("Hiba: fájl olvasása,bezárása során(642586)");
        }
        Collections.sort(lista);
        return lista;
    }

    private void teszt() {
        for (TelepulesTelepulesresz ttr: geoLista) {
            System.out.println(ttr);
        }
    }
}
