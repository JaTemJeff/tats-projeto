package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientePage extends BasePage {

    public ClientePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/a")
    WebElement button_adicionar_cliente;

    @FindBy(id = "nomeCliente")
    WebElement input_nome;

    @FindBy(id = "documento")
    WebElement input_documento;

    @FindBy(id = "telefone")
    WebElement input_telefone;

    @FindBy(id = "celular")
    WebElement input_celular;

    @FindBy(id = "email")
    WebElement input_email;

    @FindBy(id = "cep")
    WebElement input_cep;

    @FindBy(id = "numero")
    WebElement input_numero;

    @FindBy(id = "rua")
    WebElement input_rua;

    @FindBy(id = "bairro")
    WebElement input_bairro;

    @FindBy(id = "cidade")
    WebElement input_cidade;

    @FindBy(id = "estado")
    WebElement input_estado;

    @FindBy(xpath = "//*[@id=\'formCliente\']/div[12]/div/div/button")
    WebElement button_submit;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/div[1]")
    WebElement alert_mensagem;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[3]")
    WebElement button_excluir;

    @FindBy(xpath = "//*[@id=\'modal-excluir\']/form/div[3]/button[2]")
    WebElement button_confirmar_exclusao;

    public ClientePage setNome(String nome) {
        input_nome.clear();
        input_nome.sendKeys(nome);
        return this;
    }

    public ClientePage setDocumento(String documento) {
        input_documento.clear();
        input_documento.sendKeys(documento);
        return this;
    }

    public ClientePage setTelefone(String telefone) {
        input_telefone.clear();
        input_telefone.sendKeys(telefone);
        return this;
    }

    public ClientePage setCelular(String celular) {
        input_celular.clear();
        input_celular.sendKeys(celular);
        return this;
    }

    public ClientePage setEmail(String email) {
        input_email.clear();
        input_email.sendKeys(email);
        return this;
    }

    public ClientePage setCep(String cep) {
        input_cep.clear();
        input_cep.sendKeys(cep);
        return this;
    }

    public ClientePage setNumero(String numero) {
        input_numero.clear();
        input_numero.sendKeys(numero);
        return this;
    }

    public ClientePage setRua(String rua) {
        input_rua.clear();
        input_rua.sendKeys(rua);
        return this;
    }

    public ClientePage setBairro(String bairro) {
        input_bairro.clear();
        input_bairro.sendKeys(bairro);
        return this;
    }

    public ClientePage setCidade(String cidade) {
        input_cidade.clear();
        input_cidade.sendKeys(cidade);
        return this;
    }

    public ClientePage setEstado(String estado) {
        input_estado.clear();
        input_estado.sendKeys(estado);
        return this;
    }

    public ClientePage clicaAdicionarNovoCliente() {
        button_adicionar_cliente.click();
        return this;
    }

    public ClientePage submeterAdicionarCliente() {
        button_submit.click();
        return this;
    }

    public String retornaTextoDaMensagem() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(alert_mensagem));
        return alert_mensagem.getText().trim();
    }

    public ClientePage clicaBtnExcluir() {
        button_excluir.click();
        return this;
    }

    public ClientePage confirmaExclusao() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(button_confirmar_exclusao));
        button_confirmar_exclusao.click();
        return this;
    }
}
