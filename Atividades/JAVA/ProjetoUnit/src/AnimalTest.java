import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    public void SeAnimalEpesado(){
      Animal cavalo = new Animal("cavalo","grande",700);
      Animal cachorro = new Animal("Cachorro","médio",8);

        boolean ePesado = cachorro.Epesado();

    assertEquals(true,cavalo.Epesado());
    assertFalse(ePesado);
    }
}