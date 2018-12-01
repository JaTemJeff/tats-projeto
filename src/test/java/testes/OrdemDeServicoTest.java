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
import pages.OrdemDeServicoPage;

public class OrdemDeServicoTest extends BaseTest {

    WebDriver driver;
    OrdemDeServicoPage osPage;
    LoginPage loginPage;
    GeradorUtils gerador;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        osPage = new OrdemDeServicoPage(driver);
        loginPage = new LoginPage(driver);
        gerador = new GeradorUtils();
        loginPage.logar(AppSettings.LOGIN, AppSettings.SENHA);
    }

    @Test
    public void adicionarOrdemDeServicoTest() {
        
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

        osPage.goToOrdemDeServicoPage();
        osPage.clicaAdicionarNovaOrdemDeServico();
        osPage.setCliente(cliente);
        osPage.setTecnico(tecnico);
        osPage.setStatus(status);
        osPage.setDataInicial(data_inicial);
        osPage.setDataFinal(data_final);
        osPage.setGarantia(garantia);
        osPage.setDescricaoProduto(descricao);
        osPage.setDefeito(defeito);
        osPage.setObeservacoes(observacoes);
        osPage.setLaudo(laudo);
        osPage.submeterAdicionarOrdemDeServico();
        
        System.out.println(""+osPage.retornaTextoDaMensagem());
        Assert.assertEquals("×\n" 
                +"OS adicionada com sucesso, você pode adicionar produtos ou serviços a essa OS nas abas de "
                + "\"Produtos\" e \"Serviços\"!", osPage.retornaTextoDaMensagem());
    }

    @Test
    public void excluirOrdemDeServicoTest() {
        
        osPage.goToOrdemDeServicoPage();
        osPage.clicaBtnExcluir();
        osPage.confirmaExclusao();
        
        Assert.assertEquals("×\n"
                + "OS excluída com sucesso!", osPage.retornaTextoDaMensagem());
    }
}
