package testes;

import core.BaseTest;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ServicosPage;

public class ServicosTest extends BaseTest {

    WebDriver driver;
    ServicosPage servicosPage;
    LoginPage loginPage;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        servicosPage = new ServicosPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.logar();
    }

    @Test
    public void adicionarServicoTest() {
        servicosPage.adicionar();
        Assert.assertEquals("×\n"
                + "Serviço adicionado com sucesso!", servicosPage.retornaTextoDaMensagem());
    }
    
    @Test
    public void excluirServicoTest(){
        servicosPage.excluir();
        Assert.assertEquals("×\n"
                + "Serviço excluido com sucesso!", servicosPage.retornaTextoDaMensagem());                          
    }
}
