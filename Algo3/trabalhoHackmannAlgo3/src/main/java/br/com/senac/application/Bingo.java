package br.com.senac.application;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Bingo extends JFrame implements MouseListener  {

	private final int TAMANHO_CARTELA = 5;
	private JLabel carta;
	private JLabel carta2;
	private JButton bt;

	public void gerarCartela1(){
		
		boolean teste = false;
		
		if(teste){
			this.teste();
		} else {
			
			Random random = new Random();
			
			int[][]arrays = new int[this.TAMANHO_CARTELA][this.TAMANHO_CARTELA]; 
			
			JPanel cartela = new JPanel(new GridLayout(2,1));
			JPanel grade = new JPanel(new GridLayout(5,5));
			
			JLabel label = new JLabel();
			JLabel[][] labels = new JLabel[this.TAMANHO_CARTELA][this.TAMANHO_CARTELA];
			
			Container window = getContentPane();
			window.setLayout(new GridLayout(5,5));

			
			for (int i = 0; i < this.TAMANHO_CARTELA; i++) {
				for (int j = 0; j < this.TAMANHO_CARTELA; j++) {
					
					boolean validado = false;
					int numeroRandom = 0;
					while(validado == false){
						numeroRandom = random.nextInt(98 + 1);	
						validado = validarNumero(numeroRandom, arrays);
						arrays[i][j] = numeroRandom;	
					}
					
					grade.add(new JLabel(String.valueOf(numeroRandom)));
				}
			}
			
			
			
			for (int i = 0; i < this.TAMANHO_CARTELA; i++) {
				for (int j = 0; j < this.TAMANHO_CARTELA; j++) {
					
					int valor = arrays[i][j];
					labels[i][j] = new JLabel();   
			        labels[i][j].setText(String.valueOf(valor)); 
			         
				}
			}
			
			for (int i=0; i<this.TAMANHO_CARTELA; i++) {   
				for (int j = 0; j < this.TAMANHO_CARTELA; j++) {
					
					if(i == 2 && j ==2){
						JLabel coringa = new JLabel("cúringa");
						window.add(coringa);
					} else {
						window.add(labels[i][j]);		
					}
				}
		    }

//			cartela.
//			cartela.add(grade);
//			JFrame frame;
//
//	        frame = new JFrame("Bingo");
//	        frame.add(grade);
//	        frame.pack();
//	        frame.setVisible(true);
//	        frame.setSize(300, 350);
//	        frame.setLocation((800 - 300) / 2, (600 - 200) / 2);
//			frame.setResizable(true);

			
			this.setSize(200, 300);
			this.setVisible(true);
			this.setResizable(true);
			this.setLocation((800 - 300) / 2, (600 - 200) / 2);

			
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
