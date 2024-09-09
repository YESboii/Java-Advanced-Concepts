package proxy.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class TransactionalAdvice implements InvocationHandler {

    private final Object target;

    public TransactionalAdvice(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.isAnnotationPresent(Transactional.class)) System.out.println("Starting Transaction.......");
        method.invoke(target,args);

        if(method.isAnnotationPresent(Transactional.class))
        System.out.println("Committing Transaction");
        return null;
    }
}
