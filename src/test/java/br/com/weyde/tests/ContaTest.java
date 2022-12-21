package br.com.weyde.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.weyde.core.BaseTest;
import br.com.weyde.core.Propriedades;
import br.com.weyde.pages.ContasPage;
import br.com.weyde.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

	 MenuPage menuPage = new MenuPage();
	 ContasPage contasPage = new ContasPage();

	@Test
	public void test1_InserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.nome("Conta para teste");
		contasPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}

	@Test
	public void test2_AlterarConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarAlterarContas("Conta para teste");
		contasPage.nome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());

	}

	@Test
	public void test3_inserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.nome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());

	}
	
	
}
