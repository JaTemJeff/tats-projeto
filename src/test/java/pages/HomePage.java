package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage{
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//*[@id=\'sidebar\']/ul/li[2]/a/span")
    WebElement link_cliente;
    
    @FindBy(xpath = "//*[@id=\'sidebar\']/ul/li[5]/a")
    WebElement link_ordem_de_servico;
    
    @FindBy(xpath = "//*[@id=\'sidebar\']/ul/li[3]/a")
    WebElement link_produtos;
    
    @FindBy(xpath = "//*[@id=\'sidebar\']/ul/li[4]/a/span")
    WebElement link_servicos;
    
    @FindBy(xpath = "//*[@id=\'sidebar\']/ul/li[6]/a/span")
    WebElement link_vendas;
   
    public ClientePage goToClientePage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(link_cliente));
        link_cliente.click();
        return new ClientePage(driver);
    }
    
    public OrdemDeServicoPage goToOrdemDeServicoPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(link_ordem_de_servico));
        link_ordem_de_servico.click();
        return new OrdemDeServicoPage(driver);
    }
    
    public ProdutosPage goToProdutoPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(link_produtos));
        link_produtos.click();
        return new ProdutosPage(driver);
    }
    
    public ServicosPage goToServicosPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(link_servicos));
        link_servicos.click();
        return new ServicosPage(driver);
    }
    
    public VendasPage goToVendasPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(link_vendas));
        link_vendas.click();
        return new VendasPage(driver);
    }
    
}
