package testes;

import core.AppSettings;
import core.BaseTest;
import core.GeradorUtils;
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
    GeradorUtils gerador;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        produtosPage = new ProdutosPage(driver);
        loginPage = new LoginPage(driver);
        gerador = new GeradorUtils();
        loginPage.logar(AppSettings.LOGIN, AppSettings.SENHA);
    }

    @Test
    public void adicionarProdutoTest() {
        
        String descricao = gerador.stringAleatoria(30);
        String precoCompra = gerador.numericoAleatorio(5);
        String precoVenda = gerador.numericoAleatorio(6);
        String estoque = gerador.numericoAleatorio(3);
        String estoqueMinimo = gerador.numericoAleatorio(2);

        produtosPage.goToProdutoPage();
        produtosPage.clicaAdicionarNovoProduto();
        produtosPage.setDescricao(descricao);
        produtosPage.setPrecoCompra(precoCompra);
        produtosPage.setPrecoVenda(precoVenda);
        produtosPage.setUnidade("Unidade");
        produtosPage.setEstoque(estoque);
        produtosPage.setEstoqueMinimo(estoqueMinimo);
        produtosPage.submeterAdicionarProduto();
        
        Assert.assertEquals("×\n"
                + "Produto adicionado com sucesso!", produtosPage.retornaTextoDaMensagem());
    }

    @Test
    public void excluirProdutoTest() {
        
        produtosPage.goToProdutoPage();
        produtosPage.clicaBtnExcluir();
        produtosPage.confirmaExclusao();
        
        Assert.assertEquals("×\n"
                + "Produto excluido com sucesso!", produtosPage.retornaTextoDaMensagem());
    }
}
