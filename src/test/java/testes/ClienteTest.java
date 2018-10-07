package testes;

import core.BaseTest;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ClientePage;
import pages.LoginPage;

public class ClienteTest extends BaseTest {

    WebDriver driver;
    ClientePage clientePage;
    LoginPage loginPage;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        clientePage = new ClientePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.logar();
    }

    @Test
    public void adicionarClienteTest() {
        clientePage.adicionar();
        Assert.assertEquals("×\n"
                + "Cliente adicionado com sucesso!", clientePage.retornaTextoDaMensagem());

    }
    
    @Test
    public void excluirClienteTest(){
        clientePage.excluir();
        Assert.assertEquals("×\n"
                + "Cliente excluido com sucesso!", clientePage.retornaTextoDaMensagem());                          
    }
}
