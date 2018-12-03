package testes;

import core.AppSettings;
import core.BaseTest;
import core.GeradorUtils;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ClientePage;
import pages.HomePage;
import pages.LoginPage;

public class ClienteTest extends BaseTest {

    WebDriver driver;
    ClientePage clientePage;
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
    public void CT01_adicionarClienteTest() {

        String nome = gerador.stringAleatoria(10);
        String documento = gerador.gerarCPF();
        String telefone = gerador.numericoAleatorio(11);
        String celular = gerador.numericoAleatorio(11);
        String email = gerador.alfanumericoAleatorio(10) + "@teste.com";
        String cep = "86020330";
        String numero = gerador.numericoAleatorio(3);
        String rua = "Rua Sergipe";
        String bairro = "Centro";
        String cidade = "Londrina";
        String estado = "Paraná";

        clientePage = homePage
                .goToClientePage()
                .clicaAdicionarNovoCliente()
                .setNome(nome)
                .setDocumento(documento)
                .setTelefone(telefone)
                .setCelular(celular)
                .setEmail(email)
                .setCep(cep)
                .setNumero(numero)
                .setRua(rua)
                .setBairro(bairro)
                .setCidade(cidade)
                .setEstado(estado)
                .submeterAdicionarCliente();

        Assert.assertEquals("×\n"
                + "Cliente adicionado com sucesso!", clientePage.retornaTextoDaMensagem());
    }

    @Test
    public void CT02_excluirClienteTest() {

        clientePage = homePage.goToClientePage()
                .clicaBtnExcluir()
                .confirmaExclusao();

        Assert.assertEquals("×\n"
                + "Cliente excluido com sucesso!", clientePage.retornaTextoDaMensagem());
    }
}
