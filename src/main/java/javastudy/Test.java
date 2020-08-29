package javastudy;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class Test {

    List<String> list;

    public static void main(String[] args) throws NoSuchFieldException {
//        List<String>  list = new ArrayList<String>();//这里后面加不加String都是一样的，编译时会自动擦除：
//        Class clazz = list.getClass();
//        Type genType = clazz.getGenericSuperclass();
//        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
//        list.add("123");
//        if (!(params[0] instanceof Class)) {
//            System.out.println("无法获得类型");
//        } else {
//            System.out.println(((Class) params[0]).getName());
//        }

        /* 通过反射在运行时动态获取List<t>中T的实际类型 */
        Type t = Test.class.getDeclaredField("list").getGenericType();
        if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
            for (Type t1 : ((ParameterizedType) t).getActualTypeArguments()) {
                System.out.print(t1);
            }
        }

    }

}