package application.controladores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import application.Main;
import application.modelos.Partida;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JuegoControlador implements Initializable {

    public static Partida partida;

	@FXML
	public Button cerrarSesionButton;
	
	@FXML
	public Button nuevaPartidaButton;
	
	
	@FXML
	public ImageView ahorcadoImagen;
	
	
    @FXML
    public Label palabraLabel;
    
    @FXML
    public Label vidasLabel;
    
	@FXML
	public TextField inputLetra;
    
	@FXML
	public Button ingresarLetraButton;

    @FXML
    public void handleCambiarLoginVista() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/vistas/LoginVista.fxml"));
            Parent nuevaVista = loader.load();

            Scene nuevaEscena = new Scene(nuevaVista);

            Stage escenarioActual = (Stage) cerrarSesionButton.getScene().getWindow();
            escenarioActual.setScene(nuevaEscena);
            escenarioActual.show();
        } catch (IOException e) {
            System.err.println("Error al cambiar de vista: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @FXML
    public void handleNuevaPartida() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/vistas/JuegoVista.fxml"));
            Parent nuevaVista = loader.load();

            Scene nuevaEscena = new Scene(nuevaVista);

            Stage escenarioActual = (Stage) cerrarSesionButton.getScene().getWindow();
            escenarioActual.setScene(nuevaEscena);
            escenarioActual.show();
        } catch (IOException e) {
            System.err.println("Error al cambiar de vista: " + e.getMessage());
            e.printStackTrace();
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
    public void handleIngresarLetra() {
    	String letraIngresada = inputLetra.getText();
    	if (letraIngresada.length()==1  && letraIngresada.matches("[a-zA-Z]+")) {
    		char letra = letraIngresada.toLowerCase().toCharArray()[0];
    		char[] palabraOriginal = partida.getPalabra().toCharArray();
    		char[] reemplazoPalabra= palabraLabel.getText().toLowerCase().toCharArray();
    		
    		
    		for (int i = 0; i < palabraOriginal.length;i++) {
    			if (palabraOriginal[i] == letra) {
    				reemplazoPalabra[i] = letra;
    			}

    		}
    		
    		String reemplazoPalabraString = new String(reemplazoPalabra);
    		if(reemplazoPalabraString.equals(palabraLabel.getText().toLowerCase())) {
    			
    			
    			reemplazarImagen("/application/imagenes/ahorcado"+partida.getVidas()+".jpg");
    			partida.perderVida();
    			if (partida.getVidas() < 1) {
    				mostrarAlerta("Fin", "Haz perdido la partida la palabra era: "+ partida.getPalabra(), AlertType.ERROR);
    				handleNuevaPartida();
    			}
    				vidasLabel.setText(Integer.toString(partida.getVidas()));
    		}
    		else {
    			
    			palabraLabel.setText(reemplazoPalabraString);
    			if (partida.getPalabra().equals(palabraLabel.getText().toLowerCase())) {
    				mostrarAlerta("Ganador", "haz encontrado la palabra - FELICIDADES CRACK", AlertType.INFORMATION);
    				handleNuevaPartida();
    			}
    		}
    		inputLetra.setText("");

    		
    	}
    	else {
    		mostrarAlerta("Dato invalido", "input invalido", AlertType.ERROR);
    		inputLetra.setText("");
    	}
 
    }
    
    @FXML
    public void reemplazarImagen(String urlImagen){
    	Image nuevaImagen = new Image(getClass().getResource(urlImagen).toString());
	    ahorcadoImagen.setImage(nuevaImagen);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	    
    	partida =  new Partida().crearPartida();
    	// darle al labe de vidas su numero de vidas//
    	vidasLabel.setText(Integer.toString(partida.getVidas()));
    	
    	// llenar el label con _ segun el tamaño de la palabra //
    	String iniciarConRayas = "";
    	for(int i = 0;i<partida.getPalabra().length();i++) {
    		iniciarConRayas += "_";
    	}
    	palabraLabel.setText(iniciarConRayas);
    	
    	// agrega la imagen inicial de ahorcado "la vacia" //
    	reemplazarImagen("/application/imagenes/ahorcadoInicial.jpg");
    	
    	// se le asigna los eventos-funciones a los botones //
    	cerrarSesionButton.setOnMouseClicked(event -> handleCambiarLoginVista());
    	ingresarLetraButton.setOnMouseClicked(event -> handleIngresarLetra());
    	nuevaPartidaButton.setOnMouseClicked(event -> handleNuevaPartida());
    }
 }

