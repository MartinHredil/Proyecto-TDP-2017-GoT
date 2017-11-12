package personajes;
import javax.swing.ImageIcon;
import mapa.*;

public class Soldado extends Personaje{

	
	public Soldado(Celda c)
	{
		super(c);
		vida = 1000;
		danioAtaque=4;
		costo = 50;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/SoldadoEsperando.gif")));
	}
	
	public void atacar()
	{
		esperando=false;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/SoldadoAtacando.gif")));
	}
	
	public void esperar()
	{
		esperando=true;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/SoldadoEsperando.gif")));
	}
}