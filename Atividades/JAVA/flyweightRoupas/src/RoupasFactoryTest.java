
import org.junit.jupiter.api.Test;
import static org.testng.Assert.assertEquals;

public class RoupasFactoryTest {
        @Test
void getTipoRoupa(){
                RoupasFactory roupa = new RoupasFactory();
Roupas modelo1 = RoupasFactory.CriarRoupas("M","Camisa",true,true);


assertEquals(modelo1.getTipo(),"Camisa");

        }



}
