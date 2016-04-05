package at.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import at.address.Main;
import at.address.model.Person;

public class ControladorPessoa {
	
	 @FXML
	    private TableView<Person> personTable;
	    @FXML
	    private TableColumn<Person, Integer> idColumn;
	    @FXML
	    private TableColumn<Person, String> NameColumn;

	    @FXML
	    private Label firstNameLabel;
	    @FXML
	    private Label lastNameLabel;
	    @FXML
	    private Label streetLabel;
	    @FXML
	    private Label postalCodeLabel;
	    @FXML
	    private Label cityLabel;
	    @FXML
	    private Label birthdayLabel;

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
	    }

	    /**
	     * � chamado pela aplica��o principal para dar uma refer�ncia de volta a si mesmo.
	     * 
	     * @param mainApp
	     */
	    public void setMainApp(Main main) {
	        this.main = main;

	        // Adiciona os dados da observable list na tabela
	        personTable.setItems(main.getPersonData());
	    }
	}

