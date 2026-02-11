import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {

    // Static ArrayList test fixture
    private static ArrayList<String> list;

    @BeforeAll
    public static void setUp() {
        // Initialize a new ArrayList
        list = new ArrayList<>();

        // Add values to the list
        list.add("alpha"); // index 0
        list.add("beta");  // index 1
    }

    @Test
    public void insertTest() {
        // Assert initial size
        assertEquals(2, list.size(), "Wrong size");

        // Add a new value
        list.add("gamma");

        // Assert new size
        assertEquals(3, list.size(), "Wrong size after insert");

        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element at index 0");
        assertEquals("beta", list.get(1), "Wrong element at index 1");
        assertEquals("gamma", list.get(2), "Wrong element at index 2");
    }

    @Test
    public void replaceTest() {
        // Assert initial size
        assertEquals(2, list.size(), "Wrong size");

        // Add a new value
        list.add("delta");

        // Assert new size
        assertEquals(3, list.size(), "Wrong size after insert");

        // Replace element at index 1
        list.set(1, "epsilon");

        // Assert updated values
        assertEquals("alpha", list.get(0), "Wrong element at index 0");
        assertEquals("epsilon", list.get(1), "Wrong element at index 1");
        assertEquals("delta", list.get(2), "Wrong element at index 2");
    }
}
