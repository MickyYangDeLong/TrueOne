package study.designpattern.proxypattern;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *只能代理接口
 */

@Slf4j
public class DynamicProxy {
    public static void main(String[] args) {
        Action subjectProxy = (Action)Proxy.newProxyInstance(Subject.class.getClassLoader(),Subject.class.getInterfaces(),new SubjectProxyHandler(new Subject()));
        subjectProxy.mainAction001();
        subjectProxy.mainAction002();
        subjectProxy.mainAction003();
        subjectProxy.mainAction004();
        try {
            subjectProxy.mainAction005();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static Map<String,String> map = new HashMap<String,String>(){{
        put("mainAction001","is is mainAction001!");
        put("mainAction002","is is mainAction002!");
        put("mainAction003","is is mainAction003!");
        put("mainAction004","is is mainAction004!");
        put("mainAction005","is is mainAction005!");
    }};

    interface Action{
        void mainAction001();
        void mainAction002();
        void mainAction003();
        void mainAction004();
        void mainAction005() throws Exception;
    }

    static class Subject implements Action {

        @Override
        public void mainAction001() {
            log.info("Subject => mainAction001");
        }

        @Override
        public void mainAction002() {
            log.info("Subject => mainAction002");

        }

        @Override
        public void mainAction003() {
            log.info("Subject => mainAction003");

        }

        @Override
        public void mainAction004() {
            log.info("Subject => mainAction004");

        }

        @Override
        public void mainAction005() throws Exception{
            log.info("Subject => mainAction005");
            throw new Exception("005 exception!");

        }
    }

    static class SubjectProxyHandler implements InvocationHandler {

        private Object realSubject;

        public SubjectProxyHandler(Object realSubject) {
            this.realSubject = realSubject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
            final String description = map.get(method.getName());
            log.info("SubjectProxyHandler before =>method  {}()",description);
            try {
                method.invoke(realSubject,args);
            }catch (Exception e){
                log.error("SubjectProxyHandler => Exception  =>method  {}()",description);
            }
            log.info("SubjectProxyHandler after => method {}()",description);
            return null;
        }
    }


}
