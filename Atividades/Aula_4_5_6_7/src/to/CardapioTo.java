package to;

import dao.CardapioDAO;

public class CardapioTo {
	private String nomeProduto, descricaoProduto;
	private int idProduto, tipoProduto;
	private double valorUnitarioProduto;
	private boolean disponibilidadeProduto;
	
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
	
}
