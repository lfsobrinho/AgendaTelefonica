package at.address;

import java.io.IOException;

import at.address.model.Pessoa;
import at.address.model.Pessoa.Person;
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

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ObservableList<Person> pessoaData = FXCollections.observableArrayList();

    /**
     * Construtor
     * @param <Public>
     * @param <Public>
     */
     <Public> ObservableList<Person> Main(){
        // Add some sample data
        pessoaData.add(new Person("Hans"));
        pessoaData.add(new Person("Hans"));
        pessoaData.add(new Person("Hans"));
        pessoaData.add(new Person("Hans"));
        pessoaData.add(new Person("Hans"));
        pessoaData.add(new Person("Hans"));
        pessoaData.add(new Person("Hans"));
        

    /**
     * Retorna os dados como uma observable list de Persons. 
     * @return
     */
    ObservableList<Person> getpessoaData(){
        return  pessoaData;
    }
   }

    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}