package gui;

import semana_07.ArregloTemperaturas;

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

public class Problema_7_3 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblTemperatura;
	private JTextField txtTemperatura;
	private JButton btnAdicionar;
	private JButton btnEliminarAlFinal;
	private JButton btnEliminarTodo;
	private JButton btnRemplazarPrimeraTemperaturaFebril;
	private JButton btnRemplazarUltimaTemperaturaFebril;
	private JButton btnEliminarPrimeraTemperaturaFebril;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema_7_3 frame = new Problema_7_3();
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
	public Problema_7_3() {
		setTitle("Problema_7_3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTemperatura = new JLabel("Temperatura");
		lblTemperatura.setBounds(10, 10, 75, 23);
		contentPane.add(lblTemperatura);

		txtTemperatura = new JTextField();
		txtTemperatura.setBounds(95, 10, 86, 23);
		contentPane.add(txtTemperatura);
		txtTemperatura.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(290, 40, 260, 23);
		contentPane.add(btnAdicionar);

		btnEliminarAlFinal = new JButton("Eliminar al final");
		btnEliminarAlFinal.addActionListener(this);
		btnEliminarAlFinal.setBounds(290, 70, 260, 23);
		contentPane.add(btnEliminarAlFinal);

		btnEliminarTodo = new JButton("Eliminar todo");
		btnEliminarTodo.addActionListener(this);
		btnEliminarTodo.setBounds(290, 100, 260, 23);
		contentPane.add(btnEliminarTodo);
		
		btnRemplazarPrimeraTemperaturaFebril = new JButton("Remplazar primera temperatura febril");
		btnRemplazarPrimeraTemperaturaFebril.addActionListener(this);
		btnRemplazarPrimeraTemperaturaFebril.setBounds(290, 130, 260, 23);
		contentPane.add(btnRemplazarPrimeraTemperaturaFebril);
		
		btnRemplazarUltimaTemperaturaFebril = new JButton("Remplazar última temperatura febril");
		btnRemplazarUltimaTemperaturaFebril.addActionListener(this);
		btnRemplazarUltimaTemperaturaFebril.setBounds(290, 160, 260, 23);
		contentPane.add(btnRemplazarUltimaTemperaturaFebril);
		
		btnEliminarPrimeraTemperaturaFebril = new JButton("Eliminar primera temperatura febril");
		btnEliminarPrimeraTemperaturaFebril.addActionListener(this);
		btnEliminarPrimeraTemperaturaFebril.setBounds(290, 190, 260, 23);
		contentPane.add(btnEliminarPrimeraTemperaturaFebril);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 275, 412);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminarPrimeraTemperaturaFebril) {
			actionPerformedBtnEliminarPrimeraTemperaturaFebril(arg0);
		}
		if (arg0.getSource() == btnRemplazarUltimaTemperaturaFebril) {
			actionPerformedBtnRemplazarUltimaTemperaturaFebril(arg0);
		}
		if (arg0.getSource() == btnRemplazarPrimeraTemperaturaFebril) {
			actionPerformedBtnRemplazarPrimeraTemperaturaFebril(arg0);
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

	//  Declaraciòn global
	ArregloTemperaturas at = new ArregloTemperaturas();
	
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		try {
			at.adicionar(leerTemperatura());
			listar();
		}
		catch (Exception e) {
			mensaje("error de ingreso");
		}
	}
	protected void actionPerformedBtnEliminarAlFinal(ActionEvent arg0) {
		if (at.tamanio() > 0) {
			at.eliminarAlFinal();
			listar();
		}
		else
			mensaje("el Arreglo está vacío");	
	}
	protected void actionPerformedBtnEliminarTodo(ActionEvent arg0) {
		if (at.tamanio() > 0) {
			at.eliminarTodo();
			listar();
		}
		else
			mensaje("el Arreglo está vacío");	
	}
	protected void actionPerformedBtnRemplazarPrimeraTemperaturaFebril(ActionEvent arg0) {
		if (at.tamanio() > 0) {
			at.remplazarPrimeraTemperaturaFebril();
			listar();
		}
		else
			mensaje("el Arreglo está vacío");
	}
	protected void actionPerformedBtnRemplazarUltimaTemperaturaFebril(ActionEvent arg0) {
		if (at.tamanio() > 0) {
			at.remplazarUltimaTemperaturaFebril();
			listar();
		}
		else
			mensaje("el Arreglo está vacío");
	}
	protected void actionPerformedBtnEliminarPrimeraTemperaturaFebril(ActionEvent arg0) {
		if (at.tamanio() > 0) {
			at.eliminarPrimeraTemperaturaFebril();
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
		txtTemperatura.setText("");
		txtTemperatura.requestFocus();
	}
	void listar() {
		txtS.setText("");
		for (int i=0; i<at.tamanio(); i++)
			imprimir("temperatura[" + i + "] : " + at.obtener(i));
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//  Métodos que retornan valor (sin parámetros)
	double leerTemperatura()  {
		return Double.parseDouble(txtTemperatura.getText().trim());
	}
	
}