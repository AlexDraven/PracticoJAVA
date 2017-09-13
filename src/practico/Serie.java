package practico;

public class Serie implements Entregable, Comparable<Serie> {

	String titulo = "",
			creador = "";
	int numTemporadas = 1;
	Genero genero = Genero.SIN_DEFINIR;
	Boolean entregado = false;
	
	//Por defecto
	public Serie() {
		super();
	}

	//Solo titulo y creador
	public Serie(String titulo, String creador) { 
		super();
		this.titulo = titulo;
		this.creador = creador;
	}
	
	//Todos excepto entregado
	public Serie(String titulo, String creador, int numTemporadas, Genero genero) {
		super();
		this.titulo = titulo;
		this.creador = creador;
		this.numTemporadas = numTemporadas;
		this.genero = genero;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public int getNumTemporadas() {
		return numTemporadas;
	}

	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
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
				"\nCreador: "+this.creador+
				"\nNroTemporadas: "+this.numTemporadas+
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
	public int compareTo(Serie a) {
		// TODO Auto-generated method stub
		int res=0;
		if (this.numTemporadas > a.numTemporadas) {
			res=1;
		}else if(this.numTemporadas < a.numTemporadas){
			res=-1;
		}else { 
			res=0;
		}
		return res;
	}
	
	public String toArchivo() {
		//String salida = "";
		return this.titulo+","+this.creador+","+this.numTemporadas+","+this.genero+","+this.entregado;
	}
}
