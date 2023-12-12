import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyList extends JFrame {

    //les composant graphiques
    String entete[]={"Id","Nom","Genre"};
    String donneé [][]=new String [0][0];
    DefaultTableModel model=new DefaultTableModel(entete,0);
    JTable tab =new JTable(model);
    JScrollPane sp = new JScrollPane(tab);
    DefaultTableModel DefaultTableModel ;

    //graphique
    Canvas cv = new Canvas();
    Graphics g ;
   
    //les attributes
    MyDataBase mdb=new MyDataBase();
    MyThread mt =new MyThread(this) ;
    //constructeur
    public MyList(){
        
        this.setTitle("Examen");
        this.setLocationRelativeTo(getParent());
        this.setSize(500,400);
        this.setDefaultCloseOperation(3);
        
        sp.setBorder(BorderFactory.createTitledBorder("Liste des Utilsateur"));
        cv.setBackground(Color.DARK_GRAY);
        Container C =getContentPane();
        
        C.setLayout(new GridLayout(2,0));
        add(C,sp,cv);
        pack();     
        setVisible(true);
        g=cv.getGraphics(); 
        mt.start();
        
    }

    public void add(Component ...comp ) {
        JPanel p=(JPanel)comp[0];

        for (int i=1 ; i<comp.length;i++){
            p.add(comp[i]);
        }
    }

}



