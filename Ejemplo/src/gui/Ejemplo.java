package gui;

import semana_07.Arreglo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Ejemplo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JButton btnBuscarAdicionar;
	private JButton btnPrimeroAlFinal;
	private JButton btnUltimoAlInicio;
	private JButton btnBuscarEliminar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo frame = new Ejemplo();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejemplo() {
		setTitle("Ejemplo - Semana_07");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNumero = new JLabel("Número");
		lblNumero.setBounds(10, 11, 50, 23);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtNumero.setBounds(66, 11, 50, 23);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		btnBuscarAdicionar = new JButton("Buscar / adicionar");
		btnBuscarAdicionar.addActionListener(this);
		btnBuscarAdicionar.setBounds(340, 48, 180, 23);
		contentPane.add(btnBuscarAdicionar);
		
		btnPrimeroAlFinal = new JButton("Primero al final");
		btnPrimeroAlFinal.addActionListener(this);
		btnPrimeroAlFinal.setBounds(340, 78, 180, 23);
		contentPane.add(btnPrimeroAlFinal);
		
		btnUltimoAlInicio = new JButton("Último al inicio");
		btnUltimoAlInicio.addActionListener(this);
		btnUltimoAlInicio.setBounds(340, 108, 180, 23);
		contentPane.add(btnUltimoAlInicio);
	
		btnBuscarEliminar = new JButton("Buscar / eliminar");
		btnBuscarEliminar.addActionListener(this);
		btnBuscarEliminar.setBounds(340, 138, 180, 23);
		contentPane.add(btnBuscarEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 315, 400);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
	
	//  Declaración global
	Arreglo a = new Arreglo();

	/**
				.----.----.----.----.----.----.----.----.----.----.
		n  ==>  |    |    |    |    |    |    |    |    |    |    |   
				'----'----'----'----'----'----'----'----'----'----'
		  		   0    1    2    3    4    5    6    7    8    9
                indice
	 */

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscarEliminar) {
			actionPerformedBtnBuscarEliminar(arg0);
		}
		if (arg0.getSource() == btnUltimoAlInicio) {
			actionPerformedBtnUltimoAlInicio(arg0);
		}
		if (arg0.getSource() == btnPrimeroAlFinal) {
			actionPerformedBtnPrimeroAlFinal(arg0);
		}
		if (arg0.getSource() == btnBuscarAdicionar) {
			actionPerformedBtnBuscarAdicionar(arg0);
		}
		limpieza();
	}
	/**
	 *  Lee un número, lo busca, y si no está registrado lo adiciona
	 */	
	protected void actionPerformedBtnBuscarAdicionar(ActionEvent arg0) {
		try {
			a.buscarAdicionar(leerNumero());  
			listar();
		}
		catch (Exception e) {
			mensaje("error de ingreso");
		}
	}
	/**
	 *  Traslada el primer número al final
	 */
	protected void actionPerformedBtnPrimeroAlFinal(ActionEvent arg0) {
		a.primeroAlFinal();
		listar();
	}
	/**
	 *  Traslada el último número al inicio
	 */
	protected void actionPerformedBtnUltimoAlInicio(ActionEvent arg0) {
		a.ultimoAlInicio();
		listar();
	}
	/**
	 *  Lee un número, lo busca, y si está registrado lo elimina
	 */
	protected void actionPerformedBtnBuscarEliminar(ActionEvent arg0) {
		try {
			a.buscarEliminar(leerNumero());  
			listar();
		}
		catch (Exception e) {
			mensaje("error de ingreso");
		}
	}
	//  Métodos tipo void (sin parámetros)
	void imprimir() {
		imprimir("");
	}
	void limpieza() {
		txtNumero.setText("");
		txtNumero.requestFocus();
	}
	void listar() {
		txtS.setText("");
		for (int i=0; i<a.tamanio(); i++)
			imprimir("n[" + i + "] : " + a.obtener(i));
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerNumero()  {
		return Integer.parseInt(txtNumero.getText().trim());
	}
	
}