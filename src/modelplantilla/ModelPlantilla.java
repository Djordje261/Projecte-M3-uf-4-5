 
package modelplantilla;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

 
public class ModelPlantilla extends Application{

     
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
         Parent root=FXMLLoader.load(getClass().getResource("Finestra.fxml"));
         Scene scene=new Scene(root);
         stage.setTitle("Aplicació JavaFX");
         stage.setScene(scene);
         stage.show();

    }
    
}
