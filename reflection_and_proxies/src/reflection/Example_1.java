package reflection;

import java.lang.reflect.*;

public class Example_1 {

    public static void main(String[] args) throws NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException, NoSuchFieldException {
        Class<SomeClass> c = SomeClass.class;
        Constructor<SomeClass> constructors = c.getDeclaredConstructor(int.class);
        constructors.setAccessible(true);
        SomeClass obj1 =  constructors.newInstance(10);
        Method []methods = c.getMethods();
        Method staticMethod = null;
        for (Method m : methods){
            int mod = m.getModifiers();
            if(Modifier.isStatic(mod) && Modifier.isPublic(mod)){
                staticMethod= m;
            }
            if(m.getName().equals("getX")){
                Object o = m.invoke(obj1);
                System.out.println(o);
            }
        }
        staticMethod.invoke(obj1);
        Field field = c.getField("x");
//        field.setAccessible(true);
        field.set(obj1,1000);
        System.out.println(obj1.getX());
    }
}
