package model;

import java.io.Serializable;
import java.util.List;

import dao.CardapioDAO;
import to.CardapioTo;

public class Cardapio implements Serializable {	

	private String nomeProduto, descricaoProduto;
	private int idProduto, tipoProduto;
	private double valorUnitarioProduto;
	private boolean disponibilidadeProduto;
	private CardapioDAO dao;
	private CardapioTo to;
    private static final long serialVersionUID = 1L;
	
	public Cardapio() {
		
	}	

	public Cardapio(int idProduto, String nomeProduto, String descricaoProduto, double valorUnitarioProduto, 
			boolean disponibilidadeProduto, int tipoProduto) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.valorUnitarioProduto = valorUnitarioProduto;		
		this.disponibilidadeProduto = disponibilidadeProduto;
		this.tipoProduto = tipoProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public int getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(int tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public double getValorUnitarioProduto() {
		return valorUnitarioProduto;
	}
	public void setValorUnitarioProduto(double valorUnitarioProduto) {
		this.valorUnitarioProduto = valorUnitarioProduto;
	}
	public boolean isDisponibilidadeProduto() {
		return disponibilidadeProduto;
	}
	public void setDisponibilidadeProduto(boolean disponibilidadeProduto) {
		this.disponibilidadeProduto = disponibilidadeProduto;
	}
	
	//CADASTRAR
	public boolean cadastrarCardapio(){
		dao = new CardapioDAO();	
		to = new CardapioTo();
		to.setIdProduto(idProduto);
		to.setNomeProduto(nomeProduto);
		to.setDescricaoProduto(descricaoProduto);
		to.setValorUnitarioProduto(valorUnitarioProduto);
		to.setDisponibilidadeProduto(disponibilidadeProduto);
		to.setTipoProduto(tipoProduto);
        return dao.cadastrar(to);	
	}	
	
	//CONSULTAR COM ID TABLE
	public List<Cardapio> consultarCardapio(int idProduto) {
		dao = new CardapioDAO();
		return dao.consultar(idProduto);
	}
	
	//CONSULTAR COM NOME TABLE
	public List<Cardapio> consultarCardapio(String nome) {
		dao = new CardapioDAO();		
		return dao.consultar(nome);
	}
	
	//CONSULTAR TODOS TABLE
	public List<Cardapio> consultarCardapio() {
		dao = new CardapioDAO();		        
        for(Cardapio cardapio : dao.consultar()) {
			  System.out.println(cardapio.getNomeProduto());
		}
        return dao.consultar();
	}
	
	//EXCLUIR
	public boolean excluirUsuario(int idProduto){
		dao = new CardapioDAO();			  
		to  = new CardapioTo();
		to.setIdProduto(idProduto);
        return dao.excluir(to);	
	}
	
	//ALTERAR
	public boolean alterarCardapio(int idProduto){
		dao = new CardapioDAO();			  
		to  = new CardapioTo();
		to.setIdProduto(getIdProduto());
		to.setNomeProduto(getNomeProduto());
		to.setDescricaoProduto(getDescricaoProduto());
		to.setValorUnitarioProduto(getValorUnitarioProduto());
		to.setDisponibilidadeProduto(isDisponibilidadeProduto());		
		to.setTipoProduto(getTipoProduto());
        return dao.alterar(to);	
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoProduto == null) ? 0 : descricaoProduto.hashCode());
		result = prime * result + (disponibilidadeProduto ? 1231 : 1237);
		result = prime * result + idProduto;
		result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
		result = prime * result + tipoProduto;
		long temp;
		temp = Double.doubleToLongBits(valorUnitarioProduto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cardapio other = (Cardapio) obj;
		if (descricaoProduto == null) {
			if (other.descricaoProduto != null)
				return false;
		} else if (!descricaoProduto.equals(other.descricaoProduto))
			return false;
		if (disponibilidadeProduto != other.disponibilidadeProduto)
			return false;
		if (idProduto != other.idProduto)
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		if (tipoProduto != other.tipoProduto)
			return false;
		if (Double.doubleToLongBits(valorUnitarioProduto) != Double.doubleToLongBits(other.valorUnitarioProduto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cardapio [idProduto=" + idProduto + ", nomeProduto=" + nomeProduto + ", descricaoProduto="
				+ descricaoProduto + ", valorUnitarioProduto=" + valorUnitarioProduto + ", disponibilidadeProduto="
				+ disponibilidadeProduto + ", tipoProduto=" + tipoProduto + "]";
	}

	

}
