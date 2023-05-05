package modelplantilla;

public class Caixer {

    private int numero;
    private String adreça;

    private int usuariActiu = -1;
    static final int MAXINTENTS = 3; // definim una constant per desar màxim intents de login

    private String missatge;

    private Client[] clients = {
        new Client("Joan Garcia Dalmau",
        "jgarcia", "12345", new CompteCorrent(2000)),
        new Client("Maria Suarez Ponts",
        "msuarez", "12345", new CompteCorrent(3000)),
        new Client("Joana Sants Diaz",
        "jsants", "12345", new CompteCorrent(5000)),
        new Client("Carla Solans Linares",
        "csolans", "12345", new CompteCorrent(8000)),
        new Client("Enric Roig Marcos",
        "eroig", "12345", new CompteCorrent(100)),};

    private Bitllet[] bitllets = {
        new Bitllet(100, 10),
        new Bitllet(50, 10),
        new Bitllet(20, 10),
        new Bitllet(10, 20),
        new Bitllet(5, 30)
    };

    boolean login(String username, String password) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getUsername().equals(username)) {
                if (!clients[i].isBloquejat()) {
                    if (clients[i].getPassword().equals(password)) {
                        usuariActiu = i;//guardo qui s'ha connectat
                        missatge = "Usuari i password correctes.";
                        return true;
                    } else {
                        clients[i].setNumIntents(clients[i].getNumIntents() + 1);
                        missatge = "Password incorrecte";
                        if (clients[i].getNumIntents() == MAXINTENTS) {
                            clients[i].setBloquejat(true);
                            missatge = missatge + ". Estàs bloquejat.";
                        }
                        return false;
                    }
                } else {
                    missatge = "Estàs bloquejat!!";
                }
            }
        }
        missatge = "Usuari incorrecte!";
        return false;
    }

    public boolean treureDiners(double quantitat) {
        if (usuariActiu == -1) {
            return false;
        }

        if (!mostraCanvi((int) quantitat)) {
            return false;
        }
        if (clients[usuariActiu].getCc().extreure(quantitat)) {
            missatge = "Has extret " + quantitat + " euros.";
            return true;
        }
        missatge = "No tens diners suficients";
        return false;
    }

    public boolean posarDiners(double quantitat) {
        if (usuariActiu == -1) {
            return false;
        }
        clients[usuariActiu].getCc().ingressar(quantitat);
        missatge = "Has ingressat " + quantitat + " euros.";
        return true;
    }

    public double mostrarSaldo() {
        if (usuariActiu == -1) {
            return -1;
        }
        return clients[usuariActiu].getCc().getSaldo();
    }

    public boolean mostraCanvi(int quantitat) {
        String resultat = "";

        int restants = quantitat;
        for (int i = 0; i < bitllets.length; i++) {

            resultat = resultat + "Bitllets de " + bitllets[i].getValor() + " euros: ";

            int num = restants / bitllets[i].getValor();
            if (bitllets[i].getQuantitat() >= num) {
                bitllets[i].setQuantitat(bitllets[i].getQuantitat() - num);
            } else {
                num = bitllets[i].getQuantitat();
            }

            restants = restants - (bitllets[i].getValor() * num);
            resultat = resultat + num + "\n";

        }
        if (restants != 0) {
            missatge = "No és possible donar aquesta quantitat";
            return false;
        }

        missatge = resultat;
        return true;

    }

    public String getMissatge() {
        return missatge;
    }

    public boolean canviarClauUsuari(String password) {
        if (usuariActiu == -1) {
            return false;
        }
        clients[usuariActiu].setPassword(password);
        missatge = "Password canviat";
        return true;
    }

}
