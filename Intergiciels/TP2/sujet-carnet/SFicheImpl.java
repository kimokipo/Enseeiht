public class SFicheImpl implements SFiche{
    private String nom;
    private String email;

    public SFicheImpl(String nom, String email){
        this.nom = nom;
        this.email = email;
    }

    public String getNom(){
        return nom;
    }

    public String getEmail(){
        return email;
    }
}
