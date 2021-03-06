package at.address.view;

import at.address.Main;
import at.address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControladorPessoa {
	
	 @FXML
	    private TableView<Person> personTable;
	    @FXML
	    private TableColumn<Person, Integer> idColumn;
	    @FXML
	    private TableColumn<Person, String> NameColumn;

	    @FXML
	    private Label IDLabel;
	    @FXML
	    private Label NameLabel;
	    @FXML
	    private Label PhoneLabel;
	    
	    @FXML
	    private void handleDeletePerson() {
	        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
	        personTable.getItems().remove(selectedIndex);
	        if (selectedIndex >= 0) {
	            personTable.getItems().remove(selectedIndex);
	        } else {
	            // Nada selecionado.

	        Alert alert = new Alert(AlertType.WARNING);
	                alert.setTitle("Nenhuma sele��o");
	                alert.setHeaderText("Nenhuma Pessoa Selecionada");
	                alert.setContentText("Por favor, selecione uma pessoa na tabela.");

	                alert.showAndWait();
	        }
	    }
	   
	    // Reference to the main application.
	    private Main main;

	    /**
	     * O construtor.
	     * O construtor � chamado antes do m�todo inicialize().
	     */
	    public ControladorPessoa() {
	    }

	    /**
	     * Inicializa a classe controller. Este m�todo � chamado automaticamente
	     *  ap�s o arquivo fxml ter sido carregado.
	     */
	    @FXML
	    private void initialize() {
	        // Inicializa a tablea de pessoa com duas colunas.
	        idColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
	        NameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
	        
	        // Limpa os detalhes da pessoa.
	        showPersonDetails(null);

	        // Detecta mudan�as de sele��o e mostra os detalhes da pessoa quando houver mudan�a.
	        personTable.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> showPersonDetails(newValue));
	    }

	   
	    public void setMainApp(Main main) {
	        this.main = main;

	        // Adiciona os dados da observable list na tabela
	        personTable.setItems(main.getPersonData());
	    }
	    
	    private void showPersonDetails(Person person) {
	        if (person != null) {
	            // Preenche as labels com informa��es do objeto person.
	        	IDLabel.setText(Integer.toString(person.getID()));
	            NameLabel.setText(person.getName());
	            PhoneLabel.setText(person.getPhone());

	            // TODO: N�s precisamos de uma maneira de converter o anivers�rio em um String! 
	            // birthdayLabel.setText(...);
	        } else {
	            // Person � null, remove todo o texto.
	            IDLabel.setText("");
	            NameLabel.setText("");
	            PhoneLabel.setText("");
	            
	        }
	    }
	    
	    @FXML
		private void handleEditPerson() {
			Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		    if (selectedPerson != null) {
		        boolean okClicked = Main.showPersonEditDialog(selectedPerson);
		        if (okClicked) {
		            showPersonDetails(selectedPerson);
		        }

		    } else {
		        // Nada seleciondo.
		        Alert alert = new Alert(AlertType.WARNING);
		            alert.setTitle("Nenhuma sele��o");
		            alert.setHeaderText("Nenhuma Pessoa Selecionada");
		            alert.setContentText("Por favor, selecione uma pessoa na tabela.");
		            alert.showAndWait();
		    }
		}
	}

