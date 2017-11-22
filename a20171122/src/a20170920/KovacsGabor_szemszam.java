/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a20170920;

import a20170913.*;
import java.util.Scanner;

/**
 *
 * @author Misaka
 */
public class KovacsGabor_szemszam {
     public static void main(String[] args) {
        System.out.println("Helló kérem a személyi számot!");
        Scanner SC = new Scanner(System.in);
        String sem = SC.nextLine();
        int osszeg = 0;
        int k = Integer.parseInt(sem.substring(10, 11));
        int sev = Integer.parseInt(sem.substring(1, 2)) * 10 + Integer.parseInt(sem.substring(2, 3));
        int j = 0;
        if (sev <= 96) {
            for (int i = 0; i < 10; i++) {
                j++;
                osszeg = osszeg + ((Integer.parseInt(sem.substring(i, j))) * j);
            }
            if (osszeg % 11 == k) {
                System.out.println("Rendben");
                nem(Integer.parseInt(sem.substring(0, 1)));
            } else {
                hibas();
            }
        } else if (sev>96) {
            int sorzo = 10;
            for (int i = 0; i < 10; i++) {
                j++;
                osszeg = osszeg + Integer.parseInt(sem.substring(i, j)) * sorzo;
                sorzo--;
            }
            if (osszeg % 11 == Integer.parseInt(sem.substring(10, 11))) {
                System.out.println("Rendben");
                nem(Integer.parseInt(sem.substring(0, 1)));
            } else {
                hibas();
            }

        } else {
            hibas();
        }
    }
    
    private static void hibas() {
        System.out.println("rossz");
    }
    private static void nem(int nem){
        int nemek = nem;
    if (nemek%2==0) {
                    System.out.println("nő");
                }
                else{
                    System.out.println("férfi");
                }
    
    if (nemek>4) {
        System.out.println("Kései magyar");
    }  
    else{
        System.out.println("igaz magyar");
    }
    }
}
