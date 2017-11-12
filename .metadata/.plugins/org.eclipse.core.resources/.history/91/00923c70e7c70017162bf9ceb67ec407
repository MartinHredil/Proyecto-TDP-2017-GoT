package personajes;

import javax.swing.ImageIcon;
import mapa.*;

public class Ballesta extends Personaje{

	protected GenerarFlechasBallesta generarFlechas;
	
	public Ballesta(Celda c)
	{
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/BallestaEsperando.gif")));
		generarFlechas = new GenerarFlechasBallesta(this);
		generarFlechas.start();
	}

	public void destruir()
	{
		generarFlechas.terminate();
		super.destruir();
	}
	
	public void atacar()
	{
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/BallestaEsperando.gif")));
	}
	
	public void esperar()
	{
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/BallestaEsperando.gif")));
	}
}
