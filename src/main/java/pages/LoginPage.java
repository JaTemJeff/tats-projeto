package pages;

import core.AppSettings;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement input_email;

    @FindBy(name = "senha")
    WebElement input_senha;

    @FindBy(id = "btn-acessar")
    WebElement button_acessar;

    @FindBy(xpath = "//*[@id=\'user-nav\']/ul/li[1]/a/span")
    WebElement link_minha_conta;

    public void goToHomePage() {
        driver.get(AppSettings.URL_SITE);
    }

    public LoginPage setLogin(String login) {
        input_email.clear();
        input_email.sendKeys(login);
        return this;
    }

    public LoginPage setSenha(String senha) {
        input_senha.clear();
        input_senha.sendKeys(senha);
        return this;
    }

    public String getLogin() {
        return input_email.getAttribute("value");
    }

    public String getSenha() {
        return input_senha.getAttribute("value");
    }

    public void clicaLogar() {
        button_acessar.click();
    }

    public void logar() {
        goToHomePage();
        setLogin(AppSettings.LOGIN);
        setSenha(AppSettings.SENHA);
        clicaLogar();
    }

    public boolean retornaSeExibieMinhaConta() {
        return driver.getPageSource().contains("Minha Conta");
    }

    public String retornaURL() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(link_minha_conta));
        return driver.getCurrentUrl();
    }
}
