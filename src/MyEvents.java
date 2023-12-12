import java.awt.event.*;

public class MyEvents implements ActionListener {
    //attribut
    
    MyForm mf;
    MyDataBase mdb ;
    Personne p = new Personne();
    
    //constructeur

    public MyEvents(MyForm mf){
        this.mf=mf;
        mdb = new MyDataBase();

    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()== mf.bAjouter){
            String genre ="Homme";
            if(mf.rFemme.isSelected()){
                genre="Femme";
                p.setGenre(genre);
                p.setNom(mf.tNom.getText());
                mdb.ajouter(p);
            }else{
                p.setGenre(genre);
                p.setNom(mf.tNom.getText());
                mdb.ajouter(p); 
            }
        }

    }

}
