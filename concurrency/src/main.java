public class main {
    public static void main(String[] args) {
        A c1 = new B();
        Class<?> c = c1.getClass();
        System.out.println(c1);
        System.out.println(C.class.isAssignableFrom(c));
    }
}
class A{}
class B extends A{
}
class C extends A{}