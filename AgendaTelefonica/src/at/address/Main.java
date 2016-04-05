package at.address;

import java.io.IOException;

import at.address.model.Person;
import at.address.view.ControladorPessoa;
import at.address.view.ControllerTelaEditNew;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;
    private BorderPane rootLayout;

    
    public Main() {
        personData.add(new at.address.model.Person(1, "Jose dos alface", "(45) 9999-9999"));
        personData.add(new Person(2, "Jose dos Arroz", "(45) 9999-7777"));
    }

    private static ObservableList<Person> personData = FXCollections.observableArrayList();

    public static ObservableList<Person> getPersonData() {
        return personData;
    }
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AgendaTelefonica");

        initRootLayout();

        showPersonOverview();
    }

    /**
     * Inicializa o root layout (layout base).
     */
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MenuBarTela1.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostra a scene (cena) contendo oroot layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra o person overview dentro do root layout.
     */
   
        	public void showPersonOverview() {
        	    try {
        	        // Carrega a person overview.
        	        FXMLLoader loader = new FXMLLoader();
        	        loader.setLocation(Main.class.getResource("view/Tela1.fxml"));
        	        AnchorPane Tela1 = (AnchorPane) loader.load();

        	        // Define a person overview no centro do root layout.
        	        rootLayout.setCenter(Tela1);

        	        // Dá ao controlador acesso à the main app.
        	        ControladorPessoa controller = loader.getController();
        	        controller.setMainApp(this);

        	    } catch (IOException e) {
        	        e.printStackTrace();
        	    }
        	}
    public static boolean showPersonEditDialog(Person person) {
        try {
            // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/TelaEditNew.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Cria o palco dialogStage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Define a pessoa no controller.
            ControllerTelaEditNew controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Mostra a janela e espera até o usuário fechar.
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}