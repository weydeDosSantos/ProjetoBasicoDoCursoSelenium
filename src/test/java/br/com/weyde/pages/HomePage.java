package br.com.weyde.pages;

import br.com.weyde.core.BasePage;

public class HomePage extends BasePage {

	public String obterSaldoConta(String nome) {
		return	obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}
}