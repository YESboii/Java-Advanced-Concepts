package proxy.framework;

import proxy.app.CustomerService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Context {
    public static void main(String[] args) {
        try {
            //A proxy.framework might scan packages instead of this and then create beans for those and inject them..
            Class c1 = Class.forName("proxy.app.DefaultCustomerServiceImpl");
            Object service = null;
            if(c1.isAnnotationPresent(Component.class)){
                Constructor constructor = c1.getDeclaredConstructor();
                service = constructor.newInstance();
                Method [] methods = c1.getMethods();
                for(Method m : methods){
                    if (m.isAnnotationPresent(Transactional.class)){
                        //generally this will be Injected in some other bean managed by the context.....
                        //and when the method annotated with the transactional is called the proxy is called.
                        service =(CustomerService) Proxy.newProxyInstance(Context.class.getClassLoader()

                        ,new Class[]{CustomerService.class},new TransactionalAdvice(service));
                    }
                }
                //mocking the call of the method
                CustomerService service1 = (CustomerService) service;
//                service1.saveAndUploadImage("Product A");
                service1.readAll();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
