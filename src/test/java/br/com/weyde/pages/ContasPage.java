package br.com.weyde.pages;

import org.openqa.selenium.By;

import br.com.weyde.core.BasePage;

public class ContasPage extends BasePage {

	public void nome(String nome) {

		escreve("nome", nome);
	}

	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}

	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}

	public String obterMensagemErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}

	public void clicarAlterarContas(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
				.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
}
