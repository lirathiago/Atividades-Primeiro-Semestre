package test;

import static org.junit.Assert.assertEquals;

import model.Cardapio;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.CardapioDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CardapioTest {
	Cardapio cardapio, copia;
	static int id = 0;
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		cardapio = new Cardapio(id, "Salada", "Salada", 22.0, true, 1);
		copia 	 = new Cardapio(id, "Salada", "Salada", 22.0, true, 1);
		System.out.println(cardapio);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Cardapio fixture = new Cardapio(1, "Macarrão", "Macarronada com queijo", 22, true, 1);
		CardapioDAO novo = new CardapioDAO(1, null, null, 0, false, 0);
		novo.consultar(1);		
		System.out.println(fixture);
		System.out.println(novo);
		//assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		cardapio.cadastrarCardapio();
		id = cardapio.getIdProduto();
		System.out.println(id);
		copia.setIdProduto(id);
		assertEquals("testa criacao", cardapio, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		cardapio.setNomeProduto("Teste");
		copia.setNomeProduto("Teste");
		cardapio.alterarCardapio(1);
		cardapio.consultarCardapio(1);
		assertEquals("testa atualizacao", cardapio, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setIdProduto(-1);
		copia.setNomeProduto(null);
		copia.setDescricaoProduto(null);
		copia.setValorUnitarioProduto(0);
		copia.setDisponibilidadeProduto(false);
		copia.setTipoProduto(0);
		cardapio.excluirUsuario(1);
		cardapio.consultarCardapio(1);
		//assertEquals("testa exclusao", cardapio, copia);
	}

}
