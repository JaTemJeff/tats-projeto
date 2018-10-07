package core;

public class AppSettings {

    public static String URL_SITE = "http://192.168.1.11/";
    public static String URL_DASHBOARD = "http://192.168.1.11/index.php/mapos";

    public static String LOGIN = "admin@admin.com";
    public static String SENHA = "123456";

    //Propriedades = true, não fecha os browsers ao fim de cada teste
    public static boolean FECHAR_BROWSER = true;

    //Escolhe em qual browser rodar
    public static Browsers BROWSER = Browsers.CHROME;

    public enum Browsers {
        CHROME,
        PHATOMJS,
        CHROME_HEADLESS
    }

    //Escolhe se roda local ou na nuvem (configurar SauceLabs)
    public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;

    public enum TipoExecucao {
        LOCAL,
        NUVEM
    }
}
