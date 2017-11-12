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
		return false;
	}
	
	public boolean visitarPersonaje(Personaje p)
	{
		if(p.getEsperando())
		{
			p.atacar();
		}
		if(enemigo.getCaminando())
		{
			enemigo.atacar();
		}
		p.decrementarVida(enemigo.getDanioAtaque());
		enemigo.decrementarVida(p.getDanioAtaque());
		
		if(enemigo.getVida()<=0)
		{
			enemigo.destruir();
			p.esperar();
		}
		
		if(p.getVida()<=0)
		{
			enemigo.caminar();
			p.destruir();
		}
		
		return true;
	}
	
	public boolean visitarObjeto(Objeto o)
	{
		if(enemigo.getCaminando())
		{
			enemigo.atacar();
		}
		
		o.decrementarVida(enemigo.getDanioAtaque());
		
		if(o.getVida()<=0)
		{
			enemigo.caminar();
			o.destruir();
		}
		
		return true;
	}
	
	public boolean visitarPowerUp(PowerUp pw)
	{
		pw.destruir();
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
