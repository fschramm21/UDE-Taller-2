import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

import logica.FachadaCapaLogica;
import logica.Jugador;
import logica.Partida;
import logica.Pelicula;

public class Principal {

	public static void main(String[] args) {
		
		
		String tituloPelicula = "Relatos  salvajes";		
		Pelicula peliculaPartida = new Pelicula(tituloPelicula, "Producida por Pedro Almod�var y ostenta entre sus filas al actor hoy m�s popular del cine local, Ricardo Dar�n.");
		
		FachadaCapaLogica.getInstancia().nuevaPelicula(peliculaPartida);
		//System.out.println(FachadaCapaLogica.getInstancia().getPeliculas().firstKey());
		peliculaPartida = new Pelicula("Batman", "Un hombre murcielago");
		FachadaCapaLogica.getInstancia().nuevaPelicula(peliculaPartida);
		//System.out.println(FachadaCapaLogica.getInstancia().getPeliculas().firstKey());
		
		// prueba ingresarCaracter y arriesgarPelicula
		
		peliculaPartida = FachadaCapaLogica.getInstancia().getPeliculas().firstEntry().getValue();
		String textoAdivinado;
		textoAdivinado = peliculaPartida.getTitulo();
		textoAdivinado = textoAdivinado.replaceAll("\\S", "-");
		
		Partida p1 = new Partida(0, 0, false, false, textoAdivinado, peliculaPartida);
		
		System.out.println("Texto adivinado: " + textoAdivinado);
		System.out.println("Pista: " + p1.getPeliculaPartida().getPista());
		
		
		String letra = new String();
		
		
		
		while (!p1.isFinalizada()) {
			System.out.println("Adivina una letra: ");
			 
			try{
			    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			    letra = bufferRead.readLine();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		 
			letra = letra.toUpperCase(); // convierte la letra a mayuscula
			char letraChar = letra.charAt(0); // cambia el String con la letra a 1
												// char
			
			if (letraChar == '0') {				// arriesga la pelicula
				String peliculaArriesgada = new String();
				System.out.println("Arriesga el titulo de la pelicula: ");
				try {
				    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				    peliculaArriesgada = bufferRead.readLine();
				} catch(IOException e) {
					e.printStackTrace();
				}
				peliculaArriesgada = peliculaArriesgada.replaceAll("\\s+", " "); 
				peliculaArriesgada = peliculaArriesgada.trim();
				peliculaArriesgada = peliculaArriesgada.toUpperCase();
				FachadaCapaLogica.getInstancia().arriesgarPelicula("Nombre", "Codigo", p1, peliculaArriesgada);
								
				
			} else {
				FachadaCapaLogica.getInstancia().ingresarCaracter("Nombre", "Codigo", p1, letraChar);
			}
			System.out.println("Texto adivinado: " + p1.getTextoAdivinado());
			System.out.println("Puntaje: " + p1.getPuntajePartida());
		}
		
		
	}
}
