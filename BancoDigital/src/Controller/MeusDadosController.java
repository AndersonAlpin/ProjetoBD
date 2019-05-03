/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
public class MeusDadosController implements Initializable {

    @FXML
    private Label lbMostrarTelefone;
    @FXML
    private Label lbMostrarEmail;
    @FXML
    private Label lbMostrarSobrenome;
    @FXML
    private Label lbmostrarNome;
    @FXML
    private Label lbMostrarRenda;
    @FXML
    private Label lbMostrarProfissao;
    @FXML
    private Label lbMostrarLogradouro;
    @FXML
    private Label lbMostrarBairro;
    @FXML
    private Label lbMostrarCEP;
    @FXML
    private Label lbMostrarUF;
    @FXML
    private JFXComboBox<?> cbRenda;
    @FXML
    private JFXComboBox<?> cbUF;
    @FXML
    private JFXTextField tfProfissao;
    @FXML
    private JFXTextField tfTelefone;
    @FXML
    private JFXTextField tfLogradouro;
    @FXML
    private JFXTextField tfBairro;
    @FXML
    private JFXTextField tfCEP;
    @FXML
    private Label lbSenha;
    @FXML
    private JFXPasswordField tfSenha;
    @FXML
    private JFXButton btEditar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXButton btSalvar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    private void limparFormularios(){
        cbRenda.getSelectionModel().clearSelection();
        cbUF.getSelectionModel().clearSelection();
        tfBairro.setText("");
        tfCEP.setText("");
        tfLogradouro.setText("");
        tfProfissao.setText("");
        tfSenha.setText("");
        tfTelefone.setText("");
    }
    
    @FXML
    private void editarMinhaConta(ActionEvent event) {
        btEditar.setVisible(false);
        btSalvar.setVisible(true);
        btCancelar.setVisible(true);
        lbSenha.setVisible(true);
        cbRenda.setVisible(true);
        cbUF.setVisible(true);
        tfBairro.setVisible(true);
        tfCEP.setVisible(true);
        tfLogradouro.setVisible(true);
        tfProfissao.setVisible(true);
        tfSenha.setVisible(true);
        tfTelefone.setVisible(true);
        
        limparFormularios();
    }

    @FXML
    private void cancelarEdicao(ActionEvent event) {
        btEditar.setVisible(true);
        btSalvar.setVisible(false);
        btCancelar.setVisible(false);
        lbSenha.setVisible(false);
        cbRenda.setVisible(false);
        cbUF.setVisible(false);
        tfBairro.setVisible(false);
        tfCEP.setVisible(false);
        tfLogradouro.setVisible(false);
        tfProfissao.setVisible(false);
        tfSenha.setVisible(false);
        tfTelefone.setVisible(false);
    }

    @FXML
    private void salvarEdicao(ActionEvent event) {
        cancelarEdicao(event);
    }
    
}
