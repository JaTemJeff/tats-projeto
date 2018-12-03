package testes;

import core.AppSettings;
import core.BaseTest;
import core.GeradorUtils;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.ProdutosPage;

public class ProdutosTest extends BaseTest {

    WebDriver driver;
    ProdutosPage produtosPage;
    LoginPage loginPage;
    HomePage homePage;
    GeradorUtils gerador;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        gerador = new GeradorUtils();
        homePage = loginPage.goToLoginPage().setLogin(AppSettings.LOGIN).setSenha(AppSettings.SENHA).clicaLogar();
    }

    @Test
    public void CT03_adicionarProdutoTest() {

        String descricao = gerador.stringAleatoria(30);
        String precoCompra = gerador.numericoAleatorio(5);
        String precoVenda = gerador.numericoAleatorio(6);
        String estoque = gerador.numericoAleatorio(3);
        String estoqueMinimo = gerador.numericoAleatorio(2);

        produtosPage = homePage.goToProdutoPage()
                .clicaAdicionarNovoProduto()
                .setDescricao(descricao)
                .setPrecoCompra(precoCompra)
                .setPrecoVenda(precoVenda)
                .setUnidade("Unidade")
                .setEstoque(estoque)
                .setEstoqueMinimo(estoqueMinimo)
                .submeterAdicionarProduto();

        Assert.assertEquals("×\n"
                + "Produto adicionado com sucesso!", produtosPage.retornaTextoDaMensagem());
    }

    @Test
    public void CT04_excluirProdutoTest() {

        produtosPage = homePage.goToProdutoPage()
                .clicaBtnExcluir()
                .confirmaExclusao();

        Assert.assertEquals("×\n"
                + "Produto excluido com sucesso!", produtosPage.retornaTextoDaMensagem());
    }
}
