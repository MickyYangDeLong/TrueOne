package study.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        //  FamilyTreeRoot p = ctx.getBean("chinese", MickyFamilyTree.class);
        FamilyTreeRoot p = ctx.getBean("jackFamilyTree", JackFamilyTree.class);
        p.setRealName("jack");
        logger.debug(p.toString());
        logger.debug("============");
        p.born();
        logger.debug("============");
        p.leave();
        logger.debug("============");
        p.goHome();
        logger.debug("============");
        p.dead();
        logger.debug("============");
        logger.debug(p.description());
    }
}
