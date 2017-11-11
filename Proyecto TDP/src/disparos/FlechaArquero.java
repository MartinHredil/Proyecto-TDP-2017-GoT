package disparos;
import javax.swing.ImageIcon;
import mapa.*;

public class FlechaArquero extends DisparoPersonaje{
	
	
	public FlechaArquero(Celda c)
	{
		super(c);
		danioAtaque=150;
		velocidad = 2;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Flecha.png")));
		moverme = new MoverDisparoPersonaje(this);
		moverme.start();
	}
}
