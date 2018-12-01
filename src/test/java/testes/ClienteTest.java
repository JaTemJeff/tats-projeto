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
import pages.LoginPage;

public class ClienteTest extends BaseTest {

    WebDriver driver;
    ClientePage clientePage;
    LoginPage loginPage;
    GeradorUtils gerador;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        clientePage = new ClientePage(driver);
        loginPage = new LoginPage(driver);
        gerador = new GeradorUtils();
        loginPage.logar(AppSettings.LOGIN, AppSettings.SENHA);
    }

    @Test
    public void adicionarClienteTest() {
        
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
        
        clientePage.goToClientePage();
        clientePage.clicaAdicionarNovoCliente();
        clientePage.setNome(nome);
        clientePage.setDocumento(documento);
        clientePage.setTelefone(telefone);
        clientePage.setCelular(celular);
        clientePage.setEmail(email);
        clientePage.setCep(cep);
        clientePage.setNumero(numero);
        clientePage.setRua(rua);
        clientePage.setBairro(bairro);
        clientePage.setCidade(cidade);
        clientePage.setEstado(estado);
        clientePage.submeterAdicionarCliente();
        
        Assert.assertEquals("×\n"
                + "Cliente adicionado com sucesso!", clientePage.retornaTextoDaMensagem());
    }
    
    @Test
    public void excluirClienteTest(){
        
        clientePage.goToClientePage();
        clientePage.clicaBtnExcluir();
        clientePage.confirmaExclusao();
        
        Assert.assertEquals("×\n"
                + "Cliente excluido com sucesso!", clientePage.retornaTextoDaMensagem());                          
    }
}
