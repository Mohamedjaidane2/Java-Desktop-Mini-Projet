
import java.awt.*;

public class MyThread extends Thread {
    
//attribut
    
    Graphics g;
    MyList ml;
        
//constructeur

    public MyThread(MyList ml){
        this.ml=ml;
    }

    public void run(){
        
        System.out.println(this.getName());
        while(true) {
            
            try {
                ml.mdb.remplirTab(ml.model);
                histogramme(nbrPersonnes());
                axesXY(nbrPersonnes(), "genre", "nbr des personne");
                sleep(1000); 
			}
			catch(Exception e){}

            
            
		}   

    }
    int nbrPersonnes(){
        return ml.model.getRowCount();
    }
    int nbrHomme(){
        int taille=nbrPersonnes();
        int nbr=0;
        for (int i=0;i<taille;i++){
            if(ml.model.getValueAt(i, 2).equals("Homme")){
                nbr++;
            }
        }
        return nbr;
    }
    public void histogramme(int nbrPersonnes){
        Dimension d = ml.cv.getSize();
        int nbrHomme=nbrHomme();
        int nbrFemme=nbrPersonnes-nbrHomme;
        System.out.println("nbrFemme"+nbrFemme);
        System.out.println("nbrhomme"+nbrHomme);
        
        ml.g.setColor(Color.WHITE);
        ml.g.fillRect(d.width-100,10 ,10 ,10 );
        ml.g.drawString("Homme", d.width-100, 40);
        ml.g.drawString("Homme = "+nbrHomme, d.width-100, 60);
        
        ml.g.setColor(Color.pink);
        ml.g.fillRect(d.width-100,80 ,10 ,10);
        ml.g.drawString("Femme", d.width-100, 110);
        ml.g.drawString("Femme = "+nbrFemme, d.width-100, 130);

        ml.g.setColor(Color.green);
        ml.g.drawString("nbr personne = "+nbrPersonnes, d.width/2-100, 150);


        ml.g.setColor(Color.WHITE);
        ml.g.fillRect( (d.width/2)-150,(d.height-10)-nbrHomme,50,nbrHomme);
        
        ml.g.setColor(Color.PINK);
        ml.g.fillRect( (d.width/2)-50,(d.height-10)-nbrFemme,50,nbrFemme);

        
    }   
    public void axesXY(int nbrPersonnes, String labelX, String labelY){
         Dimension d = ml.cv.getSize();

        ml.g.setColor(Color.green);
        ml.g.drawString(labelY,25,20);
        ml.g.drawString(labelX,d.width-50, (d.height-30));
        ml.g.setColor(Color.green);
        ml.g.drawLine(0,(d.height-10), d.width,(d.height-10)); 
        ml.g.drawLine(10,0, 10,d.height); 


        
    }
}
