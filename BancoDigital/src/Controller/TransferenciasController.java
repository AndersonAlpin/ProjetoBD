/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class TransferenciasController implements Initializable {

    @FXML
    private TextField tfAgencia;
    @FXML
    private TextField tfConta;
    @FXML
    private TextField tfDigito;
    @FXML
    private TextField tfValor;
    @FXML
    private PasswordField tfSenha;
    @FXML
    private Label lbMostrarFavorecido;
    @FXML
    private Label lbFavorecido;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmarTransferência(ActionEvent event) {
    }
    
}
