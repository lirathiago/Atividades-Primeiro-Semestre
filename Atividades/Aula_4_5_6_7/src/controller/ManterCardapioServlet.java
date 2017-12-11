package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cardapio;

@WebServlet("/ManterCardapio.do")
public class ManterCardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProduto = Integer.parseInt(request.getParameter("id"));
		String nomeProduto = request.getParameter("nome");
		String descricaoProduto = request.getParameter("descricao");
		Double valorProduto = Double.parseDouble(request.getParameter("valor"));	
		boolean disponibilidadeProduto	 = Boolean.parseBoolean(request.getParameter("dispo"));
		int tipoProduto = Integer.parseInt(request.getParameter("tipo"));
		
		Cardapio cardapio = new Cardapio();
		cardapio.setIdProduto(idProduto);
		cardapio.setNomeProduto(nomeProduto);
		cardapio.setDescricaoProduto(descricaoProduto);
		cardapio.setValorUnitarioProduto(valorProduto);
		cardapio.setDisponibilidadeProduto(disponibilidadeProduto);
		cardapio.setTipoProduto(tipoProduto);
		
	
		if(cardapio.cadastrarCardapio()) {
			System.out.println("Cadastrou com sucesso");
		}
		/*ClienteService service= new ClienteService();
		int id = service.criar(cliente);
		cliente = service.carregar(id);*/
		
		request.setAttribute("cardapio", cardapio);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Cardapio.jsp");
		
		dispatcher.forward(request, response);
		
		
		
		
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente</title></head>");
		out.println("<body><h3>");
		out.println("Nome:"+cliente.getNome()+"<br>");
		out.println("Id:"+cliente.getId()+"<br>");
		out.println("Fone:"+cliente.getFone()+"<br>");
		out.println("Email:"+cliente.getEmail()+"<br>");
		out.println("</h3></body></html>");*/
	
		
	}

}
