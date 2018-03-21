/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a20180321;

/**
 *
 * @author Misaka
 */
public class Interfgyak{

    private final IRajzolMemoriaba Mya = new IRajzolMemoriaba() {
      @Override
      public void rajzol() { aRajz(); }
    };
    private final IRajolFormra Myb = new IRajolFormra() {
      @Override
      public void rajzol() { bRajz(); }
    };
    private final IRajzolNyomtat Myc = new IRajzolNyomtat() {
      @Override
      public void rajzol() { cRajz(); }
    };
    
    public final IRajzolMemoriaba asIRajzolMemoriaba() {
      return Mya;
    }
    public final IRajolFormra asIRajolFormra() {
      return Myb;
    }
    public final IRajzolNyomtat asIRajzolNyomtat() {
      return Myc;
    }
    public void aRajz(){
        System.out.println("Memória");
    }
    public void bRajz(){
        System.out.println("Formra");
    }
    public void cRajz(){
        System.out.println("Nyomtat");
    }
    
    public static void main(String[] args) {
        Interfgyak o = new Interfgyak();
        o.asIRajzolMemoriaba().rajzol();
        o.asIRajolFormra().rajzol();
        o.asIRajzolNyomtat().rajzol();
    }
}

interface IRajzolMemoriaba {
    public void rajzol();
}

interface IRajolFormra {
    public void rajzol();
}

interface IRajzolNyomtat {
    public void rajzol();
}
