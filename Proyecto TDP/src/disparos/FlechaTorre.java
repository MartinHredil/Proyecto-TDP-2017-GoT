package disparos;
import javax.swing.ImageIcon;
import mapa.*;

public class FlechaTorre extends DisparoPersonaje{
	
	public FlechaTorre(Celda c)
	{
		super(c);
		danioAtaque=250;
		velocidad = 1;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/FlechaTorre.png")));
		moverme = new MoverDisparoPersonaje(this);
		moverme.start();
	}
}