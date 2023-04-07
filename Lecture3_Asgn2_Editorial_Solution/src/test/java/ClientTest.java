import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    public void testDisplayList() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Client.display(list);
        String expectedOutput = "apple\nbanana\ncherry\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testDisplaySet() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Client.display(set);
        String expectedOutput = "1\n2\n3\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testDisplayCustomIterable() {
        CustomIterable<String> iterable = new CustomIterable<>();
        iterable.add("cat");
        iterable.add("dog");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Client.display(iterable);
        String expectedOutput = "cat\ndog\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    private static class CustomIterable<T> implements Iterable<T> {
        private List<T> list = new ArrayList<>();

        public void add(T item) {
            list.add(item);
        }

        @Override
        public Iterator<T> iterator() {
            return list.iterator();
        }
    }

}
