package study.designpattern.proxypattern;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
/**
 *  https://www.jb51.net/article/120309.html
 *  cglib可以代理类
 */
public class CglibProxy {
    //TODO
    static class ConcreteClassNoInterface {
        public String getConcreteMethodA(String str){
            System.out.println("ConcreteMethod A ... "+str);
            return str;
        }
        public int getConcreteMethodB(int n){
            System.out.println("ConcreteMethod B ... "+n);
            return n+10;
        }
    }

    static class ConcreteClassInterceptor implements MethodInterceptor {
        public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
            System.out.println("Before:"+method);
            Object object=proxy.invokeSuper(obj, arg);
            System.out.println("After:"+method);
            return object;
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(ConcreteClassNoInterface.class);
        enhancer.setCallback(new ConcreteClassInterceptor());
        ConcreteClassNoInterface ccni=(ConcreteClassNoInterface)enhancer.create();
        ccni.getConcreteMethodA("shensy");
        ccni.getConcreteMethodB(0);
    }
}
