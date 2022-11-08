
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TestLog {
    private static final Logger logger = Logger.getLogger(TestLog.class);

    public static void main(String[] args) {
        String log4jConfPath = "src/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath); // setar local do documento log4j.properties

        logger.info("Começamos nosso metodo main");
        try {
            String variable = "Olá";
            int division = 1/0;

        }catch (Exception e){
            logger.error("Erro ao dividir por zero",e);
        }
        logger.warn("Aviso, o método MAIN está prestes a terminar");
        logger.debug("Isso será mostrado apenas se o infoLogger estiver em DEBUG");
        logger.info("Finalizamos a thread MAIN");
    }
}
