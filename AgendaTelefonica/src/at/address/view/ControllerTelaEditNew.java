package at.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import at.address.model.Person;

public class ControllerTelaEditNew {

	@FXML
	private TextField IDField;
	@FXML
	private TextField NameField;
	@FXML
	private TextField PhoneField;

	private Stage dialogStage;
	private Person person;
	private boolean okClicked = false;

	/**
	 * Inicializa a classe controlle. Este método é chamado automaticamente após
	 * o arquivo fxml ter sido carregado.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Define o palco deste dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Define a pessoa a ser editada no dialog.
	 * 
	 * @param person
	 */

	public void setPerson(Person person) {
		this.person = person;

		IDField.setText(Integer.toString(person.getID()));
		NameField.setText(person.getName());
		PhoneField.setText(person.getPhone());
	}

	/**
	 * Retorna true se o usuário clicar OK,caso contrário false.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Chamado quando o usuário clica OK.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			person.setID(Integer.parseInt(IDField.getText()));
			person.setName(NameField.getText());
			person.setPhone(PhoneField.getText());

			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Chamado quando o usuário clica Cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Valida a entrada do usuário nos campos de texto.
	 * 
	 * @return true se a entrada é válida
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (IDField.getText() == null || IDField.getText().length() == 0) {
			errorMessage += "ID inválido!\n";
		}
		if (NameField.getText() == null || NameField.getText().length() == 0) {
			errorMessage += "Nome inválido!\n";
		}
		if (PhoneField.getText() == null || PhoneField.getText().length() == 0) {
			errorMessage += "Telefone inválida!\n";
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Mostra a mensagem de erro.
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Campos Inválidos");
			alert.setHeaderText("Por favor, corrija os campos inválidos");
			alert.setContentText(errorMessage);
			alert.showAndWait();

			return false;
		}
	}
}