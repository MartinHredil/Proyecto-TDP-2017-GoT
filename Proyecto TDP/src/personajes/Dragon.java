package personajes;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

public class Dragon extends Personaje {
	
	protected GenerarBolaFuego generarBolaFuego;
	
	public Dragon(Celda c)
	{
		super(c);
		grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Arquero.png")));
		generarBolaFuego = new GenerarBolaFuego(this);
		generarBolaFuego.start();
	}
	
	public void destruir()
	{
		generarBolaFuego.terminate();
		super.destruir();
	}
}
