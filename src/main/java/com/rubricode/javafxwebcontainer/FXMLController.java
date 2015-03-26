package com.rubricode.javafxwebcontainer;

import com.rubricode.javafxbridge.Bridge;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class FXMLController implements Initializable {
    private MainApp app;
    @FXML
    private WebView ts_web_container;
    @FXML
    private MenuBar ts_menubar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ts_menubar.setUseSystemMenuBar(true);
        WebEngine engine = ts_web_container.getEngine();
        engine.load("http://localhost:7000");
        JSObject win = (JSObject) engine.executeScript("window");
        win.setMember("JFXBridge", new Bridge());
    }  
    
    public void setApplication(MainApp app) {
        this.app = app;
    }
}
