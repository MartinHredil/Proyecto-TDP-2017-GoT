package herramientas;
import mapa.Celda;
import powerups.*;

/* Patron de Diseño Builder*/

public class Director {

	public PowerUp crearPowerUP(Celda c,int opcion)
	{
		PowerUp toReturn = null;
		switch(opcion)
		{
		case 1:
		{
			toReturn = new PlusAtaque(c);
			break;
		}
		case 2:
		{
			toReturn = new PlusVida(c);
			break;
		}
		case 3:
		{
			toReturn = new Proteccion(c);
			break;
		}
		case 4:
		{
			toReturn = new BonusBomba(c);
			break;
		}
		}
		return toReturn;
	}
}
