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
import pages.OrdemDeServicoPage;

public class OrdemDeServicoTest extends BaseTest {

    WebDriver driver;
    OrdemDeServicoPage osPage;
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
    public void CT07_adicionarOrdemDeServicoTest() {

        String cliente = "j";
        String tecnico = "admin";
        String status = "Aberto";
        String data_inicial = "10/10/2018";
        String data_final = "10/10/2019";
        String garantia = gerador.numericoAleatorio(2);
        String descricao = gerador.stringAleatoria(20);
        String defeito = gerador.stringAleatoria(20);
        String observacoes = gerador.stringAleatoria(20);
        String laudo = gerador.stringAleatoria(20);

        osPage = homePage.goToOrdemDeServicoPage()
                .clicaAdicionarNovaOrdemDeServico()
                .setCliente(cliente)
                .setTecnico(tecnico)
                .setStatus(status)
                .setDataInicial(data_inicial)
                .setDataFinal(data_final)
                .setGarantia(garantia)
                .setDescricaoProduto(descricao)
                .setDefeito(defeito)
                .setObeservacoes(observacoes)
                .setLaudo(laudo)
                .submeterAdicionarOrdemDeServico();

        Assert.assertEquals("×\n"
                + "OS adicionada com sucesso, você pode adicionar produtos ou serviços a essa OS nas abas de "
                + "\"Produtos\" e \"Serviços\"!", osPage.retornaTextoDaMensagem());
    }

    @Test
    public void CT08_excluirOrdemDeServicoTest() {

        osPage = homePage.goToOrdemDeServicoPage()
                .clicaBtnExcluir()
                .confirmaExclusao();

        Assert.assertEquals("×\n"
                + "OS excluída com sucesso!", osPage.retornaTextoDaMensagem());
    }
}
