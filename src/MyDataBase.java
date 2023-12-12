import  java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MyDataBase {
    
    Connection con ;
    Statement stm=null; 
	ResultSet res;
    
    public MyDataBase(){

        String pilote="com.mysql.jdbc.Driver";
    	String url="jdbc:mysql://localhost/miniprojet";
    	String nom_utilisateur="root";
    	String motdepasse="";
    	
    	//1)Etape 1:	Charger un pilote driver ==>
    	try
    	{
    		Class.forName (pilote);
    	}
    	catch(ClassNotFoundException e)
    	{
    		System.err.println("Driver loading error: " + e); 
    	}
    	
    	//2)Etape 2:	Etablir une connexion ==>
    	try
    	{
    		con = DriverManager.getConnection(url,nom_utilisateur,motdepasse);
    	}
    	catch(SQLException e)
    	{
    		System.err.println("Error opening SQL connection: " + e); 
    	}
    	
    	
    	//3)Etape 3:	Cr�er un objet Statement ==>
    	try
    	{
    		stm = con.createStatement();
    	}
    	catch(SQLException e)
    	{
    		System.err.println("Error creating SQL statement: " + e); 
    	}
    }
    
    public Connection Connexion(){
        return con;
    }
	
    int ajouter (Personne p){
       try
    	{
    		int resUpd=stm.executeUpdate("INSERT INTO utilisateurs ( nom, genre) VALUES ('"+p.getNom()+"','"+p.getGenre()+"')");
    		return resUpd;
    	}
    	catch(SQLException e)
    	{
    		System.err.println("Error executing query: " + e); 
    	}
        return 0;
    }

     void remplirTab(DefaultTableModel model){

		try
    	{
    		model.setRowCount(0);
    		res=stm.executeQuery("SELECT * FROM utilisateurs;");
    		Object ligne[]=new Object[model.getColumnCount()];
    		while(res.next())
    		{
    			for(int i=0;i<ligne.length;i++)
    			{
    				ligne[i]=res.getString(i+1);
    			}
    			model.addRow(ligne);
    		}
    	}
    	catch(SQLException e)
    	{
    		System.err.println("Error executing query: " + e); 
    	}
		 
	}

}
