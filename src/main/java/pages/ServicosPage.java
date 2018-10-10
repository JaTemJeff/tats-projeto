package pages;

import core.BasePage;
import core.GeradorUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServicosPage extends BasePage {

    public ServicosPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\'sidebar\']/ul/li[4]/a/span")
    WebElement link_servicos;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/a")
    WebElement button_adicionar_servico;

    @FindBy(id = "nome")
    WebElement input_nome;

    @FindBy(id = "preco")
    WebElement input_preco;

    @FindBy(id = "descricao")
    WebElement input_descricao;

    @FindBy(xpath = "//*[@id=\'formServico\']/div[4]/div/div/button")
    WebElement button_submit;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/div[1]")
    WebElement alert_mensagem;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[2]")
    WebElement button_excluir;

    @FindBy(xpath = "//*[@id=\'modal-excluir\']/form/div[3]/button[2]")
    WebElement button_confirmar_exclusao;

    public ServicosPage setNome(String nome) {
        input_nome.clear();
        input_nome.sendKeys(nome);
        return this;
    }

    public ServicosPage setPreco(String preco) {
        input_preco.clear();
        input_preco.sendKeys(preco);
        return this;
    }

    public ServicosPage setDescricao(String descricao) {
        input_descricao.clear();
        input_descricao.sendKeys(descricao);
        return this;
    }

    public void goToServicosPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(link_servicos));
        link_servicos.click();
    }

    public void clicaAdicionarNovoServico() {
        button_adicionar_servico.click();
    }

    public void submeterAdicionarServico() {
        button_submit.click();
    }

    public void adicionar() {
        GeradorUtils gerador = new GeradorUtils();

        String nome = gerador.stringAleatoria(10);
        String preco = gerador.numericoAleatorio(5);
        String descricao = gerador.stringAleatoria(30);

        goToServicosPage();
        clicaAdicionarNovoServico();
        setNome(nome);
        setPreco(preco);
        setDescricao(descricao);
        submeterAdicionarServico();
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
        goToServicosPage();
        clicaBtnExcluir();
        confirmaExclusao();
    }
}
