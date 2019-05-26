/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOFuncionario.AgenciaDAO;
import DAOFuncionario.RelatorioFinanceiroDAO;
import ModelFuncionario.Agencia;
import ModelCliente.RelatorioFinanceiro;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Anderson
 */
public class RelatorioFinanceiroController implements Initializable {

    @FXML
    private TableView<RelatorioFinanceiro> tableRelatorio;
    @FXML
    private TableColumn<RelatorioFinanceiro, String> clmData;
    @FXML
    private TableColumn<RelatorioFinanceiro, String> clmDescricao;
    @FXML
    private TableColumn<RelatorioFinanceiro, String> clmEntrada;
    @FXML
    private TableColumn<RelatorioFinanceiro, String> clmSaida;
    @FXML
    private TableColumn<RelatorioFinanceiro, String> clmSaldo;
    @FXML
    private Label lbEntrada;
    @FXML
    private Label lbSaida;
    @FXML
    private Label lbSaldo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherRelatorio();
        somaExtrato();
    }    

    @FXML
    private void gerarCSV(ActionEvent event) {
        RelatorioFinanceiroDAO daoR = new RelatorioFinanceiroDAO();
        daoR.gerarCSV(1);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Banco Digital");
        alert.setHeaderText("O Relatório foi exportado.");
        alert.setContentText("Verifique sua área de trabalho.");
        alert.showAndWait();
    }
    
    private void preencherRelatorio(){
        clmData.setCellValueFactory(new PropertyValueFactory<>("dataFormatada"));
        clmDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        clmEntrada.setCellValueFactory(new PropertyValueFactory<>("entradaFormatada"));
        clmSaida.setCellValueFactory(new PropertyValueFactory<>("saidaFormatada"));
        clmSaldo.setCellValueFactory(new PropertyValueFactory<>("saldoFormatado"));
        
        tableRelatorio.setItems(relatorio());
    }
    
    public ObservableList<RelatorioFinanceiro> relatorio(){
            
        RelatorioFinanceiroDAO daoR = new RelatorioFinanceiroDAO();
        return FXCollections.observableArrayList(daoR.getList(1));
    }
    
    private void somaExtrato(){
        AgenciaDAO daoC = new AgenciaDAO();
        List<Agencia> caixa = daoC.getSaldoCaixa();
        
        RelatorioFinanceiroDAO daoR = new RelatorioFinanceiroDAO();
        List<RelatorioFinanceiro> relatorio = daoR.getSomaRelatorio(1);
        
        try {
            if(relatorio.isEmpty() == false){
                lbEntrada.setText(relatorio.get(0).getEntradaFormatada());
                lbSaida.setText(relatorio.get(0).getSaidaFormatada());
                lbSaldo.setText(caixa.get(0).getSaldoFormatado());
            }
        } catch (Exception e) {
        }
    }
    
}
