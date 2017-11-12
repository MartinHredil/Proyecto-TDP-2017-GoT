package visitor;
import personajes.Personaje;
import enemigos.Enemigo;
import objetos.Objeto;
import powerups.PowerUp;
import disparos.DisparoEnemigo;
import disparos.DisparoPersonaje;

public class VisitorPowerUp implements Visitor {

	protected PowerUp powerup;
	
	public VisitorPowerUp(PowerUp pw)
	{
		powerup=pw;
	}
	
	public boolean visitarEnemigo(Enemigo e)
	{
		return false;
	}
	
	public boolean visitarPersonaje(Personaje p)
	{
		powerup.getPowerUp(p);
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
		return false;
	}
	
	public boolean visitarDisparoPersonaje(DisparoPersonaje dp)
	{
		return false;
	}
}