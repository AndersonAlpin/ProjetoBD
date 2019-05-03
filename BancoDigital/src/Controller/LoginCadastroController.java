/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.LoginCadastro;
import Main.MainCliente;
import Recursos.TextFieldFormatter;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
    @FXML
    private JFXComboBox<?> cbRenda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        propriedadesCartao();
        preencherComboBoxRenda();
        preencherComboBoxSexo();
        preencherComboBoxUF();
        limparFormularios();
    }    
    
    //Métodos criados pessoalmente
    
    private void propriedadesCartao(){
        cartao.setArcHeight(20.0);
        cartao.setArcWidth(30.0); 
    }
    
    private void gerarContaCliente(){
        Random gerar = new Random();
        String conta = "100";
        String digito = "";
        String senha = "";
        
        for(int i = 1; i <= 4; i++){
           conta += gerar.nextInt(10);
        }
        
        for(int i = 1; i <= 4; i++){
           senha += gerar.nextInt(10);
        }
        
        digito += gerar.nextInt(10);
    }
    
    private void preencherComboBoxRenda(){
        List renda = new ArrayList();
        renda.add("Inferior a R$ 998,00");
        renda.add("Entre R$ 998,00 e R$ 1.996,00");
        renda.add("Entre R$ 1.996,00 e R$ 3.992,00");
        renda.add("Superior à R$ R$ 3.992,00");
        
        cbRenda.setItems(FXCollections.observableArrayList(renda));
    }
    
    private void preencherComboBoxSexo(){
        List sexo = new ArrayList();
        sexo.add("Masculino");
        sexo.add("Feminino");
        
        cbSexo.setItems(FXCollections.observableArrayList(sexo));
    }
    
    private void preencherComboBoxUF(){
        List uf = new ArrayList();
        uf.add("AC");
        uf.add("AL");
        uf.add("AM");
        uf.add("AP");
        uf.add("BA");
        uf.add("CE");
        uf.add("DE");
        uf.add("ES");
        uf.add("GO");
        uf.add("MA");
        uf.add("MG");
        uf.add("MS");
        uf.add("MT");
        uf.add("PA");
        uf.add("PB");
        uf.add("PE");
        uf.add("PI");
        uf.add("PR");
        uf.add("RJ");
        uf.add("RN");
        uf.add("RO");
        uf.add("RR");
        uf.add("RS");
        uf.add("SC");
        uf.add("SE");
        uf.add("SP");
        uf.add("TO");
        
        cbUF.setItems(FXCollections.observableArrayList(uf));
    }
    
    private void limparFormularios(){
        cbRenda.getSelectionModel().clearSelection();
        cbSexo.getSelectionModel().clearSelection();
        cbUF.getSelectionModel().clearSelection();
        tfBairro.setText("");
        tfCEP.setText("");
        tfCPFCadastro.setText("");
        tfCPFLogin.setText("");
        tfConfirmarSenhaCadastro.setText("");
        tfLogradouro.setText("");
        tfNome.setText("");
        tfProfissao.setText("");
        tfSenhaCadastro.setText("");
        tfSenhaLogin.setText("");
        tfSobrenome.setText("");
        tfTelefone.setText("");
    }
    
    //Métodos criado pelo FXML
    
    @FXML
    private void abrirCadastro(ActionEvent event) {
        anchorCadastro.setVisible(true);
        anchorLogin.setVisible(false);
        limparFormularios();
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
    private void tfCPFLoginFormat(KeyEvent event) {
        TextFieldFormatter formatar = new TextFieldFormatter();
        formatar.setMask("###.###.###-##");
        formatar.setCaracteresValidos("0123456789");
        formatar.setTf(tfCPFLogin);
        formatar.formatter();
    }
    
    @FXML
    private void tfCPFCadastroFormat(KeyEvent event) {
        TextFieldFormatter formatar = new TextFieldFormatter();
        formatar.setMask("###.###.###-##");
        formatar.setCaracteresValidos("0123456789");
        formatar.setTf(tfCPFCadastro);
        formatar.formatter();
    }

    @FXML
    private void tfTelefoneFormat(KeyEvent event) {
        TextFieldFormatter formatar = new TextFieldFormatter();
        formatar.setMask("(##)#####-####");
        formatar.setCaracteresValidos("0123456789");
        formatar.setTf(tfTelefone);
        formatar.formatter();
    }

    @FXML
    private void tfCEPFormat(KeyEvent event) {
        TextFieldFormatter formatar = new TextFieldFormatter();
        formatar.setMask("#####-###");
        formatar.setCaracteresValidos("0123456789");
        formatar.setTf(tfCEP);
        formatar.formatter();
    }

    @FXML
    private void confirmarCadastro(ActionEvent event) {
        anchorLogin.setVisible(true);
        anchorCadastro.setVisible(false);
        limparFormularios();
    }

    @FXML
    private void voltarLogin(ActionEvent event) {
        anchorLogin.setVisible(true);
        anchorCadastro.setVisible(false);
        limparFormularios();
    }
    
}
