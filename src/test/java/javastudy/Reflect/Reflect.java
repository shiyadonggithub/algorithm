package javastudy.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Class.forName("javastudy.Reflect.Person");
        Object object = clazz.getConstructor().newInstance();
        System.out.println(object);

        Field[] fields = clazz.getDeclaredFields();
        for(Field f:fields){
            System.out.println(f);
        }

        Field[] fields2 = clazz.getFields();
        for(Field f:fields2){
            System.out.println(f);
        }


        Field f = clazz.getDeclaredField("age");
        f.setAccessible(true);
        f.set(object, 123);
        System.out.println(object);


        Method[] methods = clazz.getDeclaredMethods();
        for(Method method:methods){
            System.out.println(method);
        }

        Method method1 = clazz.getMethod("setAge", int.class);
        method1.invoke(object,122);
        Method method = clazz.getMethod("getAge");
        System.out.println(method.invoke(object));
    }
}

class Person {
    public String name;

    private int age;

    public Person() {
        this.name = "yadongshi";
        this.age = 26;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}