package br.com.weyde.pages;

import br.com.weyde.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");

	}
	
	public void acessarTelaListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");

	}
	
	public void acessarTelaInserirMovimentacaoS() {
		clicarLink("Criar Movimentação");
	}
	
	public void acessarTelaResumo() {
		clicarLink("Resumo Mensal");
	}
}
