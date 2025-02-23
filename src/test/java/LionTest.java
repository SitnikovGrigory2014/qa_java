import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        new Lion("Неизвестный пол", felineMock);
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens());
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", felineMock);
        List<String> food = lion.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        verify(felineMock, times(1)).getFood("Хищник");
    }
}