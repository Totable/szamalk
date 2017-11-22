/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a20170920;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Misaka
 */
public class KovacsGabor_szemszamgen {

    static int i;
    static List<String> szamok = new ArrayList<String>();
    static private final String stringfelhasznalonev = System.getProperty("user.name");
    static private String stringfajlnev = "C:/Users/Misaka/Desktop/file.txt";
    static private PrintWriter fos;
    static private File file;
    static private String sCurrentLine;
    static private int bee;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("0: generálás\n"
                    + "minden más: beolvas");
            bee =Integer.parseInt(sc.nextLine());
        if (bee==0) {
            System.out.println("db szám:");
        int be = Integer.parseInt(sc.nextLine());
        int n;
        int m;
        int o;
        int p;
        int s;
        String szam;
        for (i = 0; i < be; i++) {
            n = rand.nextInt(8) + 1;
            m = rand.nextInt(99) + 0;
            o = rand.nextInt(12) + 1;
            p = rand.nextInt(27) + 1;
            s = rand.nextInt(999) + 1;
            szam = n + "" + dbellen(m) + "" + dbellen(o) + "" + dbellen(p) + "" + dbellen2(s);
            dbellen(m);
            ellen(szam);
        }
        ki();
            System.out.println("kész");
        }
        else{
            be();
        }
        }
        
        catch(Exception a){
            System.out.println("túl sok");
        }

    }

    private static void ki() {
        //File file = new File("C:\\Users\\Misaka\\Desktop\\file.txt");
        file = new File(stringfajlnev);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("hiba");
            }
        } else {
            file.setWritable(true);
        }
        try {
            fos = new PrintWriter(new FileOutputStream(file, true));
        } catch (FileNotFoundException ex) {
            System.out.println("hiba");
        }
        for (int j = 0; j < szamok.size(); j++) {
            fos.println(szamok.get(j));
            System.out.println(szamok.get(j));
            fos.flush();
        }

        fos.close();
    }
    private static void be(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/" + stringfelhasznalonev + "/Desktop/file.txt"))) {
            while ((sCurrentLine = br.readLine()) != null) {
                ellen(sCurrentLine);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("nincs fájl");
        }
    
    }

    private static String dbellen(int m) {
        String szam = Integer.toString(m);
        switch (szam.length()) {
            case 1:
                szam = "0" + szam;
                break;
            case 2:
                break;
            default:
                break;

        }
        return szam;

    }

    private static String dbellen2(int m) {
        String szam = Integer.toString(m);
        switch (szam.length()) {
            case 1:
                szam = "00" + szam;
                break;
            case 2:
                szam = "0" + szam;
                break;
            case 3:
                break;
            default:
                break;
        }
        return szam;
    }

    private static void ellen(String sem) {
        int osszeg = 0;
        int j = 0;
        int k;
        for (int ij = 0; ij < 10; ij++) {
            j++;
            osszeg = osszeg + ((Integer.parseInt(sem.substring(ij, j))) * j);
        }
        if (bee!=0) {
            k=Integer.parseInt(sem.substring(10,11));
            if (osszeg%11==k) {
                System.out.println(sem+" jó");
            }
            else{
            System.out.println(sem+" rossz");
            }
        }
        else{
        k= osszeg % 11;
        if (k > 9) {
            i--;
        }
        else{
            System.out.println(sem + k);
            szamok.add(sem + k);
        }
        }
        
    }
}
