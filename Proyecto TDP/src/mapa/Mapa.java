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
}
