import javax.swing.*;
import java.awt.*;

public class MyForm extends JFrame {
    //les composant graphique
    JLabel lExamen = new JLabel("Examen");
    JLabel lNom = new JLabel("Nom");
    JLabel lGenre = new JLabel("Genre");
    JLabel lInformation = new JLabel("Information");
    JTextField tNom = new JTextField();
    JRadioButton rHomme=new JRadioButton("Homme");
    JRadioButton rFemme =new JRadioButton("Femme");
    JButton bAjouter = new JButton("Ajouter");
    JButton bList = new JButton("Liste");
    JPanel pGendre=new JPanel();
    JPanel pmain=new JPanel();
    JPanel pActionsGroup=new JPanel();
    
    //constructeur
    public MyForm(){

        this.setTitle("Examen");
        this.setSize(500, 400);
        this.setLocationRelativeTo(getParent());
        this.setDefaultCloseOperation(3);
        //Gender Section 
        pGendre.setLayout(new GridLayout(1,2));
        add(pGendre,rHomme,rFemme);
        //Main Section
        pmain.setLayout(new GridLayout(2,2));
        add(pmain,lNom,tNom,lGenre,pGendre);
        pmain.setBorder(BorderFactory.createTitledBorder("Informations"));
        //Action button group section
        pActionsGroup.setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(pActionsGroup,bList,bAjouter);
        //container
        Container C =getContentPane();
        C.setLayout(new BorderLayout());
        C.add("North",lExamen);
        C.add("Center",pmain);
        C.add("South",pActionsGroup);
        lExamen.setHorizontalAlignment(SwingConstants.CENTER); 
        pack();
        setVisible(true);
        //ecouteur
        MyEvents me=new MyEvents(this);
    	bAjouter.addActionListener(me);
        bList.addActionListener((e)-> new MyList());
    	
    }
    
    //add function
    public void add(Component ...comp ) {
        JPanel p=(JPanel)comp[0];

        for (int i=1 ; i<comp.length;i++){
            p.add(comp[i]);
        }
    }  
    public static void main(String[] args) {
        new MyForm();
    }
}
