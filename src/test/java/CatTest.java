import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    @InjectMocks
    private Cat cat;

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = cat.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        verify(felineMock, times(1)).eatMeat();
    }
}
