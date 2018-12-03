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
import pages.ServicosPage;

public class ServicosTest extends BaseTest {

    WebDriver driver;
    ServicosPage servicosPage;
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
    public void CT05_adicionarServicoTest() {

        String nome = gerador.stringAleatoria(10);
        String preco = gerador.numericoAleatorio(5);
        String descricao = gerador.stringAleatoria(30);

        servicosPage = homePage.goToServicosPage()
                .clicaAdicionarNovoServico()
                .setNome(nome)
                .setPreco(preco)
                .setDescricao(descricao)
                .submeterAdicionarServico();

        Assert.assertEquals("×\n"
                + "Serviço adicionado com sucesso!", servicosPage.retornaTextoDaMensagem());
    }

    @Test
    public void CT06_excluirServicoTest() {

        servicosPage = homePage.goToServicosPage()
                .clicaBtnExcluir()
                .confirmaExclusao();

        Assert.assertEquals("×\n"
                + "Serviço excluido com sucesso!", servicosPage.retornaTextoDaMensagem());
    }
}
