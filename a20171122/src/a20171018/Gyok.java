/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a20171018;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Misaka
 */
public class Gyok {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            double a = sc.nextDouble();
            double negyzet= Math.sqrt(a);
            if(Double.isNaN(negyzet)){
            throw new Exception();
            } 
            else{
                System.out.println(negyzet);
            }
        }
        catch(InputMismatchException ime){
            System.out.println("Csak számból lehet gyököt vonni!");
        }
        catch(Exception ex){
            System.out.println("Negatív számból nem lehet gyököt vonni!");
        }
    }
}
