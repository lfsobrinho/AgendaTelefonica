package at.address;

import java.io.IOException;

import at.address.model.Person;
import at.address.view.ControladorPessoa;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    
    public Main() {
        personData.add(new at.address.model.Person(1, "Jose dos alface", "(45) 9999-9999"));
        personData.add(new Person(2, "Jose dos Arroz", "(45) 9999-7777"));
    }

    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonData() {
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
            // Carrega o person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Tela1.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Define o person overview dentro do root layout.
            rootLayout.setCenter(personOverview);
            
            // Dá ao controlador acesso à the main app.
            ControladorPessoa controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}