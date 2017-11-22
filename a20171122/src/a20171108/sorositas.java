package a20171108;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Misaka
 */
class Diak  implements Serializable{
    String nev;
    Integer kor;
    Diak(){
    }
}
public class sorositas {
    private static void make() throws FileNotFoundException, IOException {
        Diak Sanyi= new Diak();
        Sanyi.nev="Nagy Sándor";
        Sanyi.kor=32;
        Diak Eszmeralda = new Diak();
        Eszmeralda.nev="Pityiger Eszmeralda";
        Eszmeralda.kor=42;
        Diak harom= new Diak();
        harom.nev=null;
        FileOutputStream fos = new FileOutputStream("data.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(Sanyi);
        oos.writeObject(Eszmeralda);
        oos.writeObject(harom);
        oos.close();
        fos.close();
    }
    private static void load() throws FileNotFoundException, IOException, ClassNotFoundException{
        Diak egy= new Diak();
        Diak ketto= new Diak();
        FileInputStream fis = new FileInputStream("data.txt");
        ObjectInputStream ois= new ObjectInputStream(fis);
        egy = (Diak) ois.readObject();
        ketto = (Diak) ois.readObject();
        ois.close();
        fis.close();
        System.out.println("Diak 1: "+egy.nev+" kora: "+egy.kor);
        System.out.println("Diak 2: "+ketto.nev+" kora: "+ketto.kor);
}
    private static void load2() throws FileNotFoundException, IOException, ClassNotFoundException{
        int i= 0;
        Diak egy= new Diak();
        ObjectInputStream ois;
        FileInputStream fis = new FileInputStream("data.txt");
        ois= new ObjectInputStream(fis);
        egy = (Diak) ois.readObject();
        while(egy.nev != null){
            System.out.println("Diak "+ i+" "+egy.nev+" kor: "+ egy.kor);
            egy = (Diak) ois.readObject();
            i++;
        }
        ois.close();
        fis.close();
    }
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        make();
        load2();
    }
}

