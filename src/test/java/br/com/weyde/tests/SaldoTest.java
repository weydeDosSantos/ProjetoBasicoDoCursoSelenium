package br.com.weyde.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.weyde.core.BaseTest;
import br.com.weyde.core.Propriedades;
import br.com.weyde.pages.HomePage;
import br.com.weyde.pages.MenuPage;

public class SaldoTest extends BaseTest {

	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void testSaldoConta() {
		menu.acessarTelaPrincipal();
		Assert.assertEquals("500.00",  page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}
}

