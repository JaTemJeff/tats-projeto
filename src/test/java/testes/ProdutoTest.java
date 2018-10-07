package testes;

import core.BaseTest;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProdutoPage;

public class ProdutoTest extends BaseTest {
    WebDriver driver;
    ProdutoPage produtoPage;
    LoginPage loginPage;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        produtoPage = new ProdutoPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.logar();
    }
    
    @Test
    public void adicionarProdutoTest(){
    
    }
    
    @Test
    public void excluirProdutoTest(){
        produtoPage.excluir();
        Assert.assertEquals("×\n"
                + "Produto excluido com sucesso!", produtoPage.retornaTextoDaMensagem()); 
    }
}
