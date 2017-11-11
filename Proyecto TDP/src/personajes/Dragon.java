package personajes;
import javax.swing.ImageIcon;
import mapa.Celda;

public class Dragon extends Personaje {
	
	protected GenerarBolaFuego generarBolaFuego;
	
	public Dragon(Celda c)
	{
		super(c);
		vida = 100;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Dragon.gif")));
		generarBolaFuego = new GenerarBolaFuego(this);
		generarBolaFuego.start();
	}
	
	public void destruir()
	{
		generarBolaFuego.terminate();
		super.destruir();
	}
	
	public void atacar()
	{
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Dragon.gif")));
	}
	
	public void esperar()
	{
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Dragon.gif")));
	}
}
