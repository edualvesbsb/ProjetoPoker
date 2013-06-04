package br.unb.poker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaDoJogo extends JFrame implements ActionListener { //Apenas para visualizacao! Haverá refactory

	
	//String[] end = new String[9];
	String nomeCliente,nomeAdversario,venced;
  
    int checkcont = 0;
    
	String conversa="";
	
    //As declarações dos componentes são feitas fora do construtor
	
    private JTextField aposta = new JTextField("0");
    private JTextArea chat = new JTextArea("");
    private JScrollPane scroll = new JScrollPane(chat);
    private JButton bet = new JButton("Bet");
    private JButton check = new JButton("Check");
    private JButton fold = new JButton("Fold");
    //private JScrollPane scrollpane;
    //private JList itemsList;
    private JLabel mesa1 = new JLabel();
    private JLabel mesa2 = new JLabel();
    private JLabel mesa3 = new JLabel();
    private JLabel mesa4 = new JLabel();
    private JLabel mesa5 = new JLabel();
    private JLabel vencedor = new JLabel();
    private JLabel jogador1Mao1 = new JLabel();
    private JLabel jogador1Mao2 = new JLabel();
    private JLabel jogador1Nickname = new JLabel();
    private JLabel jogador1Fichas = new JLabel();
    private JLabel jogador2Mao1 = new JLabel();
    private JLabel jogador2Mao2 = new JLabel();
    private JLabel jogador2Nickname = new JLabel();
    private JLabel jogador2Fichas = new JLabel();
    private JLabel fundo = new JLabel();
    private JLabel pote  = new JLabel("0"); 
    private JLabel areaChat = new JLabel();
    private Controlador controlador;
   
    public TelaDoJogo(Jogador A, Jogador B, Controlador controlador) { //Este é o construtor da classe TelaDoJogo
    	
    	this.controlador = controlador;
        setTitle("ProPoker");  
        setSize(800,535);  
        setLayout(null);  
       
        
        pote.setName("");
        pote.setBounds(395,32,80,25);
        pote.setForeground(Color.WHITE);
        
        aposta.setBounds(700,430,80,25);
        
        chat.setColumns(80);
        chat.setRows(6);
        
        bet.setBounds(700,460,80,30);
        bet.addActionListener(this);//É preciso registrar o controlador do botão
        
        check.setBounds(500,460,80,30);
        check.addActionListener(this);//É preciso registrar o controlador do botão
        
        fold.setBounds(600,460,80,30);
        fold.addActionListener(this);//É preciso registrar o controlador do botão
       
        mesa1.setIcon(new ImageIcon(this.getClass().getResource("img/Cardback.png")));
        mesa1.setBounds(230,180,65,87);
                    
        mesa2.setIcon(new ImageIcon(this.getClass().getResource("img/Cardback.png")));
        mesa2.setBounds(300,180,65,87);
        
        mesa3.setIcon(new ImageIcon(this.getClass().getResource("img/Cardback.png")));
        mesa3.setBounds(370,180,65,87);
        
        mesa4.setIcon(new ImageIcon(this.getClass().getResource("img/Cardback.png")));
        mesa4.setBounds(440,180,65,87);
        
        mesa5.setIcon(new ImageIcon(this.getClass().getResource("img/Cardback.png")));
        mesa5.setBounds(510,180,65,87);
        
        jogador1Mao1.setIcon(new ImageIcon(this.getClass().getResource("img/" + Integer.toString(A.getMao_01().getValor()+1) + A.getMao_01().getS_naipe() + ".png")));
        jogador1Mao1.setBounds(45,195,65,87);
        
        jogador1Mao2.setIcon(new ImageIcon(this.getClass().getResource("img/" + Integer.toString(A.getMao_02().getValor()+1) + A.getMao_02().getS_naipe() + ".png")));
        jogador1Mao2.setBounds(30,180,65,87);

        jogador1Nickname.setText(A.getNickname());
        jogador1Nickname.setBounds(30,120,80,25);
        jogador1Nickname.setForeground(Color.white);
        
        jogador1Fichas.setText(Integer.toString(A.getFichas()));
        jogador1Fichas.setBounds(30,140,80,25);
        jogador1Fichas.setForeground(Color.white);
        
        jogador2Mao1.setIcon(new ImageIcon(this.getClass().getResource("img/Cardback.png")));
        jogador2Mao1.setBounds(700,195,65,87);
        
        jogador2Mao2.setIcon(new ImageIcon(this.getClass().getResource("img/Cardback.png")));
        jogador2Mao2.setBounds(685,180,65,87);
        
        jogador2Nickname.setText(B.getNickname());
        jogador2Nickname.setBounds(685,120,80,25);
        jogador2Nickname.setForeground(Color.WHITE);
        
        jogador2Fichas.setText(Integer.toString(B.getFichas()));
        jogador2Fichas.setBounds(685,140,80,25);
        jogador2Fichas.setForeground(Color.WHITE);
        
        
        vencedor.setBounds(350,400,290,40);
        vencedor.setForeground(Color.BLUE);
        
              
        fundo.setIcon(new ImageIcon(this.getClass().getResource("img/mesa.jpg")));
        fundo.setBounds(0,0,this.getWidth(),this.getHeight());
        
        getContentPane().add(chat);
        getContentPane().add(pote);
        getContentPane().add(bet);
        getContentPane().add(check);
        getContentPane().add(vencedor);
        getContentPane().add(fold);
        getContentPane().add(aposta);
        getContentPane().add(mesa1);
        getContentPane().add(mesa2);
        getContentPane().add(mesa3);
        getContentPane().add(mesa4);
        getContentPane().add(mesa5);
        getContentPane().add(jogador1Mao1);
        getContentPane().add(jogador1Mao2);
        getContentPane().add(jogador1Nickname);
        getContentPane().add(jogador1Fichas);
        getContentPane().add(jogador2Mao1);
        getContentPane().add(jogador2Mao2);
        getContentPane().add(jogador2Nickname);
        getContentPane().add(jogador2Fichas);
        getContentPane().add(fundo);
        getContentPane().add(scroll);
        getContentPane().add(areaChat); //Efetivamente adiciona os componentes no JFrame
        
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
      
    }  
      
	public void actionPerformed(ActionEvent ae) // Implementação do método actionPerformed, que dará utilidade aos botões check, fold e bet
	{
		String comando = ae.getActionCommand();

		if (comando.equals("Bet")) {

			int valorApostado = Integer.parseInt(aposta.getText()); // Ilustrativo

			try {
				controlador.alterarFichasJogador1(valorApostado);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				;
			}
			controlador.alterarPote(valorApostado);

			try {// Ilustrativo, modelo arquitetural ainda nao esta completamente implementado
				if (valorApostado > Integer.parseInt(jogador1Fichas.getText())) {

					throw new Exception("ex");
				}
				jogador1Fichas.setText(Integer.toString((Integer
						.parseInt(jogador1Fichas.getText()) - valorApostado)));
				pote.setText(""
						+ Integer.toString(valorApostado
								+ Integer.parseInt(pote.getText())));
			} catch (Exception ex) {
				// Ilustrativo
			}

		} else if (comando.equals("Check")) {

			System.out.println("Check");

		} else if (comando.equals("Fold")) {

			System.out.println("Fold");

		}
    }

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}  
     
}
