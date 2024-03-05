package application.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.modelos.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginControlador implements Initializable {

	@FXML
	public Button registrarButton;
	
	@FXML
	public Button iniciarSesionButton;

    @FXML
    public Label loginLabel;
    
    @FXML
    public TextField inputUsuario;
    
    @FXML
    public TextField inputPassword;
    



    
    
    public void show(Stage sg){
    	Parent container;
    	try {
    		container = (Parent)FXMLLoader.load(getClass().getResource("/application/vistas/LoginVista.fxml"));
        	Scene sc = new Scene(container,1080,600);
        	sg.setScene(sc);
        	sg.show();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    		
    	}

    }
    
    @FXML
    private void handleIniciarSesion() {
        String username = inputUsuario.getText().toString();
        String password = inputPassword.getText().toString();
 
        if (new Usuario().iniciarSesion(username, password)) {
        	handleCambiarJuegoVista();
        }
        else {
        	mostrarAlerta("Inicio de Sesión Fallido", "Usuario o contraseña incorrectos", AlertType.ERROR);
        	
        }

    }
    


	private void mostrarAlerta(String titulo, String mensaje, AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
    
    @FXML
    public void handleCambiarRegistroVista() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/vistas/RegistroVista.fxml"));
            Parent nuevaVista = loader.load();

            Scene nuevaEscena = new Scene(nuevaVista);

            Stage escenarioActual = (Stage) registrarButton.getScene().getWindow();
            escenarioActual.setScene(nuevaEscena);
            escenarioActual.show();
        } catch (IOException e) {
            System.err.println("Error al cambiar de vista: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void handleCambiarJuegoVista() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/vistas/JuegoVista.fxml"));
            Parent nuevaVista = loader.load();

            Scene nuevaEscena = new Scene(nuevaVista);

            Stage escenarioActual = (Stage) iniciarSesionButton.getScene().getWindow();
            escenarioActual.setScene(nuevaEscena);
            escenarioActual.show();
        } catch (IOException e) {
            System.err.println("Error al cambiar de vista: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
    	registrarButton.setOnMouseClicked(event -> handleCambiarRegistroVista());
    	iniciarSesionButton.setOnMouseClicked(event -> handleIniciarSesion());
    }
 }

