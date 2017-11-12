package mapa;
import juego.*;

public class Mapa {

	protected Celda[][] celdas;
	protected Juego juego;
	
	public Mapa(int f, int c, Juego j)
	{
		juego = j;
		celdas = new Celda[f][c];
		for(int i = 0; i<f;i++)
			for(int k = 0; k<c;k++)
			{
				celdas[i][k] = new Celda(i,k,this);
			}
	}
	
	public Celda getCelda(int f, int c)
	{
		Celda toReturn = null;
		if(f>=0 && f<celdas.length)
			if(c>=0 && c<celdas[0].length)
				toReturn = celdas[f][c];
		return toReturn;
	}
	
	public Juego getJuego()
	{
		return juego;
	}
}