package br.com.weyde.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.weyde.core.BaseTest;
import br.com.weyde.core.Propriedades;
import br.com.weyde.pages.ContasPage;
import br.com.weyde.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();

	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirContas(Propriedades.NOME_CONTA_ALTERADA);
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());

	}
}
