package practico;

public class Pelicula implements Entregable, Comparable<Pelicula> {
	String titulo = "",
			director = "";
	Integer duracion = 90;
	Genero genero = Genero.SIN_DEFINIR;
	Boolean entregado=false;
	
	//por defecto
	public Pelicula() {
		super();
	}
	//Solo titulo y duracion
	public Pelicula(String titulo, Integer duracion) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
	}
	//Todo excepto entregado
	public Pelicula(String titulo, String director, Integer duracion, Genero genero) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.duracion = duracion;
		this.genero = genero;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Titulo: "+this.titulo+
				"\nDirector: "+this.director+
				"\nDuracion: "+this.duracion+
				"\nGenero: "+this.genero+
				"\nEntregado: "+this.entregado;
	}
	
	public void entregar(){
		this.entregado = true;
	}
	public void devolver(){
		this.entregado = false;
	}
	public Boolean isEntregado(){
		return this.entregado;
	}
	
	@Override
	public int compareTo(Pelicula a) {
		// TODO Auto-generated method stub
		int res=0;
		if (this.duracion > a.duracion) {
			res=1;
		}else if(this.duracion < a.duracion){
			res=-1;
		}else { 
			res=0;
		}
		return res;
	}
	

}
