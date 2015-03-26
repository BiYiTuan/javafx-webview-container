package com.rubricode.javafxwebcontainer;

import com.rubricode.javafxwebcontainer.api.GreetingResource;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.glassfish.grizzly.http.server.*;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


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
    public void startServer() throws IOException {
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer( java.net.URI.create("http://localhost:7000/api"), new ResourceConfig(GreetingResource.class));

        StaticHttpHandler staticHttpHandler = new StaticHttpHandler("src/main/webapp");
        server.getServerConfiguration().addHttpHandler(staticHttpHandler, "/");

        System.in.read();
        server.stop();
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
