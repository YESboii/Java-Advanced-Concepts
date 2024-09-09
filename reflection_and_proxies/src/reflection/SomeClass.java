package reflection;

import java.lang.reflect.Constructor;
class p{
    public int x;
    p(int x){
        this.x = x;
    }
}
public class SomeClass extends p{





    public void setX(int x) {
        this.x = x;
    }
    public static void method(){
        System.out.println("static");
    }
    static void mmm(){

    }
    public int getX() {
        return x;
    }

    private SomeClass(int x){
        super(x);
    }


}
