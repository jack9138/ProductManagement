package Controles;



import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/**
 *
 * @author jaque
 */
public class Main  extends Application{
    
    static Stage stage;
    
    @Override 
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Views/Login.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();

    }
    
    public static void main(String[] args){
        launch(args);
    }

}
