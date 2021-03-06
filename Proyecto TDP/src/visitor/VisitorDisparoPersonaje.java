package visitor;
import personajes.Personaje;
import enemigos.Enemigo;
import objetos.Objeto;
import powerups.PowerUp;
import disparos.DisparoEnemigo;
import disparos.DisparoPersonaje;

public class VisitorDisparoPersonaje implements Visitor {

	protected DisparoPersonaje disparoPersonaje;
	
	public VisitorDisparoPersonaje(DisparoPersonaje dp)
	{
		disparoPersonaje = dp;
	}
	
	public boolean visitarEnemigo(Enemigo e)
	{
		e.decrementarVida(disparoPersonaje.getDanioAtaque());
		if(e.getVida()<=0)
			e.destruir();
		return true;
	}
	
	public boolean visitarPersonaje(Personaje p)
	{
		p.esperar();
		return false;
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