package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Cardapio;
import model.CardapioTableModel;

public class CardapioView extends JFrame implements ActionListener{
	private JLabel			   
      lblPrato, lblBebida, lblSobremesa, lblNumProduto, lblNomeProduto, lblDescProduto, 
      lblVProduto, lblTProduto;
	private JTextField		txtNumProduto, txtNomeProduto, txtDispProduto, txtVProduto, txtDescProduto;
	private JButton			
      btnConsultar, btnCadastrar, btnAlterar, btnExcluir, btnCancelar;
	private JComboBox       cmbTProduto;
	private JRadioButton	rAtivo, rInativo;
	private JTable          tableProduto;
	private CardapioTableModel tableModel;
	private JScrollPane     scroll;
	private JPanel 			
      pnlNorte, pnlCentro, pnlSul, pnlTabPrato, pnlTabBebida, pnlTabSobremesa;
	private JFrame			janela;
	private JTabbedPane 	tabbedCardapio;
	private ResourceBundle	bn=null;
	private Cardapio cardapio;
	
	public CardapioView(ResourceBundle bundle){
		super();		
		
		bn = bundle; 
		
		lblNumProduto   = new JLabel(bn.getString("labelNumProduto"));
		lblNomeProduto  = new JLabel(bn.getString("labelNomeProduto"));
		lblDescProduto  = new JLabel(bn.getString("labelDescProduto"));
		lblVProduto = new JLabel(bn.getString("labelValorProduto"));  
		lblTProduto  = new JLabel(bn.getString("labelTipoProduto"));	
		
		tableProduto = new JTable();
	}
	
	//CONSULTAR/EDITAR CARDAPIO
	public void editarCardapioView(int idProduto){
		//Layouts
		janela = new JFrame(bn.getString("tituloEditarCardapioView"));
		janela.setLayout(new BorderLayout(10,10));
      
		//North
		pnlNorte = new JPanel();
		pnlNorte.setLayout(new GridLayout(2, 2, 10, 10));      
      
		txtNumProduto    = new JTextField(10);
		txtNomeProduto   = new JTextField(10);
      
		pnlNorte.add(lblNumProduto);
		pnlNorte.add(txtNumProduto);
		pnlNorte.add(lblNomeProduto);
		pnlNorte.add(txtNomeProduto);
      
		janela.add(pnlNorte, BorderLayout.NORTH);	
		
		//Center
		pnlCentro = new JPanel();
		pnlCentro.setLayout(new GridLayout(1, 3, 10, 10));     
            
		btnConsultar   = new JButton(bn.getString("buttonConsultar"));
		btnAlterar     = new JButton(bn.getString("buttonAlterar"));
		btnExcluir     = new JButton(bn.getString("buttonExcluir"));
      
		pnlCentro.add(btnConsultar);
		pnlCentro.add(btnAlterar);
		pnlCentro.add(btnExcluir);
      
		janela.add(pnlCentro, BorderLayout.CENTER);	
      
		//South
		pnlSul = new JPanel();
		pnlSul.setLayout(new FlowLayout());
            
		carregarTable(idProduto); 
      
		janela.add(pnlSul, BorderLayout.SOUTH);	
		
		btnConsultar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnExcluir.addActionListener(this);
      		
		//Definicoes
		janela.setVisible(true);
		janela.setResizable(false);		
		janela.setSize(480,562);
		janela.setLocationRelativeTo(null);
	}
	
	public void carregarTable(int idProduto){
   		pnlSul.add(carregarScroll(idProduto));
	}	
	
	public void carregarTable(String nomeProduto){
   		pnlSul.add(carregarScroll(nomeProduto));
	}	
	
