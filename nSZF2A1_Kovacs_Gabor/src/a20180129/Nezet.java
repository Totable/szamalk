package a20180129;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Nezet extends JFrame {
  private final ModellCsv MODELL; //=null;
  private DefaultMutableTreeNode faGyoker=
    new DefaultMutableTreeNode("Település -> Településrész");
  private DefaultTreeModel faModell=new DefaultTreeModel(faGyoker);
  private JTree tFa=new JTree(faModell);
  
  public Nezet(final ModellCsv MODELL) {
    this.MODELL=MODELL;
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Geolista 1.0");
    setSize(500, 400);
    setLocationRelativeTo(this);
    setResizable(false);
    //setUndecorated(true);
    setLayout(new BorderLayout());
    add(new JScrollPane(tFa));
    faEpit();
  }  

  private void faEpit() {
    ArrayList<TelepulesTelepulesresz> lista=MODELL.getGeoLista();
    int i=0;
    //1
    while(i<lista.size()) {
      //2
      String aktTelepules=lista.get(i).getTelepules();
      DefaultMutableTreeNode faTelepules=new DefaultMutableTreeNode(aktTelepules);
      faGyoker.add(faTelepules);
      while(i<lista.size() && lista.get(i).getTelepules().equals(aktTelepules)) {
        //3
        faTelepules.add(new DefaultMutableTreeNode(lista.get(i).getTelepulesresz()));
        i++;
      }
      //4
    }
    //5
    
  }
}
