package views;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import javax.swing.text.*;

import models.Persona;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JList;

public class ventana extends JFrame implements ActionListener,ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField edadTextField;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JLabel lblNombreBuscado;
	private JLabel lblApellidoBuscado;
	private JLabel lblEdadBuscada;
	private JList<Persona> list;
	private DefaultListModel<Persona> modelo = new DefaultListModel<>();
	
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAgregar){
			if(nombreTextField.getText().isEmpty() || apellidoTextField.getText().isEmpty() || edadTextField.getText().isEmpty()){
				System.out.println("CAMPOS VACIOS");
			}else { 
				System.out.println("Agregar");
				Persona p = new Persona(nombreTextField.getText(), apellidoTextField.getText(), Integer.valueOf(edadTextField.getText()));
				modelo.add(modelo.size(),p);
			}
		}
		if(e.getSource()==btnEliminar){
			int op=list.getSelectedIndex();
	    	if(op==-1) {
	    		System.out.println("NO HAS SELECCIONADO UNA PERSONA A ELIMINAR");
	    	} else {
	    		modelo.remove(op);
	    		System.out.println("ELIMINADO EXITOSAMENTE");
	    	}
		}
	}
	@Override
    public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) { // Para evitar que se dispare el evento dos veces
        	int op=list.getSelectedIndex();
    	    if(op==-1) {
    	    	lblNombreBuscado.setText("Mi Nombre");
    	    	lblApellidoBuscado.setText("Mi Apellido");
    	    	lblEdadBuscada.setText("Mi Edad");
    	    } else {
    	    	Persona p = modelo.elementAt(op);
    	    	lblNombreBuscado.setText(p.getNombre());
    	    	lblApellidoBuscado.setText(p.getApellido());
    	    	lblEdadBuscada.setText(String.valueOf(p.getEdad()));
    	    }
        }
    }
	/**
	 * Create the frame.
	 */
	public ventana() {
		setTitle("CRUD PERSONAS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 600);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(250, 249, 245));
        contentPane.setBackground(new Color(63, 60, 98));
        contentPane.setBorder(new EmptyBorder(10, 5, 10, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel header = new JPanel();
        header.setForeground(new Color(250, 249, 245));
        header.setBackground(new Color(63, 60, 98));
        contentPane.add(header, BorderLayout.NORTH);

        JLabel titulo = new JLabel("CRUD Personas");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        titulo.setForeground(new Color(250, 249, 245));
        header.add(titulo);

        JPanel main = new JPanel();
        main.setForeground(new Color(250, 249, 245));
        main.setBackground(new Color(63, 60, 98));
        contentPane.add(main, BorderLayout.CENTER);
        main.setLayout(new BorderLayout(0, 0));

        JPanel menu = new JPanel();
        main.add(menu, BorderLayout.CENTER);
        menu.setBackground(new Color(63, 60, 98));
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

        // Añadir espacio vertical entre cada panel
        menu.add(Box.createVerticalGlue());

        JPanel accion = createPanel("Agregar Persona :");
        menu.add(accion);

        menu.add(Box.createVerticalGlue());

        JPanel nombre = createPanel("Nombre :");
        menu.add(nombre);
        nombreTextField = new JTextField();
        nombreTextField.setPreferredSize(new Dimension(150, 25));
        ((AbstractDocument) nombreTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) return;
                if (string.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ']*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) return;
                if (text.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ']*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        btnAgregar = new JButton();
        btnAgregar.setPreferredSize(new Dimension(150, 25));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(this);
        nombre.add(nombreTextField);
        nombre.add(btnAgregar);

        menu.add(Box.createVerticalGlue());

        JPanel apellido = createPanel("Apellido :");
        menu.add(apellido);
        apellidoTextField = new JTextField();
        apellidoTextField.setPreferredSize(new Dimension(150, 25));
        ((AbstractDocument) apellidoTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) return;
                if (string.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ']*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) return;
                if (text.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ']*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        btnEliminar = new JButton();
        btnEliminar.setPreferredSize(new Dimension(150, 25));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this);
        apellido.add(apellidoTextField);
        apellido.add(btnEliminar);

        menu.add(Box.createVerticalGlue());

        JPanel edad = createPanel("Edad :");
        menu.add(edad);
        edadTextField = new JTextField();
        edadTextField.setPreferredSize(new Dimension(150, 25));
        ((AbstractDocument) edadTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) return;
                if (string.matches("[0-9]*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) return;
                if (text.matches("[0-9]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        edad.add(edadTextField);

        menu.add(Box.createVerticalGlue());

        JPanel informacion = createPanel("Información :");
        menu.add(informacion);

        menu.add(Box.createVerticalGlue());

        JPanel infNombre = createPanel("Nombre :");
        menu.add(infNombre);
        lblNombreBuscado = new JLabel("Mi Nombre");
        lblNombreBuscado.setForeground(new Color(250, 249, 245));
        infNombre.add(lblNombreBuscado);

        menu.add(Box.createVerticalGlue());

        JPanel infApellido = createPanel("Apellido :");
        lblApellidoBuscado = new JLabel("Mi Apellido");
        lblApellidoBuscado.setForeground(new Color(250, 249, 245));
        infApellido.add(lblApellidoBuscado);
        menu.add(infApellido);

        menu.add(Box.createVerticalGlue());

        JPanel infEdad = createPanel("Edad :");
        lblEdadBuscada = new JLabel("Mi Edad");
        lblEdadBuscada.setForeground(new Color(250, 249, 245));
        infEdad.add(lblEdadBuscada);
        menu.add(infEdad);

        menu.add(Box.createVerticalGlue());

        JPanel listado = new JPanel();
        listado.setBackground(new Color(43, 45, 70));
        listado.setMinimumSize(new Dimension(200, 200));
        listado.setPreferredSize(new Dimension(200, 200));
        main.add(listado, BorderLayout.EAST);
        listado.setLayout(new BorderLayout(0, 0));

        list = new JList(modelo);
        list.setFont(new Font("Tahoma", Font.PLAIN, 10));
        list.setForeground(new Color(249, 249, 249));
        list.setBackground(new Color(43, 45, 70));
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Para evitar que se dispare el evento dos veces
                	int op=list.getSelectedIndex();
            	    if(op==-1) {
            	    	lblNombreBuscado.setText("Mi Nombre");
            	    	lblApellidoBuscado.setText("Mi Apellido");
            	    	lblEdadBuscada.setText("Mi Edad");
            	    } else {
            	    	Persona p = modelo.elementAt(op);
            	    	lblNombreBuscado.setText(p.getNombre());
            	    	lblApellidoBuscado.setText(p.getApellido());
            	    	lblEdadBuscada.setText(String.valueOf(p.getEdad()));
            	    }
                }
            }
        });
        listado.add(list, BorderLayout.CENTER);
    }

    // Método para crear un panel con un JLabel centrado
    private JPanel createPanel(String labelText) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Usar FlowLayout con alineación a la izquierda
        JLabel label = new JLabel(labelText);
        panel.setBackground(new Color(63, 60, 98));
        label.setForeground(new Color(250, 249, 245));
        panel.add(label);
        return panel;
    }

}
