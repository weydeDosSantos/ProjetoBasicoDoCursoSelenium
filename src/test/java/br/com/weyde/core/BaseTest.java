package br.com.weyde.core;

import static br.com.weyde.core.DriverFactory.getDriver;
import static br.com.weyde.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.weyde.pages.LoginPage;

public class BaseTest {
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();

	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		page.email("weyde@costa");
		page.senha("123456");
		page.entrar();
	}
	
	@After
	public void quitar() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(
				"target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();

		}

	}
}
