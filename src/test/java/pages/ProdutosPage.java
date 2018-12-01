package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdutosPage extends BasePage {

    public ProdutosPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\'sidebar\']/ul/li[3]/a")
    WebElement link_produtos;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/a")
    WebElement button_adicionar_produto;

    @FindBy(id = "descricao")
    WebElement input_descricao;

    @FindBy(id = "precoCompra")
    WebElement input_preco_compra;

    @FindBy(id = "precoVenda")
    WebElement input_preco_venda;

    @FindBy(id = "unidade")
    WebElement select;
   
    @FindBy(id = "estoque")
    WebElement input_estoque;

    @FindBy(id = "estoqueMinimo")
    WebElement input_estoque_minimo;

    @FindBy(xpath = "//*[@id=\'formProduto\']/div[8]/div/div/button")
    WebElement button_submit;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/div[1]")
    WebElement alert_mensagem;

    @FindBy(xpath = "//*[@id=\'content\']/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[3]")
    WebElement button_excluir;

    @FindBy(xpath = "//*[@id=\'modal-excluir\']/form/div[3]/button[2]")
    WebElement button_confirmar_exclusao;

    public ProdutosPage setDescricao(String descricao) {
        input_descricao.clear();
        input_descricao.sendKeys(descricao);
        return this;
    }

    public ProdutosPage setPrecoCompra(String valor) {
        input_preco_compra.clear();
        input_preco_compra.sendKeys(valor);
        return this;
    }

    public ProdutosPage setPrecoVenda(String valor) {
        input_preco_venda.clear();
        input_preco_venda.sendKeys(valor);
        return this;
    }

    public ProdutosPage setUnidade(String opcao) {
        Select seleciona_unidade = new Select(select);
        seleciona_unidade.selectByVisibleText(opcao);
        return this;
    }

    public ProdutosPage setEstoque(String quantidade) {
        input_estoque.clear();
        input_estoque.sendKeys(quantidade);
        return this;
    }

    public ProdutosPage setEstoqueMinimo(String quantidade) {
        input_estoque_minimo.clear();
        input_estoque_minimo.sendKeys(quantidade);
        return this;
    }

    public void goToProdutoPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(link_produtos));
        link_produtos.click();
    }

    public void clicaAdicionarNovoProduto() {
        button_adicionar_produto.click();
    }

    public void submeterAdicionarProduto() {
        button_submit.click();
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
}
