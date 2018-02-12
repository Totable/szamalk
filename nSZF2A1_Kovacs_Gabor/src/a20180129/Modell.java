package a20180129;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

class TelepulesTelepulesresz implements Comparable<TelepulesTelepulesresz> { //POJO
  private String telepules, telepulesresz;  

  /*public*/ private TelepulesTelepulesresz(String telepules, String telepulesresz) {
    this.telepules = telepules;
    this.telepulesresz = telepulesresz;
  }
  
  public static TelepulesTelepulesresz gyarto(String sor) {
    String[] daraboltSor=sor.split(";"); //2026;Visegrád;Gizellatelep
    String telepules=daraboltSor[1],
           telepulesresz=daraboltSor[2];    
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
    StringBuilder sb=new StringBuilder();
    sb.append(getClass().getSimpleName()).append(": ");
    sb.append(telepules).append(" -> ").append(telepulesresz);
    //return getClass().getSimpleName()+": "+telepules+" -> "+telepulesresz;
    return sb.toString();
  }

  @Override
  public int compareTo(TelepulesTelepulesresz ttr) {
    String s1=new StringBuilder(this.telepules).
      append(this.telepulesresz).toString().toLowerCase();
    String s2=new StringBuilder(ttr.getTelepules()).
      append(ttr.getTelepulesresz()).toString().toLowerCase();
//    System.out.println("s1: "+s1);
//    System.out.println("s2: "+s2);
    final String ABC="aábcdeéfghiíjklmnoóöőpqrstuúüűvwxyz";
    int minHossz=Math.min(s1.length(), s2.length());
    for (int i = 0; i < minHossz; i++) {
      char b1=s1.charAt(i);
      char b2=s2.charAt(i);
      if(ABC.indexOf(b1)<ABC.indexOf(b2)) {
//        System.out.println("döntés: "+-1);
        return -1;
      }
//      if(ABC.indexOf(b1)==ABC.indexOf(b2))
//        return 0;
      if(ABC.indexOf(b1)>ABC.indexOf(b2)) {
//        System.out.println("döntés: "+"+1");
        return +1;
      }
    }
//    System.out.println("döntés: "+(int)Math.signum(s1.length()-s2.length()));
//    System.out.println("\n");
    return (int)Math.signum(s1.length()-s2.length());
    //return Integer.MAX_VALUE;
    //return s1.compareTo(s2);
  } 
}

public class Modell {
  private File csvFajl=new File("./files/geolista.csv");
  private ArrayList<TelepulesTelepulesresz> geoLista=
    new ArrayList<>();
  
  public Modell() {
    geoLista=geoListaFeltolt();
//    teszt();
  }

  private void teszt() {
    for(TelepulesTelepulesresz ttr: geoLista) {
      System.out.println(ttr);
    }
  }
  
  private ArrayList<TelepulesTelepulesresz> geoListaFeltolt() {
    ArrayList<TelepulesTelepulesresz> lista=new ArrayList<>();
    try {
      BufferedReader br=new BufferedReader(
        new InputStreamReader(new FileInputStream(csvFajl), "ISO-8859-2"));
      //System.out.println(br.readLine());
      br.readLine(); //fejléc kihagyása
      String sor;
      while((sor=br.readLine())!=null) {
        //System.out.println(sor); //br.readLine());
        lista.add(TelepulesTelepulesresz.gyarto(sor));
      }
      br.close();
    } 
    catch(FileNotFoundException e2) {
      System.out.println("Hiba: nincs meg a fájl. (9875974)");
    }    
    catch(UnsupportedEncodingException e3) {
      System.out.println("Hiba: karakterkódolás során. (7864653)");
    } 
    catch(IOException e1) {
      System.out.println("Hiba: fájl olvasása, bezárása során. (6565234)");
    }
    Collections.sort(lista);
    return lista; //null;
  }

  public ArrayList<TelepulesTelepulesresz> getGeoLista() {
    return geoLista;
  }
}
