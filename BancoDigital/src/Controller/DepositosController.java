/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXTextField;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Anderson
 */
public class DepositosController implements Initializable {

    @FXML
    private Pane paneGerarBoleto;
    @FXML
    private Pane paneReceberBoleto;
    @FXML
    private JFXTextField tfValor;
    @FXML
    private Label lbVencimento;
    @FXML
    private Label lbCodigo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmarValor(ActionEvent event) {
        paneGerarBoleto.setVisible(false);
        paneReceberBoleto.setVisible(true);
        gerarCodigoDeBarras();
    }

    @FXML
    private void copiarCodigo(ActionEvent event) {
        java.awt.datatransfer.Clipboard copiar = Toolkit.getDefaultToolkit().getSystemClipboard();
        ClipboardOwner selecao = new StringSelection(lbCodigo.getText());
        copiar.setContents((Transferable) selecao, selecao);
    }

    @FXML
    private void gerarNovoCodigo(ActionEvent event) {
        paneGerarBoleto.setVisible(true);
        paneReceberBoleto.setVisible(false);
        lbCodigo.setText("");
    }
    
    private void gerarCodigoDeBarras(){
        Random gerador = new Random();
        String codigo = "";
        for(int i = 1; i <= 44; i++){
            codigo += "" + gerador.nextInt(10);
        }
        lbCodigo.setText(codigo);
    }

    @FXML
    private void tfFormatDinheiro(KeyEvent event) {
        
    }
    
}
