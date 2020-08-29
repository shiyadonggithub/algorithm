package javastudy;

import lombok.Data;

import java.io.*;

public class SerializeStudy {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializeStudy serializeStudy = new SerializeStudy();
        //serializeStudy.serialize();

        serializeStudy.deSerialize();
    }

    public void serialize() throws IOException {
        Persion persion = new Persion();
        persion.setAge(100);
        persion.setName("yadongshi");
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream("/Users/yadong/test.ser"));
        objectOutputStream.writeObject(persion);
        objectOutputStream.close();
        System.out.println("序列化成功");
    }

    public void deSerialize() throws IOException, ClassNotFoundException {
        File file = new File("/Users/yadong/test.ser");
        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(file));
        Persion persion = (Persion) objectInputStream.readObject();
        System.out.println(persion.age);
        System.out.println(persion.name);

    }
}

@Data
class Persion implements Serializable {
    private static final long serialVersionUID = 1L;
    public int age;
    public String name;
    public String test;
}