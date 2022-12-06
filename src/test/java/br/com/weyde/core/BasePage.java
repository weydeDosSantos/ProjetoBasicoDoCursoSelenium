package br.com.weyde.core;

import static br.com.weyde.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	/********* Escreve ***********/
	public void escreve(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).clear();
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);

	}

	public void escreve(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);

	}

	/********* Escreve ***********/

	/********* ClicaRadio ***********/

	public void clicarRadio(String id_radio) {
		clicarRadio(By.id(id_radio));

	}

	public void clicarRadio(By by) {
		getDriver().findElement(by).click();

	}

	/********* ClicaRadio ***********/

	/********* ClicaBotão ***********/

	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarBotaoPorTexto(String texto) {
		clicarBotao(By.xpath("//button[.='" + texto + "']"));
	}

	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}

	/********* ClicaBotão ***********/

	/********* ClicaLink ***********/

	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();

	}

	/********* ClicaLink ***********/

	/********* Obtêm ***********/

	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}

	public String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();

	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}

	/********* Obtêm ***********/

	/********* Combo ***********/
	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void selecionarComboby(By by, String valor) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void selecionarComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='" + radical + "_input']/../..//span"));
		clicarRadio(By.xpath("//ul[@id='" + radical + "_items']/li[.='" + valor + "']"));
	}

	/********* Combo ***********/

	/********* Frame ***********/
	public void mudarFocoParaFrameEspecifico(String frame) {
		getDriver().switchTo().frame(frame);

	}

	public void mudarFocoParaFramePadrao() {
		getDriver().switchTo().defaultContent();

	}

	/********* Frame ***********/

	/********* Janela ***********/
	public void mudarFocoJanelaEspecifica(String id) {
		getDriver().switchTo().window(id);

	}

	public void fecharJanela() {
		getDriver().close();
	}

	/********* Janela ***********/

	/********* Boleano ***********/

	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();

		/********* Boleano ***********/

	}

	/********* ObterTexto ***********/

	public String alertObterTextoEDigitarEAceitar(String num) {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.sendKeys(num);
		alert.accept();
		return valor;
	}

	public String alertObterTextoEAceita() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}

	public String alertObterTextoERecusa() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}

	public String alertObterTexto() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		return valor;
	}

	/********* ObterTexto ***********/

	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		// PROCURAR COLUNA DO REGISTRO
		WebElement tabela = getDriver().findElement(By.xpath("//table[@id='" + idTabela + "']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		// ENCONTRAR A LINHA DO REGISTRO
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		// PROCURAR COLUNA DO BOTAO
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		// CLICAR NO BOTAO DA CELULA ENCONTRADA
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
		return celula;
	}

	public void ClicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {

		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}

		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}

		}
		return idColuna;
	}
}
