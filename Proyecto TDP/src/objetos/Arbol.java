package objetos;
import javax.swing.ImageIcon;
import mapa.Celda;

public class Arbol extends Objeto {

	public Arbol(Celda c)
	{
		super(c);
		vida=500;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Arbol.gif")));
	}
}