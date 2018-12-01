package testes;

import core.AppSettings;
import core.BaseTest;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void LoginCorretoTest() {
        
        loginPage.logar(AppSettings.LOGIN, AppSettings.SENHA);
        
        Assert.assertEquals(AppSettings.URL_DASHBOARD, loginPage.retornaURL());//Verifica se está na pagina inicial
        Assert.assertTrue(loginPage.retornaSeExibieMinhaConta());// Verifica se exibe menu "Minha Conta", oque significa que está logado
    }
}
