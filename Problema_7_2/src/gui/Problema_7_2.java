package gui;

import semana_07.ArregloNotas;

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

public class Problema_7_2 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblNota;
	private JTextField txtNota;
	private JButton btnAdicionar;
	private JButton btnEliminarAlFinal;
	private JButton btnEliminarTodo;
	private JButton btnRemplazarUltimaNotaAaprobatoria;
	private JButton btnEliminarPrimeraNotaAprobatoria;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema_7_2 frame = new Problema_7_2();
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
	public Problema_7_2() {
		setTitle("Problema_7_2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNota = new JTextField();
		txtNota.setBounds(66, 10, 86, 23);
		contentPane.add(txtNota);
		txtNota.setColumns(10);

		lblNota = new JLabel("Nota");
		lblNota.setBounds(10, 10, 46, 23);
		contentPane.add(lblNota);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(300, 40, 245, 23);
		contentPane.add(btnAdicionar);

		btnEliminarAlFinal = new JButton("Eliminar al final");
		btnEliminarAlFinal.addActionListener(this);
		btnEliminarAlFinal.setBounds(300, 70, 245, 23);
		contentPane.add(btnEliminarAlFinal);
		
		btnEliminarTodo = new JButton("Eliminar todo");
		btnEliminarTodo.addActionListener(this);
		btnEliminarTodo.setBounds(300, 100, 245, 23);
		contentPane.add(btnEliminarTodo);

		btnRemplazarUltimaNotaAaprobatoria = new JButton("Remplazar \u00FAltima nota aprobatoria");
		btnRemplazarUltimaNotaAaprobatoria.addActionListener(this);
		btnRemplazarUltimaNotaAaprobatoria.setBounds(300, 130, 245, 23);
		contentPane.add(btnRemplazarUltimaNotaAaprobatoria);

		btnEliminarPrimeraNotaAprobatoria = new JButton("Eliminar primera nota aprobatoria");
		btnEliminarPrimeraNotaAprobatoria.addActionListener(this);
		btnEliminarPrimeraNotaAprobatoria.setBounds(300, 160, 245, 23);
		contentPane.add(btnEliminarPrimeraNotaAprobatoria);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 280, 412);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}

	//  Declaraciòn global
	ArregloNotas an = new ArregloNotas();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminarPrimeraNotaAprobatoria) {
			actionPerformedBtnEliminarPrimeraNotaAprobatoria(arg0);
		}
		if (arg0.getSource() == btnRemplazarUltimaNotaAaprobatoria) {
			actionPerformedBtnRemplazarUltimaNotaAaprobatoria(arg0);
		}
		if (arg0.getSource() == btnEliminarTodo) {
			actionPerformedBtnEliminarTodo(arg0);
		}
		if (arg0.getSource() == btnEliminarAlFinal) {
			actionPerformedBtnEliminarAlFinal(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		limpieza();
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		try {
			an.adicionar(leerNota());
			listar();
		}
		catch (Exception e) {
			mensaje("error de ingreso");
		}
	}
	protected void actionPerformedBtnEliminarAlFinal(ActionEvent arg0) {
		if (an.tamanio() > 0) {
			an.eliminarAlFinal();
			listar();
		}
		else
			mensaje("el Arreglo está vacío");		
	}
	protected void actionPerformedBtnEliminarTodo(ActionEvent arg0) {
		if (an.tamanio() > 0) {
			an.eliminarTodo();
			listar();
		}
		else
			mensaje("el Arreglo está vacío");	
	}
	protected void actionPerformedBtnRemplazarUltimaNotaAaprobatoria(ActionEvent arg0) {
		if (an.tamanio() > 0) {
			an.remplazarUltimaNotaAprobatoria();
			listar();
		}
		else
			mensaje("el Arreglo está vacío");	
	}
	protected void actionPerformedBtnEliminarPrimeraNotaAprobatoria(ActionEvent arg0) {
		if (an.tamanio() > 0) {
			an.eliminarPrimeraNotaAprobatoria();
			listar();
		}
		else
			mensaje("el Arreglo está vacío");	
	}
	//  Métodos tipo void (sin parámetros)
	void imprimir() {
		imprimir("");
	}
	void limpieza() {
		txtNota.setText("");
		txtNota.requestFocus();
	}
	void listar() {
		txtS.setText("");
		for (int i=0; i<an.tamanio(); i++)
			imprimir("nota[" + i + "] : " + an.obtener(i));
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerNota()  {
		return Integer.parseInt(txtNota.getText().trim());
	}
	
}