package a20171025;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Misaka
 */
public class Vissza {
    public static void main(String[] args) {
        try {
            
            File f = new File("C:\\Users\\Misaka\\Desktop\\vissza.txt");
            Scanner sc = new Scanner(f,"UTF-8");
            StringBuilder line=new StringBuilder();
            line.append("");
            while (sc.hasNext()){
                if (sc.nextLine().length()>line.length()) {
                    line.delete(0, line.length());
                    line.append(sc.nextLine());
                }
            }
            System.out.println(line);
            System.out.println(line.reverse());
        } catch (FileNotFoundException ex) {
            System.out.println("Fájl nem található!");
        }
    }
}