package niveles;

import juego.Juego;

public abstract class Nivel extends Thread {

	protected Juego juego;
	
	public abstract Nivel siguienteNivel();
	public abstract Nivel reiniciarNivel();
	
	public void setJuego(Juego j)
	{
		juego = j;
	}
}
