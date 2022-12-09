package br.com.weyde.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.weyde.core.BaseTest;
import br.com.weyde.core.DriverFactory;
import br.com.weyde.pages.ContasPage;
import br.com.weyde.pages.MenuPage;

public class ContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.nome("Conta para teste");
		contasPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}

	@Test
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarAlterarContas("Conta para testeConta para teste alteradaConta para teste alterada2");
		contasPage.nome("Conta para teste alterada2");
		contasPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());

	}

	@Test
	public void inserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.nome("Conta para teste alterada2");
		contasPage.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());

	}
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirContas("sada 2");
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());

	}
}
