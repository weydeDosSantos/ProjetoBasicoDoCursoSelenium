package br.com.weyde.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.weyde.core.BaseTest;
import br.com.weyde.pages.MenuPage;
import br.com.weyde.pages.ResumoPage;

public class ResumoTests extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void testExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		resumoPage.excluirMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	
	}
	
}
