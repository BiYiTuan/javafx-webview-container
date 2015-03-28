package com.rubricode.javafxwebcontainer;

import static spark.Spark.*;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import spark.Request;
import spark.Response;
import spark.Route;


public class MainApp extends Application {
    private AnchorPane root;
    private Stage primarystage;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.startServer();
        this.primarystage = stage;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        root = (AnchorPane) loader.load();
        
        FXMLController controller = loader.getController();
        controller.setApplication(this);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        primarystage.setTitle("TeachSticks");
        primarystage.setScene(scene);
        primarystage.show();
    }

    @Override
    public void stop() throws Exception {
        spark.Spark.stop();
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void startServer() throws IOException {
        port(9000);
        staticFileLocation("/webapp/");
        get("/control", new Route() {
            @Override
            public Object handle(Request req, Response res) throws Exception {
                return "Hello Maven";
            }
        });
    }
    
    public void terminate() {
        try {
            this.stop();
        } catch(Exception e) {
            System.err.println("Could not stop the application");
        }
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
