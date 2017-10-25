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
	protected Contenido fabricado;
	protected Director director;
	
	protected JPanel panelOpciones;
	protected JPanel panelJuego;
	
	protected JLabel etiqueta;
	protected JLabel etiquetaPuntos;
	protected JLabel etiquetaMonedas;
	
	public GUI()
	{
		juego = new Juego(this);
		mapa = juego.getMapa();
		cantFilas = juego.getFilas();
		cantColumnas = juego.getColumnas();
		alto = cantFilas * 80;
		
		ancho = cantColumnas;
		//ancho = cantColumnas * 80;
		
		fabricado = null;
		director = new Director();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(ancho+6, alto+129);
		
		inicializarPanelBotones();
		inicializarPanelJuego();
		
		getContentPane().setBackground(Color.green);
		
		getContentPane().add(panelOpciones);
		getContentPane().add(panelJuego);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void inicializarPanelBotones()
	{
		panelOpciones = new JPanel();
		panelOpciones.setLayout(null);
		panelOpciones.setBorder(BorderFactory.createLineBorder(Color.black));
		panelOpciones.setBounds(0,0, ancho, 100);
		
		JButton botonAgregarMuerto = new JButton();
		botonAgregarMuerto.setBounds(0, 0, 80, 80);
		botonAgregarMuerto.setIcon(new ImageIcon(this.getClass().getResource("/sources/Muerto.png")));
		botonAgregarMuerto.addActionListener(new OyenteAgregarEnemigo());
		
		
		JButton botonAgregarSoldado = new JButton();
		botonAgregarSoldado.setBounds(80, 0, 80, 80);
		botonAgregarSoldado.setIcon(new ImageIcon(this.getClass().getResource("/sources/Soldado.png")));
		botonAgregarSoldado.addActionListener(new OyenteAgregarPersonaje());

		etiquetaPuntos = new JLabel("Puntos: "+juego.getPuntos());
		etiquetaPuntos.setBounds(160,0 , 80, 20);
		
		etiquetaMonedas = new JLabel("Monedas: "+juego.getMonedas());
		etiquetaMonedas.setBounds(240,0 , 80, 20);
		
		panelOpciones.add(botonAgregarMuerto);
		panelOpciones.add(botonAgregarSoldado);
		panelOpciones.add(etiquetaMonedas);
		panelOpciones.add(etiquetaPuntos);
	}
	
	private void inicializarPanelJuego()
	{
		panelJuego = new JPanel();
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
	
	private class OyenteAgregarEnemigo implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            fabricado = director.crearEnemigo(1);
        }
    }
	
	private class OyenteAgregarPersonaje implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
        	fabricado = director.crearPersonaje(1);
        }
    }
	
	private class OyentePanelMouse implements MouseListener {
        public void mousePressed(MouseEvent e)
        {
        	int i = e.getY() / 80;
        	
        	//int j = e.getX() / 80;
        	int j = e.getX();
        	if(fabricado!=null)
        	{
        		Celda aux = mapa.getCelda(i, j);
        		if(!aux.ocupado(fabricado.getPosicion()))
        		{
        			aux.agregar(fabricado);
        			fabricado.setCelda(aux);
        			panelJuego.add(fabricado.getGrafico());
        			fabricado=null;
        		}
        	}
        	else
        	{
        		Celda aux = mapa.getCelda(i, j);
        		if(aux.ocupado(1))
        		{
        			Iterator<Contenido> it = aux.getContenido();
        			while(it.hasNext())
        			{
        				it.next().destruir();
        			}
        		}
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
