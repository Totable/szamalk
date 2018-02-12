package a20180129;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

class TelepulesTelepulesresz implements Comparable<TelepulesTelepulesresz> { //POJO

    private String telepules, telepulesresz;

    /*public*/ private TelepulesTelepulesresz(String telepules, String telepulesresz) {
        this.telepules = telepules;
        this.telepulesresz = telepulesresz;
    }

    public static TelepulesTelepulesresz gyarto(String sor) {
        String[] daraboltSor = sor.split(";"); //2026;Visegrád;Gizellatelep
        String telepules = daraboltSor[1],
                telepulesresz = daraboltSor[2];
        return new TelepulesTelepulesresz(telepules, telepulesresz);
    }

    public String getTelepules() {
        return telepules;
    }

    public String getTelepulesresz() {
        return telepulesresz;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(": ");
        sb.append(telepules).append(" -> ").append(telepulesresz);
        //return getClass().getSimpleName()+": "+telepules+" -> "+telepulesresz;
        return sb.toString();
    }

    @Override
    public int compareTo(TelepulesTelepulesresz ttr) {
        String s1 = new StringBuilder(this.telepules).
                append(this.telepulesresz).toString().toLowerCase();
        String s2 = new StringBuilder(ttr.getTelepules()).
                append(ttr.getTelepulesresz()).toString().toLowerCase();
//    System.out.println("s1: "+s1);
//    System.out.println("s2: "+s2);
        final String ABC = "aábcdeéfghiíjklmnoóöőpqrstuúüűvwxyz";
        int minHossz = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minHossz; i++) {
            char b1 = s1.charAt(i);
            char b2 = s2.charAt(i);
            if (ABC.indexOf(b1) < ABC.indexOf(b2)) {
//        System.out.println("döntés: "+-1);
                return -1;
            }
//      if(ABC.indexOf(b1)==ABC.indexOf(b2))
//        return 0;
            if (ABC.indexOf(b1) > ABC.indexOf(b2)) {
//        System.out.println("döntés: "+"+1");
                return +1;
            }
        }
//    System.out.println("döntés: "+(int)Math.signum(s1.length()-s2.length()));
//    System.out.println("\n");
        return (int) Math.signum(s1.length() - s2.length());
        //return Integer.MAX_VALUE;
        //return s1.compareTo(s2);
    }
}

public class Modell {

    private File csvFajl = new File("./files/geolista.csv");
    private ArrayList<TelepulesTelepulesresz> geoLista
            = new ArrayList<>();

    public Modell() {
        geoLista = geoListaFeltolt();
//    teszt();
    }

    private void teszt() {
        for (TelepulesTelepulesresz ttr : geoLista) {
            System.out.println(ttr);
        }
    }

    private ArrayList<TelepulesTelepulesresz> geoListaFeltolt() {
        ArrayList<TelepulesTelepulesresz> lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(csvFajl), "ISO-8859-2"));
            //System.out.println(br.readLine());
            br.readLine(); //fejléc kihagyása
            String sor;
            while ((sor = br.readLine()) != null) {
                //System.out.println(sor); //br.readLine());
                lista.add(TelepulesTelepulesresz.gyarto(sor));
            }
            br.close();
        } catch (FileNotFoundException e2) {
            System.out.println("Hiba: nincs meg a fájl. (9875974)");
        } catch (UnsupportedEncodingException e3) {
            System.out.println("Hiba: karakterkódolás során. (7864653)");
        } catch (IOException e1) {
            System.out.println("Hiba: fájl olvasása, bezárása során. (6565234)");
        }
        Collections.sort(lista);
        return lista; //null;
    }

    public ArrayList<TelepulesTelepulesresz> getGeoLista() {
        return geoLista;
    }

    static void csv2bat() {
        File csvFajl = new File("./files/megyek_telepulesek.csv");
        ArrayList<MegyekodMegyenev> megyeList = new ArrayList<>();
        BufferedReader br = null;
        String sor;
        try {
            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(csvFajl), "ISO-8859-2"));
            //System.out.println(br.readLine());
            br.readLine(); //fejléc kihagyása

            while (!(sor = br.readLine()).contains("*")) {
                int poz = sor.indexOf(";");
                String megyekod = sor.substring(0, poz);
                String megyenev = sor.substring(poz + 1);
                megyeList.add(new MegyekodMegyenev(megyekod, megyenev));
            }
            //br.close();
            System.out.println(br.readLine());
        } catch (Exception e2) {
            System.out.println("Hiba: nincs meg a fájl. (9875974)" + e2);
        }
       
        //ArrayList<Telepules> telepulesList= new ArrayList<>();
        TreeSet<Telepules> telepulesHalmaz = new TreeSet<>(
                new Comparator<Telepules>(){
                        @Override 
                        public int compare(Telepules t1, Telepules t2){
                        String s1 = t1.getMegyekodMegyenev().getMegyenev()+t1.getTelepulesnev();
                        String s2 = t2.getMegyekodMegyenev().getMegyenev()+t2.getTelepulesnev();
                        return (s1).compareTo(s2);
                        }
                });
        try {
            br.readLine();
        while ((sor = br.readLine()) != null) {
            String[] dSor = sor.split(";");
            String telepulesnev = dSor[1];
            String megyekod = dSor[2];
            int nepesseg = Integer.parseInt(dSor[8]);
            int i = 0;
            while (!megyeList.get(i).getMegyekod().equals(megyekod)) {
                i++;
                MegyekodMegyenev mn = megyeList.get(i);
                //telepulesList.add(new Telepules(telepulesnev, mn, nepesseg));
                telepulesHalmaz.add(new Telepules(telepulesnev, mn, nepesseg));
            }
        }
        br.close();
    }
    catch (Exception e

    
        ) {
            System.out.println(e);
    }
    //tesztfor(Telepules telepules:telepulesHalmaz){
    File datDajl= new File("");
        try {
            ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(datDajl));
            for(Telepules telepules:telepulesHalmaz){
                oos.writeObject(telepules);
        /*System.out.print(telepules.getTelepulesnev() + "\t");
        System.out.print(telepules.getMegyekodMegyenev() + "\t");
        System.out.println(telepules.getNepesseg());*/
    }
        } catch (Exception e) {
        }
    }
}

class MegyekodMegyenev {

    private String megyekod, megyenev;

    public MegyekodMegyenev(String megyekod, String megyenev) {
        this.megyekod = megyekod;
        this.megyenev = megyenev;
    }

    public String getMegyekod() {
        return megyekod;
    }

    public String getMegyenev() {
        return megyenev;
    }
}

class Telepules implements Serializable{

    private String telepulesnev;
    private MegyekodMegyenev megyekodMegyenev;
    private int nepesseg;

    public Telepules(String telepulesnev, MegyekodMegyenev megyekodMegyenev, int nepesseg) {
        this.telepulesnev = telepulesnev;
        this.megyekodMegyenev = megyekodMegyenev;
        this.nepesseg = nepesseg;
    }

    public int getNepesseg() {
        return nepesseg;
    }

    public MegyekodMegyenev getMegyekodMegyenev() {
        return megyekodMegyenev;
    }

    public String getTelepulesnev() {
        return telepulesnev;
    }

}
