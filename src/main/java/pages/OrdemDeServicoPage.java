package pages;

import core.BasePage;
import core.GeradorUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrdemDeServicoPage extends BasePage {

    public OrdemDeServicoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\'sidebar\']/ul/li[5]/a")
    WebElement link_ordem_de_servico;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/div[1]/form/div[1]/a")
    WebElement button_adicionar_ordem_de_servico;

    @FindBy(id = "cliente")
    WebElement input_cliente;

    @FindBy(id = "tecnico")
    WebElement input_tecnico_responsavel;

    @FindBy(id = "status")
    WebElement select;

    @FindBy(id = "dataInicial")
    WebElement input_data_inicial;

    @FindBy(id = "dataFinal")
    WebElement input_data_final;

    @FindBy(id = "garantia")
    WebElement input_garantia;

    @FindBy(id = "descricaoProduto")
    WebElement input_descricao_produto_servico;

    @FindBy(id = "defeito")
    WebElement input_defeito;

    @FindBy(id = "observacoes")
    WebElement input_observacoes;

    @FindBy(id = "laudoTecnico")
    WebElement input_laudo_tecnico;

    @FindBy(xpath = "//*[@id=\'btnContinuar\']")
    WebElement button_submit;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/div[1]")
    WebElement alert_mensagem;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[7]/a[4]")
    WebElement button_excluir;

    @FindBy(xpath = "//*[@id=\'modal-excluir\']/form/div[3]/button[2]")
    WebElement button_confirmar_exclusao;

    public OrdemDeServicoPage setCliente(String cliente) {
        input_cliente.clear();
        input_cliente.sendKeys(cliente);
        return this;
    }

    public OrdemDeServicoPage setTecnico(String tecnico) {
        input_tecnico_responsavel.clear();
        input_tecnico_responsavel.sendKeys(tecnico);
        return this;
    }

    public OrdemDeServicoPage setStatus(String status) {
        Select seleciona_status = new Select(select);
        seleciona_status.selectByVisibleText(status);
        return this;
    }

    public OrdemDeServicoPage setDataInicial(String data) {
        input_data_inicial.clear();
        input_data_inicial.sendKeys(data);
        return this;
    }

    public OrdemDeServicoPage setDataFinal(String data) {
        input_data_final.clear();
        input_data_final.sendKeys(data);
        return this;
    }

    public OrdemDeServicoPage setGarantia(String garantia) {
        input_garantia.clear();
        input_garantia.sendKeys(garantia);
        return this;
    }

    public OrdemDeServicoPage setDescricaoProduto(String descricao) {
        input_descricao_produto_servico.clear();
        input_descricao_produto_servico.sendKeys(descricao);
        return this;
    }

    public OrdemDeServicoPage setDefeito(String defeito) {
        input_defeito.clear();
        input_defeito.sendKeys(defeito);
        return this;
    }

    public OrdemDeServicoPage setObeservacoes(String observacoes) {
        input_observacoes.clear();
        input_observacoes.sendKeys(observacoes);
        return this;
    }

    public OrdemDeServicoPage setLaudo(String laudo) {
        input_laudo_tecnico.clear();
        input_laudo_tecnico.sendKeys(laudo);
        return this;
    }

    public void goToOrdemDeServicoPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(link_ordem_de_servico));
        link_ordem_de_servico.click();
    }

    public void clicaAdicionarNovaOrdemDeServico() {
        button_adicionar_ordem_de_servico.click();
    }

    public void submeterAdicionarOrdemDeServico() {
        button_submit.click();
    }

    public void adicionar() {
        GeradorUtils gerador = new GeradorUtils();

        String cliente = "jeff";
        String tecnico = "admin";
        String status = "Aberto";
        String data_inicial = "10/10/2018";
        String data_final = "10/10/2019";
        String garantia = gerador.numericoAleatorio(2);
        String descricao = gerador.stringAleatoria(20);
        String defeito = gerador.stringAleatoria(20);
        String observacoes = gerador.stringAleatoria(20);
        String laudo = gerador.stringAleatoria(20);

        goToOrdemDeServicoPage();
        clicaAdicionarNovaOrdemDeServico();
        setCliente(cliente);
        setTecnico(tecnico);
        setStatus(status);
        setDataInicial(data_inicial);
        setDataFinal(data_final);
        setGarantia(garantia);
        setDescricaoProduto(descricao);
        setDefeito(defeito);
        setObeservacoes(observacoes);
        setLaudo(laudo);
        submeterAdicionarOrdemDeServico();
    }

    public String retornaTextoDaMensagem() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(alert_mensagem));
        return alert_mensagem.getText().trim();
    }

    public void clicaBtnExcluir() {
        button_excluir.click();
    }

    public void confirmaExclusao() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(button_confirmar_exclusao));
        button_confirmar_exclusao.click();
    }

    public void excluir() {
        goToOrdemDeServicoPage();
        clicaBtnExcluir();
        confirmaExclusao();
    }
}
