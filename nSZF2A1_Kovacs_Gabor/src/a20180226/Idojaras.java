/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a20180226;

/**
 *
 * @author Misaka
 */
public class Idojaras {
    public static void main(String[] args) {
        //http://api.openweathermap.org/data/2.5/weather?q=Budapest&appid=2018310bfdb382b812c131040caf5194
        //System.out.println(Modell.urlTeszt("Budapest"));
        Modell m= new Modell();
        m.csv2Lista();
    }
}
