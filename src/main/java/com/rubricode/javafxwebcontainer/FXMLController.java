package com.rubricode.javafxwebcontainer;

import com.rubricode.javafxbridge.Bridge;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class FXMLController implements Initializable {
    private MainApp app;
    @FXML
    private WebView ts_web_container;
    @FXML
    private MenuBar ts_menubar;
    @FXML
    private MenuItem menu_close_button;
    
    @FXML
    private void closeApplication() {
        this.app.terminate();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ts_menubar.setUseSystemMenuBar(true);
        WebEngine engine = ts_web_container.getEngine();
        engine.load("http://127.0.0.1:9000/");
        JSObject win = (JSObject) engine.executeScript("window");
        win.setMember("JFXBridge", new Bridge());
        engine.setOnAlert(new EventHandler<WebEvent<String>>() {
            @Override
            public void handle(WebEvent<String> event) {
                String message = event.getData();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("TeachSticks");
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.showAndWait();
            }
        });
    }  
    
    public void setApplication(MainApp app) {
        this.app = app;
    }
}
