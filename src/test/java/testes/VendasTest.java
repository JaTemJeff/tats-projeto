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
import pages.VendasPage;

public class VendasTest extends BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    VendasPage vendasPage;
    GeradorUtils gerador;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        gerador = new GeradorUtils();
        homePage = loginPage.goToLoginPage().setLogin(AppSettings.LOGIN).setSenha(AppSettings.SENHA).clicaLogar();
    }

    @Test
    public void CT09_adicionarVendaTest() {

        String cliente = "j";
        String vendedor = "admin";

        vendasPage = homePage.goToVendasPage()
                .clicaAdicionarVenda()
                .setCliente(cliente)
                .setVendedor(vendedor)
                .submeterContinuar();

        Assert.assertEquals("×\n"
                + "Venda iniciada com sucesso, adicione os produtos.", vendasPage.retornaTextoDaMensagem());

    }
}
