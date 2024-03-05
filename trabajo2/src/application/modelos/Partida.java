package application.modelos;

import java.util.Random;

import application.Main;

public class Partida {
    private String palabra;
    private int vidas;


    public Partida crearPartida() {
    	String[] palabras = {"cuchara","ventana","raton","teclado",
    			"monitor","celular","computadora","libro","silla","mesa",
    			"puerta","pared","techo","piso","cepillo","peine","espejo",
    			"inodoro","lavamanos","regadera","jabon","shampoo","pasta",
    			"cepillod","camisa","pantalon","falda","vestido","zapato","tenis",
    			"calcetin","sueter","abrigo","guante","bufanda","gorro","lentes",
    			"arete","anillo","reloj","collar","pulsera","billetera","llave",
    			"candado","cuaderno","lapiz","pluma","borrador","tajalapiz",
    			"mochila","cartuchera","cartulina","tijera","grapadora",
    			"folder","clip","calculadora","diccionario","enciclopedia",
    			"rompecabezas","ajedrez","dado","baraja","balon","bates","raqueta",
    			"red","patines","monopatin","casco","coderas","rodilleras","canasta",
    			"tablero","tiro","arco","flecha","pesa","mancuerna","caminante","disco",
    			"calcetin","disquete","mascara","memoria","portatil","procesador","teclado",
    			"rata","celular","telefono","computador"};
        Random random = new Random();
        int indiceAleatorio = random.nextInt(palabras.length);
        String palabraAleatoria = palabras[indiceAleatorio];

        Partida nuevaPartida = new Partida();
        nuevaPartida.setPalabra(palabraAleatoria);
        nuevaPartida.setVidas(5);
        return nuevaPartida;
    }
	public void perderVida() {
		vidas-=1;
	}
    
	private void setPalabra(String palabra2 ) {
		palabra = palabra2;
		
	}
	private void setVidas(int vidas2 ) {
		vidas = vidas2;
		
	}

    public String getPalabra() {
        return palabra;
    }

    public int getVidas() {
        return vidas;
    }
}
