package juego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import mapa.*;
import enemigos.*;
import personajes.*;
import herramientas.*;

public class GUI extends JFrame{

	protected int cantFilas;
	protected int cantColumnas;
	protected int alto;
	protected int ancho;	
	
	protected Juego juego;
	protected Mapa mapa;
	protected FabricaPersonajes fabrica;
	protected int fabricado;
	
	protected JPanel panelOpciones;
	protected JPanel panelJuego;
	
	protected JLabel etiqueta;
	protected JLabel etiquetaPuntos;
	protected JLabel etiquetaMonedas;
	
	protected JButton personajes[];
	protected String nombres[];
	
	public GUI()
	{
		juego = new Juego(this);
		mapa = juego.getMapa();
		cantFilas = juego.getFilas();
		cantColumnas = juego.getColumnas();
		alto = cantFilas * 80;
		
		ancho = cantColumnas;
		//ancho = cantColumnas * 80;
		
		fabrica = new FabricaPersonal();
		fabricado=-1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(ancho+6, alto+129);
		
		panelOpciones = new JPanel();
		inicializarPanelBotones();
		
		panelJuego = new JPanel();
		inicializarPanelJuego();
		
		getContentPane().setBackground(Color.green);
		
		getContentPane().add(panelOpciones);
		getContentPane().add(panelJuego);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void inicializarPanelBotones()
	{
		panelOpciones.setLayout(null);
		panelOpciones.setBorder(BorderFactory.createLineBorder(Color.black));
		panelOpciones.setBounds(0,0, ancho, 100);
		
		nombres = new String[3];
		personajes = new JButton[3];
		
		nombres[0]="Soldado.png";
		nombres[1]="Arquero.png";
		nombres[2]="Arquero.png";
		
		for(int i=0;i<3;i++)
		{
			personajes[i]=new JButton();
			personajes[i].setBounds(0+(i*60), 0, 60, 60);
			personajes[i].setIcon(new ImageIcon(this.getClass().getResource("/sources/"+nombres[i])));
			personajes[i].setActionCommand(""+i);
			personajes[i].addActionListener(new OyenteAgregarPersonaje());
			panelOpciones.add(personajes[i]);
		}

		etiquetaPuntos = new JLabel("Puntos: "+juego.getPuntos());
		etiquetaPuntos.setBounds(ancho-100,0 , 80, 20);
		
		etiquetaMonedas = new JLabel("Monedas: "+juego.getMonedas());
		etiquetaMonedas.setBounds(ancho-200,0 , 80, 20);
		
		panelOpciones.add(etiquetaMonedas);
		panelOpciones.add(etiquetaPuntos);
	}
	
	private void inicializarPanelJuego()
	{
		panelJuego.setLayout(null);
		panelJuego.setBackground(new Color(135,206,255));
		panelJuego.setBounds(0, 100, ancho, alto);
		
		for(int i=0;i<cantFilas;i++)
		{
			for(int j=0;j<cantColumnas;j++)
			{
				Iterator<Contenido> it = mapa.getCelda(i,j).getContenido();
				while(it.hasNext())
				{
					etiqueta = it.next().getGrafico();
					etiqueta.setBounds(j,i*80,80,80);
					panelJuego.add(etiqueta);
				}
			}
		}
		
		panelJuego.addMouseListener(new OyentePanelMouse());
	}
	
	public void refrescar()
	{
		for(int i=0;i<cantFilas;i++)
		{
			for(int j=0;j<cantColumnas;j++)
			{
				Iterator<Contenido> it = mapa.getCelda(i,j).getContenido();
				while(it.hasNext())
				{
					etiqueta = it.next().getGrafico();
					etiqueta.setBounds(j,i*80,80,80);
					//panelJuego.add(etiqueta);
					//etiqueta.repaint();
				}
			}
		}
		etiquetaPuntos.setText("Puntos: "+juego.getPuntos());
		etiquetaMonedas.setText("Monedas: "+juego.getMonedas());
	}
	
	public JPanel getPanelJuego()
	{
		return panelJuego;
	}
	
	public void agregar(JLabel j)
	{
		panelJuego.add(j);
	}
	
	public void terminar(boolean gano)
	{
		this.dispose();
	}
	
	public void nuevoJuego()
	{
		
	}
	
	private class OyenteAgregarPersonaje implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
        	fabricado = Integer.parseInt(e.getActionCommand());
        }
    }
	
	private class OyentePanelMouse implements MouseListener {
        public void mousePressed(MouseEvent e)
        {
        	int i = e.getY() / 80;
        	int j = e.getX();
        	
        	if(fabricado>=0)
        	{
        		Celda aux = mapa.getCelda(i, j);
        		Personaje nuevo=null;
    			switch (fabricado) {
                case 0:  nuevo = fabrica.crearSoldado(aux);
                         break;
                case 1:  nuevo = fabrica.crearArquero(aux);
                         break;
                case 2:  nuevo = fabrica.crearArquero(aux);
                         break;
            	}
    			
        		if(!aux.ocupado(nuevo.getPosicion()))
        		{
        			aux.agregar(nuevo);
        			panelJuego.add(nuevo.getGrafico());
        		}
        		
        		fabricado=-1;	
        	}
        }
        
        public void mouseEntered(MouseEvent e)
        {
        }
        
        public void mouseExited(MouseEvent e)
        {
        }
        
        public void mouseClicked(MouseEvent e)
        {
        }
        
        public void mouseReleased(MouseEvent e)
        {
        }
    }

}
