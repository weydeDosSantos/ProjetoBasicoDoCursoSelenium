package br.com.weyde.tests;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.weyde.core.BaseTest;
import br.com.weyde.pages.MenuPage;
import br.com.weyde.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();

	@Test
	public void testInserirMovimentacao() {

		menuPage.acessarTelaInserirMovimentacaoS();
		movPage.dataMovimentacao("05/12/2022");
		movPage.dataPagamento("06/12/2022");
		movPage.descricao("Movimentação do teste");
		movPage.interessado("06/12/2022");
		movPage.valor("500");
		movPage.conta("Conta para teste alterada2");
		movPage.pago();
		movPage.Salvar();

		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());

	}

	@Test
	public void testCamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacaoS();

		movPage.Salvar();
		List<String> erros = movPage.obterErros();
		// Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
		// OPÇÃO 1
		// Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
		// OPÇÃO 2
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório", "Descrição é obrigatório", "Interessado é obrigatório",
				"Valor é obrigatório", "Valor deve ser um número")));

	}
	
	

}
