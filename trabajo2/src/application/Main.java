package application;

import java.util.ArrayList;
import java.util.List;
import application.controladores.LoginControlador;
import application.modelos.Usuario;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	public static List<Usuario> listaUsuarios = new ArrayList<>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			LoginControlador LoginC = new LoginControlador();
			LoginC.show(primaryStage);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
