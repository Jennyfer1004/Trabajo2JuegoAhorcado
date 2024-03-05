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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistroControlador implements Initializable {

	@FXML
	public Button loginButton;
	
	@FXML
	public Button crearUsuarioButton;
	
	@FXML
    public TextField inputNombre;
	
	@FXML
    public TextField inputApellido;
	
	@FXML
    public TextField inputTelefono;

    
    @FXML
    public TextField inputUsername;
    
    @FXML
    public TextField inputPass;
    
    
    @FXML
    private void handleCrearUsuario() {
    	String nombre = inputNombre.getText().toString();
    	String apellido = inputApellido.getText().toString();
    	String telefono = inputTelefono.getText().toString();
        String username = inputUsername.getText().toString();
        String pass = inputPass.getText().toString();
        if(nombre.isBlank() || apellido.isBlank() || telefono.isBlank() || username.isBlank() || pass.isBlank()) {
        	mostrarAlerta("Datos invalidos", "Confirma que estas llenando los datos correctamente", AlertType.ERROR);
        }else {
        	
        	new Usuario().crearUsuario(nombre, apellido, telefono, username, pass);
            mostrarAlerta("Creacion de usuario", "Usuario creado correctamente", AlertType.CONFIRMATION);
            handleCambiarLoginVista();
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
    public void handleCambiarLoginVista() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/vistas/LoginVista.fxml"));
            Parent nuevaVista = loader.load();

            Scene nuevaEscena = new Scene(nuevaVista);

            Stage escenarioActual = (Stage) loginButton.getScene().getWindow();
            escenarioActual.setScene(nuevaEscena);
            escenarioActual.show();
        } catch (IOException e) {
            System.err.println("Error al cambiar de vista: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
    	loginButton.setOnMouseClicked(event -> handleCambiarLoginVista());
    	crearUsuarioButton.setOnMouseClicked(event -> handleCrearUsuario());
    }
 }

