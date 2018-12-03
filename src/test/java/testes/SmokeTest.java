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
import pages.OrdemDeServicoPage;
import pages.ProdutosPage;
import pages.ServicosPage;

public class SmokeTest extends BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ClientePage clientePage;
    OrdemDeServicoPage osPage;
    ProdutosPage produtosPage;
    ServicosPage servicosPage;
    GeradorUtils gerador;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        gerador = new GeradorUtils();
    }

    @Test
    public void CT10_smokeTest() {

        //Loga
        homePage = loginPage.goToLoginPage().setLogin(AppSettings.LOGIN).setSenha(AppSettings.SENHA).clicaLogar();
        Assert.assertEquals(AppSettings.URL_DASHBOARD, loginPage.retornaURL());//Verifica se está na pagina inicial
        Assert.assertTrue(loginPage.retornaSeExibieMinhaConta());// Verifica se exibe menu "Minha Conta", oque significa que está logado

        //Adiciona Cliente
        String nomeCliente = gerador.stringAleatoria(10);
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
                .setNome(nomeCliente)
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

        //Exclui cliente 
        clientePage = homePage.goToClientePage()
                .clicaBtnExcluir()
                .confirmaExclusao();

        Assert.assertEquals("×\n"
                + "Cliente excluido com sucesso!", clientePage.retornaTextoDaMensagem());

        //Adiciona Produto 
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

        //Exclui Produto 
        produtosPage = homePage.goToProdutoPage()
                .clicaBtnExcluir()
                .confirmaExclusao();

        Assert.assertEquals("×\n"
                + "Produto excluido com sucesso!", produtosPage.retornaTextoDaMensagem());

        //Adiciona Serviço
        String nomeServico = gerador.stringAleatoria(10);
        String precoServico = gerador.numericoAleatorio(5);
        String descricaoServico = gerador.stringAleatoria(30);

        servicosPage = homePage.goToServicosPage()
                .clicaAdicionarNovoServico()
                .setNome(nomeServico)
                .setPreco(precoServico)
                .setDescricao(descricaoServico)
                .submeterAdicionarServico();

        Assert.assertEquals("×\n"
                + "Serviço adicionado com sucesso!", servicosPage.retornaTextoDaMensagem());

        //Exclui Serviço 
        servicosPage = homePage.goToServicosPage()
                .clicaBtnExcluir()
                .confirmaExclusao();

        Assert.assertEquals("×\n"
                + "Serviço excluido com sucesso!", servicosPage.retornaTextoDaMensagem());
        
        //Adiciona Ordem de Serviço 
        String cliente = "j";
        String tecnico = "admin";
        String status = "Aberto";
        String data_inicial = "10/10/2018";
        String data_final = "10/10/2019";
        String garantia = gerador.numericoAleatorio(2);
        String descricaoOs = gerador.stringAleatoria(20);
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
                .setDescricaoProduto(descricaoOs)
                .setDefeito(defeito)
                .setObeservacoes(observacoes)
                .setLaudo(laudo)
                .submeterAdicionarOrdemDeServico();

        Assert.assertEquals("×\n"
                + "OS adicionada com sucesso, você pode adicionar produtos ou serviços a essa OS nas abas de "
                + "\"Produtos\" e \"Serviços\"!", osPage.retornaTextoDaMensagem());
        
        //Exclui Ordem de Serviço 
        osPage = homePage.goToOrdemDeServicoPage()
                .clicaBtnExcluir()
                .confirmaExclusao();

        Assert.assertEquals("×\n"
                + "OS excluída com sucesso!", osPage.retornaTextoDaMensagem());
    }
}
