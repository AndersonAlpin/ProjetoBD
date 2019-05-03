/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Anderson
 */
public class PagamentosController implements Initializable {

    @FXML
    private TextField tfCodigo;
    @FXML
    private Label lbDescricao;
    @FXML
    private Label lbSenha;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private PasswordField tfSenha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmarValor(ActionEvent event) {
    }
    
}
