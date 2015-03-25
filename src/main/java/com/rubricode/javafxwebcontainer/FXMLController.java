package com.rubricode.javafxwebcontainer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class FXMLController implements Initializable {
    @FXML
    private WebView ts_web_container;
    @FXML
    private MenuBar ts_menubar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ts_menubar.setUseSystemMenuBar(true);
        WebEngine engine = ts_web_container.getEngine();
        engine.load("http://localhost:3000");
    }  
    
    public void setApplication(MainApp app) {
    
    }
}
