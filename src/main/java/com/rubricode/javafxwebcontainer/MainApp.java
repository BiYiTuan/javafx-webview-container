package com.rubricode.javafxwebcontainer;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainApp extends Application {
    private AnchorPane root;
    private Stage primarystage;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primarystage = stage;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        root = (AnchorPane) loader.load();
        
        FXMLController controller = loader.getController();
        controller.setApplication(this);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        primarystage.setTitle("JavaFX and Maven");
        primarystage.setScene(scene);
        primarystage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
