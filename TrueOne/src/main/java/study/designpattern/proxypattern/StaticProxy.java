package study.designpattern.proxypattern;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 由以上代码可以看出，客户实际需要调用的是RealSubject类的request方法，现在用ProxySubject来代理RealSubject类，同样达到目的，同时还封装了其他方法(preRequest、postRequest)可以处理一些其他问题
 * 另外，如果要按照上述的方法使用代理模式，那么真实角色必须是事先存在的，并将其作为代理对象的内部属性，但是实际使用时，一个真实角色它必须对立一个代理角色，如果大量使用会导致类的急剧膨胀，这个问题可以通过java的动态代理类是解决
 * 链接：https://www.jianshu.com/p/41f28d7ef6f1
 * 来源：简书
 */

@Slf4j
public class StaticProxy {
    public static void main(String[] args) {
        Action subjectProxy = new SubjectProxy(new Subject());
        subjectProxy.mainAction();
    }

    interface Action{
       void mainAction();
    }

   static class Subject implements Action{
        @Override
        public void mainAction() {
            log.info("it is Subject Action!");
        }
    }

    static class SubjectProxy implements Action{

        private Action target;

        public SubjectProxy (){}
        public SubjectProxy (Action target){
            this.target = target;
        }
        @Override
        public void mainAction() {
            preAction();
            try {
                target.mainAction();
            }catch (Exception e){
                log.error("Exception  SubjectProxy Action!");
                exceptionAction();
            }
            afterAction();
        }

        private void preAction() {
            log.info("pre action SubjectProxy");
        }

        private void exceptionAction() {
            log.info("exceptionAction SubjectProxy");
        }

        private void afterAction() {
            log.info("afterAction SubjectProxy");
        }
    }
}
