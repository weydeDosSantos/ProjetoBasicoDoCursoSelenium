package br.com.weyde.pages;

import org.openqa.selenium.By;

import br.com.weyde.core.BasePage;

public class MovimentacaoPage extends BasePage {

	public void dataMovimentacao(String data) {
		escreve("data_transacao", data);
	}

	public void dataPagamento(String data) {
		escreve("data_pagamento", data);
	}

	public void descricao(String descricao) {
		escreve("descricao", descricao);
	}

	public void interessado(String interessado) {
		escreve("interessado", interessado);
	}
	
	public void valor(String valor) {
		escreve("valor", valor);
	}
	
	public void conta(String conta) {
		selecionarCombo("conta", conta);
	}
	
	public void pago() {
		clicarRadio("status_pago");
	}

	public void Salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}

}
