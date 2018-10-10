package testes;

import core.BaseTest;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProdutosPage;


public class ProdutosTest extends BaseTest {

    WebDriver driver;
    ProdutosPage produtosPage;
    LoginPage loginPage;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        produtosPage = new ProdutosPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.logar();
    }

    @Test
    public void adicionarProdutoTest() {
        produtosPage.adicionar();
        Assert.assertEquals("×\n"
                + "Produto adicionado com sucesso!", produtosPage.retornaTextoDaMensagem());
    }

    @Test
    public void excluirProdutoTest() {
        produtosPage.excluir();
        Assert.assertEquals("×\n"
                + "Produto excluido com sucesso!", produtosPage.retornaTextoDaMensagem());
    }
}
