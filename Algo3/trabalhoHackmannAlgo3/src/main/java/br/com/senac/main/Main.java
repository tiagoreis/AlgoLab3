package br.com.senac.main;

import br.com.senac.application.*;





import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
   
public class Main extends JFrame {     // main class for the game - a swing application
   
   // Define constants for the game
   static final int CANVAS_WIDTH = 800;    // width and height of the drawing canvas
   static final int CANVAS_HEIGHT = 600;
   private String numeros = null;
   private JLabel labelNumeroSorteado = new javax.swing.JLabel();
   private JLabel labelNumerosSorteados = new javax.swing.JLabel();
   private JButton btnSortear = new javax.swing.JButton();
   private Cartela cartela1 = new Cartela();
   private Cartela cartela2 = new Cartela();
   private Cartela cartela3 = new Cartela();
   private Cartela cartela4 = new Cartela();
   private List<Integer> sorteados = new ArrayList<Integer>();
   private JTextArea textAreaNumerosSorteados = new JTextArea("");

   // Constructor to initialize the UI components and game objects
   public Main() {
	  // Initialize the game objects
      gameInit();
	   
      // UI components
	  Container content = getContentPane();
	  content.setBackground(Color.DARK_GRAY);
	  content.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
	  content.setLayout(null);
	  Insets insets = content.getInsets();
	  
	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  this.pack();
	  this.setTitle("BINGO DO J&T");
	  
	  this.setVisible(true);
	  btnSortear.setBounds(insets.left+ 625, insets.top + 50, 100, 25);
	  btnSortear.setVisible(true);
	  this.add(btnSortear);
	  
	  labelNumeroSorteado.setBounds(insets.left+ 650, insets.top + 100, 50, 25);
	  labelNumeroSorteado.setBackground(Color.WHITE);
	  labelNumeroSorteado.setOpaque(true);
	  labelNumeroSorteado.setVisible(true);
	  labelNumeroSorteado.setHorizontalAlignment(JLabel.CENTER);
	  this.add(labelNumeroSorteado);
	  
//	  labelNumerosSorteados.setBounds(insets.left + 575, insets.top + 150, 200, 300);
//	  labelNumerosSorteados.setBackground(Color.WHITE);
//	  labelNumeroSorteado.setOpaque(true);
//	  labelNumerosSorteados.setVisible(true);
//	  this.add(labelNumerosSorteados);
	  
	  textAreaNumerosSorteados.setBounds(insets.left + 575, insets.top + 150, 200, 300);
	  textAreaNumerosSorteados.setBackground(Color.WHITE);
	  labelNumeroSorteado.setOpaque(true);
	  textAreaNumerosSorteados.setVisible(true);
	  this.textAreaNumerosSorteados.setEditable(false);
	  this.textAreaNumerosSorteados.setLineWrap(true);
	  this.add(this.textAreaNumerosSorteados);
	  
	  cartela1.setBounds(25 + insets.left, 15 + insets.top, (260), (250+30));
	  content.add(cartela1);
	  
	  cartela2.setBounds(insets.left + 300, 15 + insets.top, (260), (250+30));
	  content.add(cartela2);
	
	  cartela3.setBounds(25 + insets.left, 315 + insets.top, (260), (250+30));
	  content.add(cartela3);
	  
	  cartela4.setBounds(insets.left + 300, 315 + insets.top, (260), (250+30));
	  content.add(cartela4);
  	
   }
   
   @SuppressWarnings("deprecation")
   private void btnSortearActionPerformed(java.awt.event.ActionEvent evt) {                                           
       Random random = new Random();
       int numero = 0;
       boolean valido = false;
       
       do{
    	   numero = random.nextInt(99) + 1;
    	   valido = this.validarSorteio(numero);
       }while(!valido);
       
       this.labelNumeroSorteado.setText(String.valueOf(numero));
       if (this.labelNumerosSorteados.getText().equalsIgnoreCase("")) {
           numeros = String.valueOf(numero);
       } else {
           numeros += ("," + String.valueOf(numero));
       }

       System.out.println(numeros);
       labelNumerosSorteados.setText(numeros);
       labelNumerosSorteados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
       this.textAreaNumerosSorteados.setText(numeros);
       
       if(verificarResultado(numero)){
    	   this.labelNumeroSorteado.setText("Acabou");
    	   btnSortear.setEnabled(false);
       }


   	}                                
   
	private boolean verificarResultado(int numero) {
	
		if(cartela1.verificaCartela(numero)){
			return true;
		}
		if(cartela2.verificaCartela(numero)){
			return true;
		}
		if(cartela3.verificaCartela(numero)){
			return true;
		}
		if(cartela4.verificaCartela(numero)){
			return true;
		}

		return false;
	}

	public boolean validarSorteio(int numero){
		boolean validou = true;
		
		if(sorteados.contains(Integer.valueOf(numero))){
			return false;
		}
		
		return validou;
	}
   
   // ------ All the game related codes here ------
   
   // Initialize all the game objects, run only once.
   public void gameInit() { 
	   
	   btnSortear.setText("Sorteio");
       btnSortear.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               btnSortearActionPerformed(evt);
           }
       });
       
       labelNumeroSorteado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
       labelNumeroSorteado.setPreferredSize(new java.awt.Dimension(50, 15));
       labelNumeroSorteado.setText("");

   }
   
   // main
   public static void main(String[] args) {
      // Use the event dispatch thread to build the UI for thread-safety.
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Main();
         }
      });
   }
}
