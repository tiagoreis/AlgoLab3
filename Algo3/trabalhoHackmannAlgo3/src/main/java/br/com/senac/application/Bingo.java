package br.com.senac.application;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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
	private int[][] numerosCartela1 = new int[this.TAMANHO_CARTELA][this.TAMANHO_CARTELA];
	private JLabel[][] labelCartela1 = new JLabel[this.TAMANHO_CARTELA][this.TAMANHO_CARTELA];
	private JButton botaoSortearNumero = new JButton();
	private int[] numeroSorteado;
	private JLabel numero = new JLabel();
	
	
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
		
		boolean teste = true;
		
		if(teste){
			initialize();
		} else {
			gerarCartela1();
				
		}		
		
	}
	
	public void gerarCartela1(){
		
		
			Random random = new Random();
			
				
			
			
			JPanel cartela1 = new JPanel(new GridLayout(5,3));
			JPanel cartela2 = new JPanel(new GridLayout(5,3));
//			JPanel grade = new JPanel(new GridLayout(5,5));
			
//			JLabel label = new JLabel();
//			JLabel[][] labels = new JLabel[this.TAMANHO_CARTELA][this.TAMANHO_CARTELA];
			
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
//						numeroSorteado[j] = numeroRandom;	
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
		
		for (int i = 0; i < numerosCartela1.length; i++) {
			for (int j = 0; j < numerosCartela1.length; j++) {
				if(numerosCartela1[i][j] == numeroRandom){
					
				}
			}
		}
		
		
	}

	public boolean validarNumero(int numero, int[][] arrays){
		boolean validou = false;
		
		if(numero > 0 && numero < 100){
			for (int i = 0; i < arrays.length; i++) {
				for (int j = 0; j < arrays.length; j++) {
					
					if(arrays[i][j] == numero){
						return false;
					} else {
						validou = true;
					}
				}
			}
		}
		
		return validou;
	}

	public boolean validarNumeroCartela(int numero){
		boolean validou = false;
		
		if(numero > 0 && numero < 100){
			for (int i = 0; i < numeroSorteado.length; i++) {
					
				if(numeroSorteado[i] == numero){
					return false;
				} else {
					return true;
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
		frame.setBounds(10, 10, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		txtTesteBin = new JTextField();
		txtTesteBin.setBackground(Color.RED);
		txtTesteBin.setText("teste bin");
		txtTesteBin.setColumns(10);
		txtTesteBin.setEditable(false);
		txtTesteBin.setEnabled(false);
		
		
		panel.add(txtTesteBin);
		
		JPanel cartela1 = new JPanel();
		JPanel cartela2 = new JPanel();
		JPanel centro = new JPanel();
		
		
		cartela1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		cartela1.setLayout(new GridLayout(5, 5, 5, 3));
		frame.getContentPane().add(cartela1, BorderLayout.WEST);
		
		cartela2.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		cartela2.setLayout(new GridLayout(5, 5, 5, 3));
		frame.getContentPane().add(cartela2, BorderLayout.EAST);
		
		centro.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
//		centro.setLayout(new GridLayout(2, 2, 2, 2));
//		centro.setMaximumSize( new Dimension(50,40));
		JLabel centroTitulo = new JLabel();
		centroTitulo.setText("SORTEIO");
		
		JLabel centroIcone = new JLabel();
		centroIcone.setIcon(new javax.swing.ImageIcon("C:\\xampp\\htdocs\\Teste bingo\\src\\bingo-sorteio.gif"));
		
		
		
		
		//TODO
		JLabel botao = new JLabel();
		botaoSortearNumero.setText("Sortear Número");
		botaoSortearNumero.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	
		    	numero = botaoSortearNumeroActionPerformed(evt);
		    }

		});

		botao.add(botaoSortearNumero);
		
		
		centro.add(centroTitulo);
		centro.add(centroIcone);
//		centro.add(botao);
		centro.add(botaoSortearNumero);
		centro.add(numero);
		
		centro.setPreferredSize(new Dimension(80,60));

		frame.getContentPane().add(centro, BorderLayout.CENTER);
		

		
		int[][] numerosCartela1 = gerarNumerosCartela();
		int[][] numerosCartela2 = gerarNumerosCartela();
		
		

		cartela1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CARTELA 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));  
		cartela2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CARTELA 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));  
		
		
		for (int i = 0; i < this.TAMANHO_CARTELA; i++) {
			for (int j = 0; j < this.TAMANHO_CARTELA; j++) {
				JLabel label = new JLabel();
				
				if(i == 2 && j == 2){
					label.setText("Coringa");
				} else {
					label.setText(String.valueOf(numerosCartela1[i][j]));
				}
				cartela1.add(label);		
				
			}
		}

		for (int i = 0; i < this.TAMANHO_CARTELA; i++) {
			for (int j = 0; j < this.TAMANHO_CARTELA; j++) {
				JLabel label = new JLabel();
				
				if(i == 2 && j == 2){
					label.setText("Coringa");
				} else {
					label.setText(String.valueOf(numerosCartela2[i][j]));
				}
				cartela2.add(label);		
				
			}
		}

		
	}
	
	private int[][] gerarNumerosCartela() {
		Random random = new Random();
		int[][] numerosCartela = new int[this.TAMANHO_CARTELA][this.TAMANHO_CARTELA];

		for (int i = 0; i < this.TAMANHO_CARTELA; i++) {
			for (int j = 0; j < this.TAMANHO_CARTELA; j++) {
				boolean validado = false;
				int numeroRandom = 0;
				while(validado == false){
					numeroRandom = random.nextInt(98 + 1);	
					validado = validarNumero(numeroRandom, numerosCartela);
					numerosCartela[i][j] = numeroRandom;	
				}
			}
		}

		return numerosCartela;
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
	

	private JLabel botaoSortearNumeroActionPerformed(ActionEvent evt) {
		JLabel numeroBotao = new JLabel();
		numeroBotao = gerarNumerosSorteado();
		return numeroBotao;
	}
	
	private JLabel gerarNumerosSorteado() {
		Random random = new Random();
		JLabel labelGerarNumerosSorteado = new JLabel(); 
		boolean validado = false;
		int numeroRandom = 0;
		while(validado == false){
			numeroRandom = random.nextInt(98 + 1);	
//			validado = validarNumeroCartela(numeroRandom);
			numero.setText(String.valueOf(numeroRandom));
			labelGerarNumerosSorteado.setText(String.valueOf(numeroRandom));
//			numeroSorteado = numeroRandom;
			validado = true;
			
		}
		return labelGerarNumerosSorteado;

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
