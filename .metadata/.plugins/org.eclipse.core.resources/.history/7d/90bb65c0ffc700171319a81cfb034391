package objetos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

	public class Muro extends Objeto {

		public Muro(Celda c)
		{
			super(c);
			vida=1500;
			costo=160;
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/MuroParte2.png")));
			
			int fila = miCelda.getFila();
			Celda segundaCelda;
			Muralla extension;
			JLabel parte2;
			
			if(fila==5) {
				segundaCelda = miCelda.getMapa().getCelda(fila-1, miCelda.getColumna());
				extension = new Muralla(segundaCelda);
			
				parte2 = new JLabel();
				parte2.setIcon(new ImageIcon(this.getClass().getResource("/sources/MuroParte2.png")));
				extension.setGrafico(parte2);
				
				grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/MuroParte1.png")));
				
			} else {
				segundaCelda = miCelda.getMapa().getCelda(fila+1, miCelda.getColumna());
				extension = new Muralla(segundaCelda);
			
				parte2 = new JLabel();
				parte2.setIcon(new ImageIcon(this.getClass().getResource("/sources/MuroParte1.png")));
				extension.setGrafico(parte2);				
			}
			
			miCelda.getMapa().getJuego().agregar(extension);
			
			segundaCelda.agregar(extension);
		}
}

