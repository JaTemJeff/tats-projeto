package testes;

import core.BaseTest;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.OrdemDeServicoPage;

public class OrdemDeServicoTest extends BaseTest {

    WebDriver driver;
    OrdemDeServicoPage osPage;
    LoginPage loginPage;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        osPage = new OrdemDeServicoPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.logar();
    }

    @Test
    public void adicionarOrdemDeServicoTest() {
        osPage.adicionar();
        Assert.assertEquals("×\n"
                + "OS adicionada com sucesso, você pode adicionar produtos ou serviços a essa OS"
                + " nas abas de 'Produtos' e 'Serviços'!", osPage.retornaTextoDaMensagem());
    }

    @Test
    public void excluirOrdemDeServicoTest() {
        osPage.excluir();
        Assert.assertEquals("×\n"
                + "OS excluída com sucesso!", osPage.retornaTextoDaMensagem());
    }
}
