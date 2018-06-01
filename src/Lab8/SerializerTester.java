package Lab8;

import Lab5.Toy;
import Lab6.MyList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class SerializerTester {

    static MyList<Toy> toys;

    @BeforeAll
    public static void setUp(){
        toys = new MyList<>();
        for (int i = 0; i < 10; i++) {
            toys.add(new Toy());
        }
    }

    @Test
    public void testObject() throws IOException, ClassNotFoundException {
        Serializer.writeObject(toys, "data/object.out");
        assertEquals(Arrays.toString(toys.toArray()), Arrays.toString(Serializer.readObject("data/object.out").toArray()));
    }

    @Test
    public void testSequence() throws IOException, ClassNotFoundException {
        Serializer.writeSequence(toys, "data/sequence.out");
        assertEquals(Arrays.toString(toys.toArray()), Arrays.toString(Serializer.readSequence("data/sequence.out").toArray()));
    }

    @Test
    public void testText() throws IOException{
        Serializer.writeJson(toys, "data/text.json");
        assertEquals(Arrays.toString(toys.toArray()), Arrays.toString(Serializer.readJson("data/text.json").toArray()));
    }
}
