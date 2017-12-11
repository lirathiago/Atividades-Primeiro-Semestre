package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cardapio;
import to.CardapioTo;

public class CardapioDAO {
	private String nomeProd, descProd;
	private int tipoProd;
	private int idProd;
	private double valorUProd;
	private boolean disponibilidadeProd;
	
	public CardapioDAO() {
		
	}
	public CardapioDAO(int idProd, String nomeProd, String descProd, double valorUProd,
			boolean disponibilidadeProd, int tipoProd) {
		this.idProd = idProd;
		this.nomeProd = nomeProd;
		this.descProd = descProd;
		this.valorUProd = valorUProd;
		this.disponibilidadeProd = disponibilidadeProd;
		this.tipoProd = tipoProd;
	}
	
	public String getNomeProduto() {
		return nomeProd;
	}
	public void setNomeProduto(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	public String getDescricaoProduto() {
		return descProd;
	}
	public void setDescricaoProduto(String descProd) {
		this.descProd = descProd;
	}
	public int getTipoProduto() {
		return tipoProd;
	}
	public void setTipoProduto(int tipoProd) {
		this.tipoProd = tipoProd;
	}
	public int getIdProduto() {
		return idProd;
	}
	public void setIdProduto(int idProd) {
		this.idProd = idProd;
	}
	public double getValorUnitarioProduto() {
		return valorUProd;
	}
	public void setValorUnitarioProduto(double valorUProd) {
		this.valorUProd = valorUProd;
	}
	public boolean isDisponibilidadeProduto() {
		return disponibilidadeProd;
	}
	public void setDisponibilidadeProduto(boolean disponibilidadeProd) {
		this.disponibilidadeProd = disponibilidadeProd;
	}
	
	//********************MANTER CARDAPIO*********************************//
	//CADASTRAR
	public boolean cadastrar(CardapioTo to) {
		
		String sqlInsert = 
				"INSERT INTO CARDAPIO(idProduto, nomeProduto, descricaoProduto, valorUnitarioProduto, disponibilidadeProduto, tipoProduto) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement stm = null;
		Connection conn = null;
		        
		try {			
			// obtem conexao com o banco			
			ConnectionFactory bd = new ConnectionFactory();
			conn = bd.obtemConexao();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt		(1, to.getIdProduto());
			stm.setString	(2, to.getNomeProduto());
			stm.setString	(3, to.getDescricaoProduto());
			stm.setDouble	(4, to.getValorUnitarioProduto());
			stm.setBoolean	(5, to.isDisponibilidadeProduto());
			stm.setInt		(6, to.getTipoProduto());
						
			stm.execute();
			conn.commit();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}
			catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		}
		finally {
			if (stm != null) {
				try {
					stm.close();
				}
				catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return false;
	}
	
	//EXCLUIR
	public boolean excluir(CardapioTo to) {
		String sqlDelete = "DELETE FROM Cardapio WHERE idProduto = " + to.getIdProduto();
		PreparedStatement stm = null;
		Connection conn = null;
		
		try {
			// obtem conexao com o banco			
			ConnectionFactory bd = new ConnectionFactory();
			conn = bd.obtemConexao();
			// *** IMPORTANTE ***: Força o uso de transação.
			conn.setAutoCommit(false);
			
			stm = conn.prepareStatement(sqlDelete);
			stm.execute();
			conn.commit();
			return true;
		}
			catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		finally {
			if (stm != null) {
				try {
					stm.close();
			  }
				catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}		
		return false;
	}
	
	//ALTERAR
	public boolean alterar(CardapioTo to) {		
		String sqlAlter = "UPDATE CARDAPIO SET "
						+ "nomeProduto = ?, descricaoProduto = ?, valorUnitarioProduto = ?, disponibilidadeProduto = ?, tipoProduto = ? WHERE idProduto = " + to.getIdProduto();
		PreparedStatement stm = null;
		Connection conn = null;
		
		try {
			// obtem conexao com o banco			
			ConnectionFactory bd = new ConnectionFactory();
			conn = bd.obtemConexao();
			// *** IMPORTANTE ***: Força o uso de transação.
			conn.setAutoCommit(false);						
			stm = conn.prepareStatement(sqlAlter);
			stm.setString (1, to.getNomeProduto());
			stm.setString (2, to.getDescricaoProduto());
			stm.setDouble (3, to.getValorUnitarioProduto());
			stm.setBoolean(4, to.isDisponibilidadeProduto());
			stm.setInt	  (5, to.getTipoProduto());
			stm.execute();
			conn.commit();
			return true;
		}
			catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		finally {
			if (stm != null) {
				try {
					stm.close();
			  }
				catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return false;
	}
	
	//CONSULTAR COM CÓDIGO
	public List<Cardapio> consultar(int idProduto) {		
		List<Cardapio> produtos = new ArrayList<Cardapio>();
		String sqlSelect = "SELECT * FROM CARDAPIO WHERE idProduto = " + idProduto;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			// obtem conexao com o banco			
			ConnectionFactory bd = new ConnectionFactory();
			conn = bd.obtemConexao();
			conn.setAutoCommit(false);
			Cardapio cardapio = new Cardapio();
						
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery(sqlSelect); 		     
			    
			 while(rs.next()) {  
				 //cardapio = new Cardapio();
				 cardapio.setIdProduto(rs.getInt("idProduto"));
				 cardapio.setNomeProduto(rs.getString("nomeProduto"));
				 cardapio.setDescricaoProduto(rs.getString("descricaoProduto"));
				 cardapio.setValorUnitarioProduto(rs.getInt("valorUnitarioProduto"));
				 cardapio.setDisponibilidadeProduto(rs.getBoolean("disponibilidadeProduto"));
				 cardapio.setTipoProduto(rs.getInt("tipoProduto"));
				 setIdProduto(rs.getInt("idProduto"));
				 setNomeProduto(rs.getString("nomeProduto"));
				 setDescricaoProduto(rs.getString("descricaoProduto"));
				 setValorUnitarioProduto(rs.getInt("valorUnitarioProduto"));
				 setDisponibilidadeProduto(rs.getBoolean("disponibilidadeProduto"));
				 setTipoProduto(rs.getInt("tipoProduto"));
				 produtos.add(cardapio);				 	   
			 } 
			 rs.close();
			 conn.commit();
			 return produtos;
		}
			catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		finally {
			if (stm != null) {
				try {
					stm.close();
			  }
				catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return produtos;
	}
	
	
	//CONSULTAR COM NOME
	public List<Cardapio> consultar(String nomeProduto) {		
		List<Cardapio> produtos = new ArrayList<Cardapio>();
		String sqlSelect = "SELECT * FROM CARDAPIO WHERE nomeProduto = '" + nomeProduto + "'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			// obtem conexao com o banco			
			ConnectionFactory bd = new ConnectionFactory();
			conn = bd.obtemConexao();
			conn.setAutoCommit(false);
						
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery(sqlSelect); 		     
			    
			while(rs.next()) {  
				 Cardapio cardapio = new Cardapio();
				 cardapio.setIdProduto(rs.getInt("idProduto"));
				 cardapio.setNomeProduto(rs.getString("nomeProduto"));
				 cardapio.setDescricaoProduto(rs.getString("descricaoProduto"));
				 cardapio.setValorUnitarioProduto(rs.getInt("valorUnitarioProduto"));
				 cardapio.setDisponibilidadeProduto(rs.getBoolean("disponibilidadeProduto"));
				 cardapio.setTipoProduto(rs.getInt("tipoProduto"));
				 produtos.add(cardapio);				 	   
			 } 
			 rs.close();
			 conn.commit();
			 return produtos;
		}
			catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		finally {
			if (stm != null) {
				try {
					stm.close();
			  }
				catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return produtos;
	}
	
	//CONSULTAR TODOS
	public List<Cardapio> consultar() {		
		List<Cardapio> produtos = new ArrayList<Cardapio>();

		String sqlSelect = "SELECT * FROM CARDAPIO";
		PreparedStatement stm = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			// obtem conexao com o banco			
			ConnectionFactory bd = new ConnectionFactory();
			conn = bd.obtemConexao();
			conn.setAutoCommit(false);
						
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery(sqlSelect); 		     
			    
			while(rs.next()) {  
				 Cardapio cardapio = new Cardapio();
				 cardapio.setIdProduto(rs.getInt("idProduto"));
				 cardapio.setNomeProduto(rs.getString("nomeProduto"));
				 cardapio.setDescricaoProduto(rs.getString("descricaoProduto"));
				 cardapio.setValorUnitarioProduto(rs.getDouble("valorUnitarioProduto"));
				 cardapio.setDisponibilidadeProduto(rs.getBoolean("disponibilidadeProduto"));
				 cardapio.setTipoProduto(rs.getInt("tipoProduto"));
				 
				 produtos.add(cardapio);				 	   
			 } 
			 rs.close();
			 conn.commit();
			 
			 return produtos;
		}
			catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
				}
				catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		finally {
			if (stm != null) {
				try {
					stm.close();
			  }
				catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return produtos;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descProd == null) ? 0 : descProd.hashCode());
		result = prime * result + (disponibilidadeProd ? 1231 : 1237);
		result = prime * result + idProd;
		result = prime * result + ((nomeProd == null) ? 0 : nomeProd.hashCode());
		result = prime * result + tipoProd;
		long temp;
		temp = Double.doubleToLongBits(valorUProd);
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
		CardapioDAO other = (CardapioDAO) obj;
		if (descProd == null) {
			if (other.descProd != null)
				return false;
		} else if (!descProd.equals(other.descProd))
			return false;
		if (disponibilidadeProd != other.disponibilidadeProd)
			return false;
		if (idProd != other.idProd)
			return false;
		if (nomeProd == null) {
			if (other.nomeProd != null)
				return false;
		} else if (!nomeProd.equals(other.nomeProd))
			return false;
		if (tipoProd != other.tipoProd)
			return false;
		if (Double.doubleToLongBits(valorUProd) != Double.doubleToLongBits(other.valorUProd))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CardapioDAO [idProduto=" + idProd + ", nomeProduto=" + nomeProd + ", descricaoProduto="
				+ descProd + ", valorUnitarioProduto=" + valorUProd + ", disponibilidadeProduto="
				+ disponibilidadeProd + ", tipoProduto=" + tipoProd + "]";
	}
}
