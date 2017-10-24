package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparos.*;
import juego.GenerarFlechas;

import mapa.*;

public class Arquero extends Personaje{

	protected Thread generarFlechas;
	
	public Arquero(Celda c)
	{
		super(c);
		grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Soldado.png")));
		generarFlechas = new GenerarFlechas(this);
		generarFlechas.start();
		
	}

	public void crear()
	{
		Celda sig = miCelda.getDerecha();
		if(sig!=null)
		{ 
			DisparoPersonaje dp = new FlechaArquero(sig);
			sig.agregar(dp);
			sig.getMapa().getJuego().agregar(dp);
		}
	}
}
	
