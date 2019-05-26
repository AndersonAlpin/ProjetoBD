/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOFuncionario.ClienteDAOF;
import ModelFuncionario.ClienteF;
import Recursos.TextFieldFormatter;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Anderson
 */
public class ListaClientesController implements Initializable {

    @FXML
    private Label lbmostrarNome;
    @FXML
    private Label lbMostrarSobrenome;
    @FXML
    private Label lbMostrarCPF;
    @FXML
    private Label lbMostrarDataNascimento;
    @FXML
    private Label lbMostrarRenda;
    @FXML
    private Label lbMostrarProfissao;
    @FXML
    private Label lbMostrarTelefone;
    @FXML
    private Label lbMostrarLogradouro;
    @FXML
    private Label lbMostrarBairro;
    @FXML
    private Label lbMostrarCEP;
    @FXML
    private Label lbMostrarUF;
    @FXML
    private TableView<ClienteF> tableClientes;
    @FXML
    private TableColumn<ClienteF, String> clmNome;
    @FXML
    private TableColumn<ClienteF, String> clmSobrenome;
    @FXML
    private TableColumn<ClienteF, String> clmCPF;
    
    ClienteF selecionandoCliente;
    @FXML
    private JFXTextField tfFiltroCPF;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherTabelaClientes();
        
        tableClientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(
        ) {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionandoCliente = (ClienteF) newValue;
                
                if(!selecionandoCliente.equals("")){
                    listaClientes();
                }
            }
        });
    }    
    
    private void listaClientes(){
        
        lbmostrarNome.setText(selecionandoCliente.getNome());
        lbMostrarSobrenome.setText(selecionandoCliente.getSobrenome());
        lbMostrarCPF.setText(selecionandoCliente.getCPF());
        lbMostrarDataNascimento.setText(selecionandoCliente.getDataNascimentoFormatada());
        lbMostrarRenda.setText(selecionandoCliente.getRenda());
        lbMostrarProfissao.setText(selecionandoCliente.getProfissao());
        lbMostrarTelefone.setText(selecionandoCliente.getTelefone());
        lbMostrarLogradouro.setText(selecionandoCliente.getLogradouro());
        lbMostrarBairro.setText(selecionandoCliente.getBairro());
        lbMostrarCEP.setText(selecionandoCliente.getCEP());
        lbMostrarUF.setText(selecionandoCliente.getUF());
    }
    
    private void preencherTabelaClientes(){
        clmNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        clmSobrenome.setCellValueFactory(new PropertyValueFactory<>("Sobrenome"));
        clmCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        tableClientes.setItems(getClientes());
    }
    
    private ObservableList<ClienteF> getClientes(){
        ClienteDAOF daoI = new ClienteDAOF();
        return FXCollections.observableArrayList(daoI.getJoinClientes());
    }
    
    private void preencherTabelaClientesCPF(){
        clmNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        clmSobrenome.setCellValueFactory(new PropertyValueFactory<>("Sobrenome"));
        clmCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        tableClientes.setItems(getClientesCPF());
    }
    
    private ObservableList<ClienteF> getClientesCPF(){
        ClienteDAOF daoI = new ClienteDAOF();
        return FXCollections.observableArrayList(daoI.buscarCPF(tfFiltroCPF.getText()));
    }

    @FXML
    private void filtroCPF(KeyEvent event) {
        formatCPF();
        if(tfFiltroCPF.getText().length() > 0){
            preencherTabelaClientesCPF();
        }else {
            preencherTabelaClientes();
        }
    }
    
    private void formatCPF(){
        TextFieldFormatter formatar = new TextFieldFormatter();
        formatar.setMask("###.###.###-##");
        formatar.setCaracteresValidos("0123456789");
        formatar.setTf(tfFiltroCPF);
        formatar.formatter();
    }
}
