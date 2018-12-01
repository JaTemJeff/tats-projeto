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
import pages.ServicosPage;

public class ServicosTest extends BaseTest {

    WebDriver driver;
    ServicosPage servicosPage;
    LoginPage loginPage;
    GeradorUtils gerador;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        servicosPage = new ServicosPage(driver);
        loginPage = new LoginPage(driver);
        gerador = new GeradorUtils();
        loginPage.logar(AppSettings.LOGIN, AppSettings.SENHA);
    }

    @Test
    public void adicionarServicoTest() {
        
        String nome = gerador.stringAleatoria(10);
        String preco = gerador.numericoAleatorio(5);
        String descricao = gerador.stringAleatoria(30);

        servicosPage.goToServicosPage();
        servicosPage.clicaAdicionarNovoServico();
        servicosPage.setNome(nome);
        servicosPage.setPreco(preco);
        servicosPage.setDescricao(descricao);
        servicosPage.submeterAdicionarServico();
        
        Assert.assertEquals("×\n"
                + "Serviço adicionado com sucesso!", servicosPage.retornaTextoDaMensagem());
    }
    
    @Test
    public void excluirServicoTest(){
        servicosPage.goToServicosPage();
        servicosPage.clicaBtnExcluir();
        servicosPage.confirmaExclusao();
        
        Assert.assertEquals("×\n"
                + "Serviço excluido com sucesso!", servicosPage.retornaTextoDaMensagem());                          
    }
}
