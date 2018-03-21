/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a20180226;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Misaka
 */
public class Modell {
    private static String API_URL="http://api.openweathermap.org/data/2.5/weather?q=";
    private static String API_KEY="&appid=2018310bfdb382b812c131040caf5194";
    public static String urlTeszt(String varos){
    return API_URL+varos+API_KEY;
    
    }
    private static File csv= new File("./files/capitals.csv");
    private static ArrayList<String> lista= new ArrayList<String>();
    public void csv2Lista(){
        lista.clear();
        try {
                BufferedReader br = new BufferedReader(new FileReader(csv));
                String sor;
                while((sor=br.readLine())!=null)
                lista.add(sor);
                
                br.close();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
}
