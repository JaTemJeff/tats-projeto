package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VendasPage extends BasePage {

    public VendasPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/a")
    WebElement button_adicionar_venda;

    @FindBy(id = "cliente")
    WebElement input_cliente;

    @FindBy(linkText = "jeff | Telefone: 1111111111")
    WebElement autoComplete_cliente;

    @FindBy(id = "tecnico")
    WebElement input_vendedor;

    @FindBy(linkText = "admin | Telefone: 0000-0000")
    WebElement autoComplete_tecnico;

    @FindBy(xpath = "//*[@id=\"btnContinuar\"]")
    WebElement botao_continuar;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/div[1]")
    WebElement alert_mensagem;

    public VendasPage setCliente(String cliente) {
        input_cliente.clear();
        input_cliente.sendKeys(cliente);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(autoComplete_cliente));

        autoComplete_cliente.click();

        return this;
    }

    public VendasPage setVendedor(String tecnico) {
        input_vendedor.clear();
        input_vendedor.sendKeys(tecnico);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(autoComplete_tecnico));

        autoComplete_tecnico.click();

        return this;
    }

    public VendasPage clicaAdicionarVenda() {
        button_adicionar_venda.click();
        return this;
    }

    public VendasPage submeterContinuar() {
        botao_continuar.click();
        return this;
    }

    public String retornaTextoDaMensagem() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(alert_mensagem));
        return alert_mensagem.getText().trim();
    }
}
