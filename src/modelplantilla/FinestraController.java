package modelplantilla;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FinestraController implements Initializable {

    Caixer caixer = new Caixer();

    @FXML
    private AnchorPane loginpane;

    @FXML
    private TextField usernametxt;

    @FXML
    private PasswordField passwordtxt;

    @FXML
    private Button loginbutton;

    @FXML
    private TextArea missatgetxt;

    @FXML
    private AnchorPane caixerpane;

    @FXML
    private TextField quantitattxt;
    private int quantitat = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.caixer = new Caixer();

        caixerpane.setVisible(false);
        quantitattxt.setText("0");

    }

    public void validaUsuari() {

        String usr = usernametxt.getText();
        String passwd = passwordtxt.getText();
        boolean isValid = caixer.login(usr, passwd);
        String missatge = caixer.getMissatge();
        missatgetxt.setText(missatge);

        if (isValid) {
            missatgetxt.setText(" Benvingut " + usr + "!");
            loginpane.setVisible(false);
            caixerpane.setVisible(true);
        }

    }

    @FXML
    private void euros5() {
        quantitat = quantitat + 5;
        quantitattxt.setText(String.valueOf(quantitat));
    }

    @FXML
    private void euros10() {
        quantitat = quantitat + 10;
        quantitattxt.setText(String.valueOf(quantitat));
    }

    @FXML
    private void euros20() {
        quantitat = quantitat + 20;
        quantitattxt.setText(String.valueOf(quantitat));
    }

    @FXML
    private void euros50() {
        quantitat = quantitat + 50;
        quantitattxt.setText(String.valueOf(quantitat));
    }

    @FXML
    private void euros100() {
        quantitat = quantitat + 100;
        quantitattxt.setText(String.valueOf(quantitat));
    }

    @FXML
    private void euros0() {
        quantitat = 0;
        quantitattxt.setText(String.valueOf(quantitat));
    }

    @FXML
    private void mostrarSaldo() {

        double diners = caixer.mostrarSaldo();
        missatgetxt.setText("Tens un saldo de " + diners + "€");

    }

    @FXML
    private void ingressar() {

        caixer.posarDiners(quantitat);
        String missatge = caixer.getMissatge();
        missatgetxt.setText(missatge);

    }

    @FXML
    private void extreure() {

        boolean treure = caixer.treureDiners(quantitat);
        String missatge = caixer.getMissatge();

        if (treure) {
            caixer.mostraCanvi(quantitat);
            missatge = caixer.getMissatge();
        }
        missatgetxt.setText(missatge);

    }

    @FXML
    private void logout() {

        usernametxt.setText("");
        passwordtxt.setText("");
        missatgetxt.setText("Has tancat la sessió.");
        loginpane.setVisible(true);
        caixerpane.setVisible(false);

    }

}
