package Lab8;

import Lab5.Toy;
import Lab6.MyList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Serializer {

    /**
     * Serialize list as single object.
     * @param list object to serialize
     * @param fileName name of file to write serialized object
     */
    public static void writeObject(MyList<Toy> list, String fileName) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(list);
        oos.close();
    }

    /**
     * Deserialize object.
     * @param fileName name of file to deserialize
     * @return deserialized object
     */
    public static MyList<Toy> readObject(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        MyList<Toy> list = (MyList<Toy>) ois.readObject();
        ois.close();
        return list;
    }

    /**
     * Serialize list as object sequence.
     * @param list object to serialize
     * @param fileName name of file to write serialized object
     */
    public static void writeSequence(MyList<Toy> list, String fileName) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        for (Toy e : list) {
           oos.writeObject(e);
        }
        oos.close();
    }

    /**
     * Deserialize object.
     * @param fileName name of file to deserialize
     * @return deserialized object
     */
    public static MyList<Toy> readSequence(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        MyList<Toy> list = new MyList<>();
        try{
            Toy e = (Toy) ois.readObject();
            while (true){
                list.add(e);
                e = (Toy) ois.readObject();
            }
        } catch (EOFException e) {
            ois.close();
        }
        return list;
    }

    /**
     * Serialize list as text in json.
     * @param list object to serialize
     * @param fileName name of file to write serialized object
     */
    public static void writeJson(MyList<Toy> list, String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), list);
    }

    /**
     * Deserialize object.
     * @param fileName name of file to deserialize
     * @return deserialized object
     */
    public static MyList<Toy> readJson(String fileName) throws IOException {
         ObjectMapper mapper = new ObjectMapper();
         return mapper.readValue(new FileInputStream(fileName), new TypeReference<MyList<Toy>>(){});
    }

}