	//CONSULTA COM ID OU NOME
	//SE 0 - RETORNA TODOS OS DADOS DA TABELA cardapio
	private JScrollPane carregarScroll(int idProduto){
    	if(idProduto == 0) {
    		scroll = new JScrollPane(getTblProdutos());
    		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);	
    		return scroll;    		
    	} else {
    		scroll = new JScrollPane(getTblProdutos(idProduto));
    		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);	
    		return scroll;    		
    	}		
	}	
	
	private JScrollPane carregarScroll(String nomeProduto){    	
		scroll = new JScrollPane(getTblProdutos(nomeProduto));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);	
		return scroll;    		    		
	}
	
	private JTable getTblProdutos() {   
    	tableProduto.setModel(getTableModel());       
        return tableProduto;
    }
	
	private JTable getTblProdutos(int idProduto) {		
		tableProduto.setModel(getTableModel(idProduto));        
        return tableProduto;
    }
	
	private JTable getTblProdutos(String nomeProduto) {		
		tableProduto.setModel(getTableModel(nomeProduto));        
        return tableProduto;
    }
 
    private CardapioTableModel getTableModel() {
    	cardapio = new Cardapio();    	
        tableModel = new CardapioTableModel(cardapio.consultarCardapio(), bn); 
        /*for(Cardapio ca : cardapio.consultarCardapio()) {
			  System.out.println(ca.getIdProduto() + " " + ca.getNomeProduto() + " " + ca.getDescricaoProduto() + " " + ca.getValorUnitarioProduto() + " " + ca.isDisponibilidadeProduto() + " " + ca.getTipoProduto());
		 }*/
        return tableModel;
    }
        
    private CardapioTableModel getTableModel(int idProduto) {
    	cardapio = new Cardapio();    	
        tableModel = new CardapioTableModel(cardapio.consultarCardapio(idProduto), bn);        
        return tableModel;
    }
	
    private CardapioTableModel getTableModel(String nomeProduto) {
    	cardapio = new Cardapio();    	
        tableModel = new CardapioTableModel(cardapio.consultarCardapio(nomeProduto), bn);        
        return tableModel;
    }
   
	//INCLUIR CARDAPIO
	public void incluirCardapioView(){
		//Layouts
		janela = new JFrame(bn.getString("tituloincluirCardapioView"));
		janela.setLayout(new BorderLayout(10,10));
      
		//North
		pnlNorte = new JPanel();
		pnlNorte.setLayout(new GridLayout( 2, 6, 10, 10));      
      
		lblNumProduto = new JLabel(bn.getString("labelNumProduto"));
		
		txtNomeProduto   	= new JTextField(10);
		txtDescProduto    	= new JTextField(10);
		txtVProduto    = new JTextField(10);
		txtDispProduto    	= new JTextField(10);
		txtNumProduto		= new JTextField(10);
		
		rAtivo 		= new JRadioButton("Ativo", true);
		rInativo 	= new JRadioButton("Inativo", false);
		
		cmbTProduto = new JComboBox();
		cmbTProduto.setBackground(Color.WHITE);
		cmbTProduto.addItem("----");
		cmbTProduto.addItem(bn.getString("comboPrato"));
		cmbTProduto.addItem(bn.getString("comboSobremesa"));
		cmbTProduto.addItem(bn.getString("comboBebida"));  
      
		rAtivo.addActionListener(this);
      	rInativo.addActionListener(this);
		
      	pnlNorte.add(lblNumProduto);
		pnlNorte.add(txtNumProduto);
		pnlNorte.add(lblNomeProduto);
		pnlNorte.add(txtNomeProduto);
		pnlNorte.add(lblVProduto);
		pnlNorte.add(txtVProduto);
		pnlNorte.add(lblDescProduto);
		pnlNorte.add(txtDescProduto); //<--- COLOCAR JTEXTAREA
      	pnlNorte.add(lblTProduto);
      	pnlNorte.add(cmbTProduto);
      	pnlNorte.add(rAtivo);
      	pnlNorte.add(rInativo);
      	
      	      	
      
		janela.add(pnlNorte, BorderLayout.NORTH);	
		
		//Center
		pnlCentro = new JPanel();
		pnlCentro.setLayout(new GridLayout(1, 2, 5, 10)); 
		
		btnCadastrar   = new JButton(bn.getString("buttonCadastrar"));
		btnCancelar    = new JButton(bn.getString("buttonCancelar"));
      
      	pnlCentro.add(btnCadastrar);
      	pnlCentro.add(btnCancelar);
      	
      	btnCadastrar.addActionListener(this);
      	btnCancelar.addActionListener(this);
      
		janela.add(pnlCentro, BorderLayout.CENTER);	     	
      		
		//Definicoes
		janela.setVisible(true);
		janela.setResizable(false);		
		janela.setSize(800,150);	
		janela.setLocationRelativeTo(null);
	}

	//CARDAPIO
	public void vizualizarCardapioView(){
		//Layouts
		janela = new JFrame(bn.getString("tituloVisualizarCardapioView"));
		janela.setLayout(new BorderLayout(10,10));
		
		
		//North
		pnlNorte = new JPanel();
		pnlNorte.setLayout(new FlowLayout(FlowLayout.LEFT));	
		
		pnlTabPrato		= new JPanel();
		pnlTabBebida		= new JPanel();
		pnlTabSobremesa	= new JPanel();
		pnlTabPrato.setPreferredSize(new Dimension(300, 250));
		
		
		lblPrato = new JLabel("nomePrato | descrição | disponibilidade");		
		pnlTabPrato.add(lblPrato);
		
		lblBebida = new JLabel("nomeBebida | descrição | disponibilidade");
		pnlTabBebida.add(lblBebida);
		
		lblSobremesa = new JLabel("nomeSobremesa | descrição | disponibilidade");
		pnlTabSobremesa.add(lblSobremesa);
		
		
		tabbedCardapio = new JTabbedPane();
		
		tabbedCardapio.addTab("Prato",  	pnlTabPrato);
		tabbedCardapio.addTab("Bebida",		pnlTabBebida);
		tabbedCardapio.addTab("Sobremesa", 	pnlTabSobremesa);
		
		
		pnlNorte.add(tabbedCardapio);
		janela.add(pnlNorte, BorderLayout.NORTH);	
			
		janela.setVisible(true);
		janela.setResizable(false);		
		janela.setSize(300,200);	
		janela.setLocationRelativeTo(null);		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//RADIOBUTTON
		if(event.getSource() == rAtivo){ 
			rInativo.setSelected(false);
		}
		if(event.getSource() == rInativo){ 
			rAtivo.setSelected(false);
		}
		//BUTTON CADASTRAR
        if(event.getSource() == btnCadastrar){
        	if(	(txtNomeProduto == null)  || (txtDescProduto == null) || 
        		(txtVProduto == null) || (txtDispProduto == null) || 
        		(txtNumProduto == null) || (cmbTProduto.getSelectedIndex() == 0) ) {        		
        		JOptionPane.showMessageDialog(null, bn.getString("mensagemCadastroCampoBranco"));        		
        	} else {       	
	        		    		  
        		cardapio = new Cardapio();
        		
        		try {
        			cardapio.setIdProduto(Integer.parseInt(txtNumProduto.getText()));
        		}
        		catch(NumberFormatException e) {
	        		JOptionPane.showMessageDialog(null, bn.getString("mensagemIdInvalido"));	  
	        		return;
	        	}
        		
        		try {
	        		cardapio.setValorUnitarioProduto(Double.parseDouble(txtVProduto.getText() ));
        		}
        		catch(NumberFormatException e) {
	        		JOptionPane.showMessageDialog(null, bn.getString("mensagemValorInvalido"));	  
	        		return;
	        	}	        		
        		
        		cardapio.setNomeProduto	(txtNomeProduto.getText());
        		cardapio.setDescricaoProduto(txtDescProduto.getText());        		
        		cardapio.setTipoProduto	(cmbTProduto.getSelectedIndex());
        		
        		if(rAtivo.isSelected()){        				
        			cardapio.setDisponibilidadeProduto(true);
				}else if(rInativo.isSelected()){			
					cardapio.setDisponibilidadeProduto(false);
				}
        		
        		if(cardapio.cadastrarCardapio()) {
        			JOptionPane.showMessageDialog(null, bn.getString("mensagemCadastroSucesso"));
        			txtNumProduto.setText(null);
        			txtNomeProduto.setText(null);
        			txtDescProduto.setText(null);
        			txtVProduto.setText(null);
        			txtDispProduto.setText(null);
	        		cmbTProduto.setSelectedIndex(0);        			
        		}	    	  		        		
        	}
        }  
        //BUTTON CANCELAR
        if(event.getSource() == btnCancelar){
        	this.dispose();
        	janela.setDefaultCloseOperation( EXIT_ON_CLOSE );
        } 
        
        //BUTTON - CONSULTAR
        if(event.getSource() == btnConsultar){
        	cardapio = new Cardapio();
        	
			String nomeUsuario = txtNomeProduto.getText();
			int idUsuario = 0;			
			
			if(!(nomeUsuario.equals(""))){	
				try {					
					pnlSul.removeAll();
					carregarTable(nomeUsuario);
					if(tableModel.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, bn.getString("mensagemConsultaVazia"));	
					} else {
		    			//.validate() = método para atualizar as informações
		    			pnlSul.validate();
		    			JOptionPane.showMessageDialog(null, bn.getString("mensagemConsultaSucesso"));	
					}	    			
	        	}
	        	catch(NumberFormatException e) {
	        		JOptionPane.showMessageDialog(null, bn.getString("mensagemConsultaVazia"));	    		  
	        	} 
				
			} else if(nomeUsuario.equals("")) {
				try {	    		    
	    			idUsuario = Integer.parseInt(txtNumProduto.getText());   			
	        	}
	        	catch(NumberFormatException e) {
	        		
	        	}				
				if (idUsuario != 0) {
					try {	    		    		    				    			
						pnlSul.removeAll();
						carregarTable(idUsuario);
						if(tableModel.getRowCount() == 0) {
							JOptionPane.showMessageDialog(null, bn.getString("mensagemConsultaVazia"));	
						} else {
			    			//.validate() = método para atualizar as informações
			    			pnlSul.validate();
			    			JOptionPane.showMessageDialog(null, bn.getString("mensagemConsultaSucesso"));	
						}
		    			
		        	}
		        	catch(NumberFormatException e) {
		        		JOptionPane.showMessageDialog(null, bn.getString("mensagemSomenteNumero"));	    		  
		        	} 					
				} else {					
					JOptionPane.showMessageDialog(null, bn.getString("mensagemConsultaVazia"));	 
				}					
			}
        }
        
        //BUTTON - ALTERAR
        if(event.getSource() == btnAlterar){
        	cardapio = new Cardapio();  
    		try {	    
    			int linhaSelecionada = tableProduto.getSelectedRow();
    			tableProduto.getSelectedColumn();
            	cardapio = tableModel.getCardapio(linhaSelecionada);  				
            	cardapio.alterarCardapio(cardapio.getIdProduto());
            	pnlSul.removeAll();
    			carregarTable(cardapio.getIdProduto());
            	
    			pnlSul.validate();
            	JOptionPane.showMessageDialog(null, bn.getString("mensagemAlterarSucesso"));
        	}
        	catch(NumberFormatException e) {
        		JOptionPane.showMessageDialog(null, bn.getString("mensagemSomenteNumero"));	    		  
        	}            	
        }
        
        //BUTTON - EXCLUIR
        if(event.getSource() == btnExcluir){
        	cardapio = new Cardapio();  
    		try {	    
    			int linhaSelecionada = tableProduto.getSelectedRow();        	
    			cardapio = tableModel.getCardapio(linhaSelecionada);
    			cardapio.excluirUsuario(cardapio.getIdProduto());
            	tableModel.removeCardapio(linhaSelecionada);        
            	pnlSul.validate();
            	JOptionPane.showMessageDialog(null, bn.getString("mensagemExcluirSucesso"));
        	}
        	catch(NumberFormatException e) {
        		JOptionPane.showMessageDialog(null, bn.getString("mensagemSomenteNumero"));	    		  
        	}      	
        }
		
	}
}

