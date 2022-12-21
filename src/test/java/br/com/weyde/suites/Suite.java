package br.com.weyde.suites;

import static br.com.weyde.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.com.weyde.pages.LoginPage;
import br.com.weyde.tests.ContaTest;
import br.com.weyde.tests.MovimentacaoTest;
import br.com.weyde.tests.RemoverMovimentacaoContaTest;
import br.com.weyde.tests.ResumoTests;
import br.com.weyde.tests.SaldoTest;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
//	ContaTest.class,
//	MovimentacaoTest.class,
//	RemoverMovimentacaoContaTest.class,
//	SaldoTest.class,
	ResumoTests.class
})
public class Suite {

	private static LoginPage page = new LoginPage();

	
	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		page.email("weyde@costa");
		page.senha("123456");
		page.entrar();
	//	DriverFactory.getDriver().findElement(By.linkText("reset")).click();

	}
	
	@AfterClass
	public static void finaliza() {
		killDriver();
	}
}
