/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.LoginCadastro;
import Main.MainCliente;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anderson
 */
public class LoginCadastroController implements Initializable {

    @FXML
    private Rectangle cartao;
    @FXML
    private JFXTextField tfCPFLogin;
    @FXML
    private JFXPasswordField tfSenhaLogin;
    @FXML
    private JFXTextField tfNome;
    @FXML
    private JFXTextField tfSobrenome;
    @FXML
    private JFXTextField tfCPFCadastro;
    @FXML
    private JFXDatePicker dpNascimento;
    @FXML
    private JFXComboBox<?> cbSexo;
    @FXML
    private JFXTextField tfProfissao;
    @FXML
    private JFXComboBox<?> cbSexo1;
    @FXML
    private JFXTextField tfTelefone;
    @FXML
    private JFXTextField tfLogradouro;
    @FXML
    private JFXTextField tfCEP;
    @FXML
    private JFXTextField tfBairro;
    @FXML
    private JFXComboBox<?> cbUF;
    @FXML
    private JFXTextField tfSenhaCadastro;
    @FXML
    private JFXTextField tfConfirmarSenhaCadastro;
    @FXML
    private AnchorPane anchorLogin;
    @FXML
    private AnchorPane anchorCadastro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        propriedadesCartao();
    }    
    
    private void propriedadesCartao(){
        cartao.setArcHeight(20.0);
        cartao.setArcWidth(30.0); 
    }
    
    @FXML
    private void abrirCadastro(ActionEvent event) {
        anchorCadastro.setVisible(true);
        anchorLogin.setVisible(false);
    }

    @FXML
    private void tfCPFLoginFormat(KeyEvent event) {
    }

    @FXML
    private void abrirCliente(ActionEvent event) {
        try {
            MainCliente c = new MainCliente();
            LoginCadastro.getStage().close();
            c.start(new Stage());
        } catch (Exception e) {
        }
    }

    @FXML
    private void tfCPFCadastroFormat(KeyEvent event) {
    }

    @FXML
    private void tfTelefoneFormat(KeyEvent event) {
    }

    @FXML
    private void tfCEPFormat(KeyEvent event) {
    }

    @FXML
    private void confirmarCadastro(ActionEvent event) {
        anchorLogin.setVisible(true);
        anchorCadastro.setVisible(false);
    }

    @FXML
    private void voltarLogin(ActionEvent event) {
        anchorLogin.setVisible(true);
        anchorCadastro.setVisible(false);
    }
    
}
