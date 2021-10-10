package sample;

import br.com.rackup.DAO.ProfessorDAO;
import br.com.rackup.model.ProfessorModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../br/com/rackup/gui/home.fxml"));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }


    public static void main(String[] args) {

        ProfessorModel professorModel = new ProfessorModel();
        professorModel.setNomeProfessor("William");
        professorModel.setDisciplina("Programação");
        professorModel.setStatus(true);

        ProfessorDAO professorDAO = new ProfessorDAO();
        System.out.println("Resultado:"+professorDAO.cadastrarProfessor(professorModel));

        launch(args);


    }
}
