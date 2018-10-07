package core;

import core.AppSettings.TipoExecucao;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    private WebDriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            if (AppSettings.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
                switch (AppSettings.BROWSER) {
                    case CHROME:
                        driver = new ChromeDriver();
                        break;

                    case PHATOMJS:
                        driver = new PhantomJSDriver();
                        break;

                    case CHROME_HEADLESS:
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("headless");
                        options.addArguments("window-size=1366x768");
                        driver = new ChromeDriver(options);
                        break;
                }
            }

            if (AppSettings.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
                DesiredCapabilities cap = null;
                switch (AppSettings.BROWSER) {
                    case CHROME:
                        cap = DesiredCapabilities.chrome();
                        break;
                }

                try {
                    driver = new RemoteWebDriver(new URL("http://jatemjeff:f7896caf-8d32-4282-86b2-c84108715be5@ondemand.saucelabs.com:80/wd/hub"), cap);
                } catch (MalformedURLException ex) {
                    System.err.println("Falha na conexão com a NUVEM");
                    ex.printStackTrace();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
