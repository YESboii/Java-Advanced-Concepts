
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class DemoException1 extends Exception{
    DemoException1(){
        super("exp1");
    }
}
class DemoException2 extends DemoException1{
    DemoException2(){
        super();
    }
}
class DemoException3 extends RuntimeException{
    DemoException3(){
        super("exp2");
    }
}
class A{
    void a () throws DemoException1{}
}
class B extends A{

    @Override
    void a () throws DemoException2 {} // While overriding The same or less number of exceptions(or its subclass) defined in the parent class along with runtime exceptions. No other type of exceptions are allowed 
}
    
class Demo {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
    }
}