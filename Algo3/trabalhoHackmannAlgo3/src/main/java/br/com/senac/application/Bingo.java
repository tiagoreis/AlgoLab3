package br.com.senac.application;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;


public class Bingo extends JFrame implements MouseListener  {

	private final int TAMANHO_CARTELA = 5;
	private JLabel carta;
	private JLabel carta2;
	private JButton bt;

	private JFrame frame;
	private JTextField txtTesteBin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bingo window = new Bingo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Bingo() {
		
		boolean teste = false;
		
		if(teste){
			initialize();
		} else {
			gerarCartela1();
				
		}		
		
	}
	
	public void gerarCartela1(){
		
		
			Random random = new Random();
			
			int[][]numerosCartela1 = new int[this.TAMANHO_CARTELA][this.TAMANHO_CARTELA];	
			
			
			JPanel cartela1 = new JPanel(new GridLayout(5,3));
			JPanel cartela2 = new JPanel(new GridLayout(5,3));
			JPanel grade = new JPanel(new GridLayout(5,5));
			
			JLabel label = new JLabel();
			JLabel[][] labels = new JLabel[this.TAMANHO_CARTELA][this.TAMANHO_CARTELA];
			
//											     largura / altura	
			cartela1.setLayout(new GridLayout(5, 3, 10, 3));
			cartela2.setLayout(new GridLayout(5, 3, 10, 3));
			
			for (int i = 0; i < this.TAMANHO_CARTELA; i++) {
				for (int j = 0; j < this.TAMANHO_CARTELA; j++) {
					boolean validado = false;
					int numeroRandom = 0;
					while(validado == false){
						numeroRandom = random.nextInt(98 + 1);	
						validado = validarNumero(numeroRandom, numerosCartela1);
						numerosCartela1[i][j] = numeroRandom;	
					}
				}
			}
			
			
			boolean cartelaPreenchida = false;
			int[] numeroSorteado = null;
			
			while(cartelaPreenchida == false){
				for (int j = 0; j < 99; j++) {
					boolean validado = false;
					int numeroRandom = 0;
					
					while(validado == false){
						numeroRandom = random.nextInt(98 + 1);	
						validado = validarNumeroJaSorteado(numeroRandom, numeroSorteado);
						numeroSorteado[j] = numeroRandom;	
					}
					
					verificaNumeroCartela1(numerosCartela1, numeroRandom);
				}
			}
			
			
			
			
/*			
			for (int i = 0; i < this.TAMANHO_CARTELA; i++) {
				for (int j = 0; j < this.TAMANHO_CARTELA; j++) {
					int valor = arrays[i][j];
					labels[i][j] = new JLabel();   
			        labels[i][j].setText(String.valueOf(valor)); 
			        cartela1.add(labels[i][j]);
			        cartela2.add(labels[i][j]);
			        
				}
			}

			
			frame = new JFrame();
			frame.getContentPane().add(cartela1, BorderLayout.WEST);
			frame.getContentPane().add(cartela2, BorderLayout.EAST);
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.NORTH);
			
			txtTesteBin = new JTextField();
			txtTesteBin.setBackground(Color.RED);
			txtTesteBin.setText("teste bin");
			txtTesteBin.setEnabled(false);
			txtTesteBin.setEditable(false);

			panel.add(txtTesteBin);
			txtTesteBin.setColumns(10);
*/
//			this.setSize(300, 400);
//			this.setResizable(true);
//			this.setLocation((800 - 300) / 2, (600 - 200) / 2);
//			this.setVisible(true);
		
	}
	
	private void verificaNumeroCartela1(int[][] numerosCartela1,
			int numeroRandom) {
		// TODO Auto-generated method stub[
		
		for (int i = 0; i < numerosCartela1.length; i++) {
			for (int j = 0; j < numerosCartela1.length; j++) {
				if(numerosCartela1[i][j] == numeroRandom){
					
				}
			}
		}
		
		
	}

	public boolean validarNumero(int numero, int[][] arrays){
		boolean validou = true;
		
		if(numero > 0 && numero < 100){
			for (int i = 0; i < arrays.length; i++) {
				for (int j = 0; j < arrays.length; j++) {
					if(arrays[i][j] == numero){
						return false;
					}
				}
			}
		}
		
		return validou;
	}

	public boolean validarNumeroJaSorteado(int numero, int[] array){
		boolean validou = true;
		
		if(numero > 0 && numero < 100){
			for (int i = 0; i < array.length; i++) {
				if(array[i] == numero){
					return false;
				}
			}
		}
		
		return validou;
	}

	
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		txtTesteBin = new JTextField();
		txtTesteBin.setBackground(Color.RED);
		txtTesteBin.setText("teste bin");
		panel.add(txtTesteBin);
		txtTesteBin.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
		JLabel lblCart = new JLabel("cart");
		panel_1.add(lblCart);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
	}
	
	private void teste() {
		this.setSize(200, 300);
		this.criaGUI();
		this.setVisible(true);
		this.setResizable(true);
		this.setLocation((800 - 300) / 2, (600 - 200) / 2);
		
	}

	public void criaGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new GridLayout(2,2));
		carta = new JLabel();
		carta2 = new JLabel("oi mundo");
		bt = new JButton("Algoritmos");
		carta.addMouseListener(this);
		carta.setText("antes de clicar");
		window.add(carta);
		window.add(carta2);
		window.add(bt);
	}

	public void mouseClicked(MouseEvent event) {
		carta.setText("clicou");
	}

	public void mouseReleased(MouseEvent event) {
	}

	public void mousePressed(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {
	}


}
