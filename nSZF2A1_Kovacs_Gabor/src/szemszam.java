/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import a20170913.*;
import java.util.Scanner;

/**
 *
 * @author Misaka
 */
public class szemszam {
     public static void main(String[] args) {
        System.out.println("Hello Word!");
        Scanner SC = new Scanner(System.in);
        String sem = SC.nextLine();
        int osszeg = 0;
        int k = Integer.parseInt(sem.substring(10, 11));
        int sev = Integer.parseInt(sem.substring(1, 2)) * 10 + Integer.parseInt(sem.substring(2, 3));
        int j = 0;
        if (Integer.parseInt(sem.substring(0, 1)) < 3 && sev <= 96) {
            for (int i = 0; i < 10; i++) {
                j++;
                osszeg = osszeg + ((Integer.parseInt(sem.substring(i, j))) * j);
            }
            if (osszeg % 11 == k) {
                System.out.println("rendben");
            } else {
                hibas();
            }
        } else if (sev>96 ||Integer.parseInt(sem.substring(0, 1)) >= 3) {
            int sorzo = 10;
            for (int i = 0; i < 10; i++) {
                j++;
                osszeg = osszeg + Integer.parseInt(sem.substring(i, j)) * sorzo;
                sorzo--;
            }
            if (osszeg % 11 == Integer.parseInt(sem.substring(10, 11))) {
                System.out.println("rendben");
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
}
