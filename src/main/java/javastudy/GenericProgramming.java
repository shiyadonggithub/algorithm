package javastudy;

import lombok.Data;
import sun.java2d.loops.GeneralRenderer;

import java.util.ArrayList;
import java.util.List;

public class GenericProgramming {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add(100);
        arrayList.add("1999");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
            System.out.println(arrayList.get(i).getClass());
        }

        ArrayList<String> stringArrayList = new ArrayList<String>();
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        System.out.println(stringArrayList.getClass());
        System.out.println(integerArrayList.getClass());

        Generic<Integer> integerGeneric = new Generic<Integer>(100);
        Generic<String> stringGeneric = new Generic<String>("test");

        Generic<Ele> eleGeneric = new Generic<Ele>(new Ele());

        System.out.println(integerGeneric.getClass());
        System.out.println(stringGeneric.getClass());

        System.out.println(integerGeneric.getKey().getClass());
        System.out.println(stringGeneric.getKey().getClass());

        System.out.println(eleGeneric.getKey().getClass());


        AppleGeneric appleGeneric = new AppleGeneric();
        System.out.println(appleGeneric.next());


        FruitGeneric<String> stringFruitGeneric = new FruitGeneric<String>();
        stringFruitGeneric.setKey("stringFruitGeneric");
        System.out.println(stringFruitGeneric.next());

        System.out.println("test ? T");

        Generic<?> generic = new Generic<Integer>(1);
        generic = new Generic<String>("1");

        Generic<String> generic1 = new Generic<String>("1");

    }
}

@Data
class Generic<T> {
    private T key;

    public Generic(T key) {
        this.key = key;
    }
}

@Data
class Ele{

}

interface GenericInterface<T>{
    public T next();
}

@Data
class FruitGeneric<T> implements GenericInterface<T>{
    private T key;
    @Override
    public T next(){
        return key;
    }

}

class AppleGeneric implements GenericInterface<String>{

    @Override
    public String next(){
        return "AppleGeneric";
    }
}