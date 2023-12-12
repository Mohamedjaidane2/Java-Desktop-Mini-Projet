public class Personne {
    
//declaration des attributs

    private String nom;
    private String genre;
    private int id;

// les constructeurs

    public Personne(){
        this.genre="NaN";
        this.nom="NaN";
    }
    public Personne(int id , String nom , String genre ){
        this.genre=genre;
        this.id=id;
        this.nom=nom;
    }
    public Personne(String nom , String genre){
        this.genre=genre;
        this.nom=nom;
    }
    
//Getter and Setter

    public String getNom() {
        return nom;
        }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
