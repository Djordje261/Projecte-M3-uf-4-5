package modelplantilla;

public class Client {
       private String nom;
       
       private String username;
       
       private String password;
       private CompteCorrent cc;
       
       private int numIntents;
       private boolean bloquejat;

    public Client(String nom, String username, String password, CompteCorrent cc) {
        this.nom = nom;
        this.username = username;
        this.password = password;
        this.cc = cc;
        
        this.numIntents = 0;
        this.bloquejat = false;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CompteCorrent getCc() {
        return cc;
    }

    public void setCc(CompteCorrent cc) {
        this.cc = cc;
    }

    public int getNumIntents() {
        return numIntents;
    }

    public void setNumIntents(int numIntents) {
        this.numIntents = numIntents;
    }

    public boolean isBloquejat() {
        return bloquejat;
    }

    public void setBloquejat(boolean bloquejat) {
        this.bloquejat = bloquejat;
    }
    
    
       
}
