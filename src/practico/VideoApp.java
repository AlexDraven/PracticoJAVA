package practico;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class VideoApp {

	public static void main(String[] args) {
		List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
		List<Serie> listaSeries = new ArrayList<Serie>();
		
		Pelicula PeliA = new Pelicula(),
				PeliB = new Pelicula("Volver al Futuro", 116),
				PeliC = new Pelicula("Titanic","James Cameron",197,Genero.DRAMA),
				PeliD = new Pelicula("WALL-E","Andrew Stanton",98,Genero.ANIMACION),
				PeliE = new Pelicula("En busca del arca perdida",115);
		
		Serie SerieA = new Serie(),
				SerieB = new Serie("Los Simuladores","Damián Szifron",2,Genero.COMEDIA),
				SerieC = new Serie("Hermanos y detectives ","Damián Szifron"),
				SerieD = new Serie("Breaking Bad","Vince Gilligan"),
				SerieE = new Serie("Futurama","Matt Groening");
		
		listaPeliculas.add(PeliA);
		listaPeliculas.add(PeliB);
		listaPeliculas.add(PeliC);
		listaPeliculas.add(PeliD);
		listaPeliculas.add(PeliE);
		
		listaSeries.add(SerieA);
		listaSeries.add(SerieB);
		listaSeries.add(SerieC);
		listaSeries.add(SerieD);
		listaSeries.add(SerieE);
		
		PeliE.entregar();
		PeliB.entregar();
		PeliD.entregar();
		SerieB.entregar();
		SerieE.entregar();
		
		System.out.println(Entregadas(listaPeliculas));
		System.out.println(Entregadas(listaSeries));
		
		System.out.println(LaMayor(listaPeliculas));
		System.out.println(LaMayor(listaSeries));

		System.out.println(PelisTerror(listaPeliculas));

		System.out.println(ArchivoSeries(listaSeries));
	}

	private static List<Pelicula> buscarPeliculasGenero(List<Pelicula> lista, Genero genero){
		List<Pelicula> salida = new ArrayList<Pelicula>();	
		Iterator<Pelicula> elem = lista.iterator();
		while (elem.hasNext()) {
			Pelicula next = elem.next();
			if (next.genero == genero) {
				salida.add(next);
			}
		}
		return salida;
	}
	
	private static String Entregadas(List<?> lista) {
		String salida ="------------\n";
		String tmp ="";
		if (lista.get(0).getClass() == Pelicula.class) {
			int ePeli = 0;
			Iterator<?> iPeli = lista.iterator();
			while(iPeli.hasNext()) {
				Pelicula p = (Pelicula) iPeli.next();
				if (p.entregado) {
					tmp+=p.toString()+"\n-----\n";
					ePeli++;
				}
			}
			salida += "Peliculas entregadas: "+ePeli+"\n------------\n"+tmp;
		}else if (lista.get(0).getClass() == Serie.class) {
			int eSerie = 0;
			Iterator<?> iSerie = lista.iterator();
			
			while(iSerie.hasNext()) {
				Serie s = (Serie) iSerie.next();
				if (s.entregado) {
					tmp+=s.toString()+"\n-----\n";
					eSerie++;
				}
			}
			salida += "Series entregadas: "+eSerie+"\n------------\n"+tmp;
		}
		return salida;
	}
	
	private static String LaMayor(List<?> lista) {
		String salida="";
		if (lista.get(0).getClass() == Pelicula.class) {
			Iterator<?> iPelis = lista.iterator();
			Pelicula PeliM = (Pelicula) iPelis.next();
			while(iPelis.hasNext()) {
				Pelicula p = (Pelicula) iPelis.next();
				if (PeliM.compareTo(p) < 0) {
					PeliM = p;
				}
			}
			salida += "La Pelicula de mayor duracion es: \n"+PeliM.toString()+"\n---";
		}else if (lista.get(0).getClass() == Serie.class) {
			Iterator<?> iSerie = lista.iterator();
			Serie SerieM = (Serie) iSerie.next();
			while(iSerie.hasNext()) {
				Serie s = (Serie) iSerie.next();
				if (SerieM.compareTo(s) < 0) {
					SerieM = s;
				}
			}
			salida += "La serie con mas temporadas es: \n"+SerieM.toString()+"\n---";
		}		
		return salida;	
	}
	
	private static String PelisTerror(List<Pelicula> listaPeliculas) {
		Iterator<Pelicula> Pelis = buscarPeliculasGenero(listaPeliculas ,Genero.TERROR).iterator();
		String salida = "";
		while (Pelis.hasNext()) {
			Pelicula next = Pelis.next();
			salida += next.getTitulo();
		}
		if (salida == "") {
			return "No existen peliculas de TERROR";
		}else {
			return "Peliculas de TERROR:\n"+salida;
		}
	}
	
	private static String ArchivoSeries(List<Serie> listaSeries) {
        String ruta = "c:/pruebas/datos_series.txt";
        String salida = "";
        File archivo = new File(ruta);
        BufferedWriter bw = null;
        try {
        	bw = new BufferedWriter(new FileWriter(archivo));
           	for (Iterator<Serie> i = listaSeries.iterator(); i.hasNext();) {
           	    bw.write(i.next().toArchivo());
           	    bw.newLine();
           	}
           	salida ="Archivo datos_series.txt creado con exito!";
		} catch (java.lang.NullPointerException | IOException e) {
			salida = "¡Error al crear archivo datos_series.txt! \n"
					+ "Crear el directorio 'c:/pruebas' puede solucionar el problema.";
			//e.printStackTrace();
			return salida;
		}
        try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return salida;
	}
}
















