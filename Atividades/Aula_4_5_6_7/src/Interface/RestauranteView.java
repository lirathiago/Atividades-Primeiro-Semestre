package Interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class RestauranteView extends JFrame implements ActionListener
{     	
   protected JMenuBar	barMenuPrincipal;   
   
   protected JMenu		menuUsuario, menuPedido, menuCaixa, menuConta, menuNotaFiscal, menuIdioma,
   						menuCardapio, menuPagamento, menuCozinha;   
   
   protected JMenuItem	itemCadastrarUsuario,itemConsultarEditarUsuario, itemFinalizarPrato, itemListarPratosMaisVendidos , 
   						itemFecharNotaFiscal, itemFecharConta, itemSair, itemEmitirNotaFiscal, itemIngles, 
   						itemEspanhol, itemPortugues, itemPriorizarPedido, 
   						itemConsultarHorarioDePico, itemIncluirPedido, itemEditarPedido,
   						itemFecharCaixa, itemConsultarNotaFiscal, itemIncluirCardapio, itemConsultarEditarCardapio;   
   
   protected JFrame		frame;   
   
   private ImageIcon	icon, iconUser;  
   
   private JLabel		lblNomeUsuario, lblTUsuario, lblNomeRestaurante, lblIconUser;
  
   private JPanel		pnl, pnlCentro, pnlOeste, pnlSul;
   
   private ResourceBundle	bn=null;
   
   
   CardapioView cardapio; 
   //Internacionalizacao inter;
     
   public RestauranteView(ResourceBundle bundle){
      super();
      {
         bn = bundle;
    	  
    	 setTitle(bn.getString("tituloRestaurante"));
    	 
    	//Icon
    	 iconUser = new ImageIcon("iconUser1.png");
    	 lblIconUser = new JLabel(iconUser);
    	 
    	 //MenuBar
         barMenuPrincipal = new JMenuBar();    
         
         //JPanel
         pnl = new JPanel(new BorderLayout(10, 10));
         this.add(pnl);
         
         //Panel West
         pnlOeste 	= new JPanel();
         pnlOeste.setLayout(new GridLayout(6, 0));
         pnl.add(pnlOeste, BorderLayout.WEST);
         
         pnlOeste.add(lblIconUser);
                 
         //Panel Center
    	 pnlCentro = new JPanel();   	
    	 
    	 //Panel South
    	 pnlSul = new JPanel();
    	 pnlSul.setLayout(new FlowLayout(FlowLayout.CENTER));

    	 lblNomeRestaurante = new JLabel(bn.getString("tituloRestaurante"));
    	    	 
    	 pnl.add(pnlSul, BorderLayout.SOUTH);	
    	 
    	 pnlSul.add(lblNomeRestaurante);
         
         //JFrame
         frame = new JFrame();         
         
         //JMenu         
         menuCaixa = new JMenu(bn.getString("menuCaixa"));         
         menuConta = new JMenu(bn.getString("menuConta"));         
         menuNotaFiscal = new JMenu(bn.getString("menuNotaFiscal"));         
         menuPedido = new JMenu(bn.getString("menuPedido"));         
         menuIdioma = new JMenu(bn.getString("menuIdioma"));
         menuUsuario = new JMenu(bn.getString("menuUsuario"));
         menuCardapio = new JMenu(bn.getString("menuCardapio"));         
         menuPagamento = new JMenu(bn.getString("menuPagamento"));
         menuCozinha = new JMenu(bn.getString("menuCozinha"));
         
         //JMenuItem
         itemCadastrarUsuario = new JMenuItem(bn.getString("itemCadastrarUsuario"));
         itemConsultarEditarUsuario = new JMenuItem(bn.getString("itemConsultarEditarUsuario"));
         itemSair = new JMenuItem(bn.getString("itemSair"));         
         
         itemEmitirNotaFiscal = new JMenuItem(bn.getString("itemEmitirNotaFiscal"));         
         itemFecharNotaFiscal = new JMenuItem(bn.getString("itemFecharNotaFiscal"));         
         itemConsultarNotaFiscal = new JMenuItem(bn.getString("itemConsultarNotaFiscal"));
         
         itemListarPratosMaisVendidos = new JMenuItem(bn.getString("itemListarPratosMaisVendidos"));
         itemPriorizarPedido = new JMenuItem(bn.getString("itemPriorizarPedido"));
         itemConsultarHorarioDePico = new JMenuItem(bn.getString("itemConsultarHorarioDePico"));
         itemIncluirPedido = new JMenuItem(bn.getString("itemIncluirPedido"));
         itemEditarPedido = new JMenuItem(bn.getString("itemEditarPedido"));
         itemFinalizarPrato = new JMenuItem(bn.getString("itemFinalizarPrato"));                  
         
         itemIngles = new JMenuItem(bn.getString("itemIngles"));         
         itemEspanhol = new JMenuItem(bn.getString("itemEspanhol"));         
         itemPortugues = new JMenuItem(bn.getString("itemPortugues"));

         itemFecharCaixa = new JMenuItem(bn.getString("itemFecharCaixa"));
         itemFecharConta = new JMenuItem(bn.getString("itemFecharConta"));
         
         itemIncluirCardapio = new JMenuItem(bn.getString("itemIncluirCardapio"));
         itemConsultarEditarCardapio = new JMenuItem(bn.getString("itemConsultarEditarCardapio"));
         
         //Adicionando Menu no JMenuBar
         //barMenuPrincipal.add(menuUsuario);
         //barMenuPrincipal.add(menuCozinha);
         //barMenuPrincipal.add(menuCaixa);
         //barMenuPrincipal.add(menuConta);
         //barMenuPrincipal.add(menuNotaFiscal);
         //barMenuPrincipal.add(menuPedido);
         //barMenuPrincipal.add(menuPagamento);
         barMenuPrincipal.add(menuCardapio);
         //barMenuPrincipal.add(menuIdioma);
         
         //Adicionando Itens no JMenu        
         menuUsuario.add(itemCadastrarUsuario);
         menuUsuario.add(itemConsultarEditarUsuario);
         menuUsuario.addSeparator();
         menuUsuario.add(itemSair);        
         
         menuCaixa.add(itemFecharCaixa);
         
         menuConta.add(itemFecharConta);
         
         menuNotaFiscal.add(itemEmitirNotaFiscal);
         menuNotaFiscal.add(itemConsultarNotaFiscal);
         menuNotaFiscal.addSeparator();
         menuNotaFiscal.add(itemFecharNotaFiscal);
         
         menuPedido.add(itemIncluirPedido);
         menuPedido.add(itemEditarPedido);
         menuPedido.addSeparator();
         menuPedido.add(itemListarPratosMaisVendidos);
         menuPedido.add(itemConsultarHorarioDePico);
         menuPedido.add(itemFinalizarPrato);
         menuPedido.add(itemPriorizarPedido);
         
         menuCardapio.add(itemIncluirCardapio);
         menuCardapio.add(itemConsultarEditarCardapio);
         
         menuIdioma.add(itemPortugues);
         menuIdioma.add(itemIngles);
         menuIdioma.add(itemEspanhol);        
         
         //Action Listener - dando a��es aos bot�es
 		 itemCadastrarUsuario.addActionListener(this);
 		itemConsultarEditarUsuario.addActionListener(this);
 		 itemFinalizarPrato.addActionListener(this);
 		 itemFecharNotaFiscal.addActionListener(this);
 		 itemFecharConta.addActionListener(this);
 		 itemSair.addActionListener(this);
 		 itemEmitirNotaFiscal.addActionListener(this);
 		 itemListarPratosMaisVendidos.addActionListener(this);
 		 itemPriorizarPedido.addActionListener(this);
 		 itemConsultarHorarioDePico.addActionListener(this);
 		 itemIncluirPedido.addActionListener(this);
 		 itemEditarPedido.addActionListener(this);
 		 itemFecharCaixa.addActionListener(this);
 		 itemConsultarNotaFiscal.addActionListener(this);
 		 itemIncluirCardapio.addActionListener(this);
 		itemConsultarEditarCardapio.addActionListener(this);
         itemIngles.addActionListener(this);
         itemEspanhol.addActionListener(this);
         itemPortugues.addActionListener(this);        
         
         icon = new ImageIcon("imageLoginView1.png");
         this.setIconImage(icon.getImage());
         
         //Setando Frame
         this.setVisible(true);
         this.setSize(500, 400);
         this.setResizable(true);
         this.setLocationRelativeTo(null);
         this.setJMenuBar(barMenuPrincipal);
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
   }

	@Override
	public void actionPerformed(ActionEvent event) {  
		
        //Item - Card�pio - Incluir Card�pio
        if(event.getSource() == itemIncluirCardapio){                    	
        	 cardapio = new CardapioView(bn);
      		 cardapio.incluirCardapioView();
        }
        
        //Item - Card�pio - Editar Card�pio
        if(event.getSource() == itemConsultarEditarCardapio){                    	
        	 cardapio = new CardapioView(bn);
      		 cardapio.editarCardapioView(0);
        }        
        
	}
	
	//atualizar idioma do menu principal
	public void refreshIdiom(){
		menuIdioma.setText(bn.getString("menuIdioma"));
		menuUsuario.setText(bn.getString("menuUsuario"));
		menuPedido.setText(bn.getString("menuPedido"));
		menuCaixa.setText(bn.getString("menuCaixa"));
		menuConta.setText(bn.getString("menuConta"));
		menuNotaFiscal.setText(bn.getString("menuNotaFiscal"));					
		menuCardapio.setText(bn.getString("menuCardapio"));
		menuPagamento.setText(bn.getString("menuPagamento"));
		menuCozinha.setText(bn.getString("menuCozinha"));

		itemIngles.setText(bn.getString("itemIngles"));
		itemPortugues.setText(bn.getString("itemPortugues"));
		itemEspanhol.setText(bn.getString("itemEspanhol"));
		itemCadastrarUsuario.setText(bn.getString("itemCadastrarUsuario"));
		itemConsultarEditarUsuario.setText(bn.getString("itemConsultarEditarUsuario"));
		itemFinalizarPrato.setText(bn.getString("itemFinalizarPrato"));
		itemListarPratosMaisVendidos.setText(bn.getString("itemListarPratosMaisVendidos"));	
		itemFecharNotaFiscal.setText(bn.getString("itemFecharNotaFiscal"));
		itemFecharConta.setText(bn.getString("itemFecharConta"));
		itemSair.setText(bn.getString("itemSair"));
		itemEmitirNotaFiscal.setText(bn.getString("itemEmitirNotaFiscal"));
		itemListarPratosMaisVendidos.setText(bn.getString("itemListarPratosMaisVendidos"));
		itemPriorizarPedido.setText(bn.getString("itemPriorizarPedido"));
		itemConsultarHorarioDePico.setText(bn.getString("itemConsultarHorarioDePico"));
		itemIncluirPedido.setText(bn.getString("itemIncluirPedido"));
		itemEditarPedido.setText(bn.getString("itemEditarPedido"));
		itemFecharCaixa.setText(bn.getString("itemFecharCaixa"));
		itemConsultarNotaFiscal.setText(bn.getString("itemConsultarNotaFiscal"));
		itemIncluirCardapio.setText(bn.getString("itemIncluirCardapio"));
		itemConsultarEditarCardapio.setText(bn.getString("itemConsultarEditarCardapio"));		
	
		lblNomeRestaurante.setText(bn.getString("tituloRestaurante"));
	}
	public static void main(String args[]){
	ResourceBundle	bn = ResourceBundle.getBundle("inter", new Locale("pt", "BR"));
	RestauranteView teste = new RestauranteView(bn);
	
	
	
	
	}
}