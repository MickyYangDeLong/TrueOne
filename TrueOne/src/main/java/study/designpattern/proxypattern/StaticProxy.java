package study.designpattern.proxypattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticProxy {
    public static void main(String[] args) {
        Action subjectProxy = new StaticProxy().new SubjectProxy(new StaticProxy().new Subject());
        subjectProxy.mainAction();
    }

    interface Action{
       void mainAction();
    }

    class Subject implements Action{
        @Override
        public void mainAction() {
            log.info("it is Subject Action!");
        }
    }

    class SubjectProxy implements Action{

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
