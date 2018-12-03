package testes;

import core.AppSettings;
import core.BaseTest;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void CT00_LoginCorretoTest() {

        homePage = loginPage.goToLoginPage().setLogin(AppSettings.LOGIN).setSenha(AppSettings.SENHA).clicaLogar();
        Assert.assertEquals(AppSettings.URL_DASHBOARD, loginPage.retornaURL());//Verifica se está na pagina inicial
        Assert.assertTrue(loginPage.retornaSeExibieMinhaConta());// Verifica se exibe menu "Minha Conta", oque significa que está logado
    }
}
