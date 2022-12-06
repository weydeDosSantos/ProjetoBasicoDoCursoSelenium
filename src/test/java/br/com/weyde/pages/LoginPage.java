package br.com.weyde.pages;

import static br.com.weyde.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.weyde.core.BasePage;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() {
		getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	public void email(String email) {
		escreve("email", email);
	}
	
	public void senha(String senha) {
		escreve("senha", senha);
	}
	
	public void entrar() {
		clicarBotaoPorTexto("Entrar");
	}
}
