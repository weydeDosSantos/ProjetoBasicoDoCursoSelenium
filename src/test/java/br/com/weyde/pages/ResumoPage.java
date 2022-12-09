package br.com.weyde.pages;

import org.openqa.selenium.By;

import br.com.weyde.core.BasePage;

public class ResumoPage extends BasePage {

	public void excluirMovimentacao() {
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']")) ;
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
}
