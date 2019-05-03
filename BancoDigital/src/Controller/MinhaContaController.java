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

/**
 * FXML Controller class
 *
 * @author Anderson
 */
public class MinhaContaController implements Initializable {

    @FXML
    private Label lbMostrarValidade;
    @FXML
    private Label lbMostrarDigito;
    @FXML
    private Label lbMostrarConta;
    @FXML
    private Label lbMostrarAgencia;
    @FXML
    private Label lbMostrarSenha;
    @FXML
    private Label lbDadosPessoaisOuCadastro;
    @FXML
    private JFXButton btStatusSenha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void statusSenha(ActionEvent event) {
        if(lbMostrarSenha.getText().equals("****")){
            btStatusSenha.setText("Ocultar");
            lbMostrarSenha.setText("1234");
        }else{
            btStatusSenha.setText("Mostrar");
            lbMostrarSenha.setText("****");
        }
    }
    
}
