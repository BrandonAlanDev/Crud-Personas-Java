package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Pais;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.SwingConstants;

public class Paises extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel container;

	public Paises() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		container = new JPanel();
		container.setBackground(new Color(255, 230, 230));
		container.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(container);
		container.setLayout(null);
		
		JComboBox cbPais = new JComboBox();
		cbPais.setBounds(83, 117, 227, 40);
		container.add(cbPais);
		
		JLabel lblTitulo = new JLabel("Provincias por Pais");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo.setBounds(83, 11, 227, 40);
		container.add(lblTitulo);
		
		JComboBox cbProvincia = new JComboBox();
		cbProvincia.setBounds(83, 188, 227, 40);
		container.add(cbProvincia);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(83, 92, 46, 14);
		container.add(lblPais);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(83, 168, 46, 14);
		container.add(lblProvincia);
		
		Pais arg = new Pais("Argentina",new ArrayList<>(Arrays.asList("Buenos Aires", "Santiago del Estero","Santa Fe","Cordoba")));
		Pais bra = new Pais("Brasil",new ArrayList<>(Arrays.asList("Sao Paulo", "Rio do Janeiro","Brasilia")));
		Pais chi = new Pais("Chile",new ArrayList<>(Arrays.asList("Santiago de chile", "Valparaiso","Concepcion")));
		
		cbPais.addItem(arg);
		cbPais.addItem(bra);
		cbPais.addItem(chi);
		
	}
}
