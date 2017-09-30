package visitor;
import personajes.Personaje;
import enemigos.Enemigo;
import objetos.Objeto;
import powerups.PowerUp;
import disparos.DisparoEnemigo;
import disparos.DisparoPersonaje;


public class VisitorEnemigo implements Visitor {

	protected Enemigo enemigo;
	
	public VisitorEnemigo(Enemigo e)
	{
		enemigo = e;
	}
	
	public boolean visitarEnemigo(Enemigo e)
	{
		return true;
	}
	
	public boolean visitarPersonaje(Personaje p)
	{
		p.decrementarVida(enemigo.getDanioAtaque());
		if(p.getVida()<=0)
			p.destruir();
		return true;
	}
	
	public boolean visitarObjeto(Objeto p)
	{
		return false;
	}
	
	public boolean visitarPowerUp(PowerUp pw)
	{
		return false;
	}
	
	public boolean visitarDisparoEnemigo(DisparoEnemigo de)
	{
		return true;
	}
	
	public boolean visitarDisparoPersonaje(DisparoPersonaje dp)
	{
		return true;
	}
	
}
