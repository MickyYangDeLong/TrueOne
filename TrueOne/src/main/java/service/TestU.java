package service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.impl.ConfigTest;
import service.impl.JackFamilyTree;
import service.impl.MickyFamilyTree;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigTest.class)
public class TestU {

    @Autowired
    private JackFamilyTree jackFamilyTree;

    @Autowired
    private MickyFamilyTree mickyFamilyTree;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testUit(){
        Assert.assertNotNull(jackFamilyTree);
        Assert.assertNotNull(mickyFamilyTree);
    }

    @Test
    public void goHome(){
        jackFamilyTree.setRealName("jack");
        System.out.println(jackFamilyTree);
        System.out.println("============");
        jackFamilyTree.born();
        System.out.println("============");
        jackFamilyTree.leave();
        System.out.println("============");
        jackFamilyTree.goHome();
        System.out.println("============");
        jackFamilyTree.dead();
        System.out.println("============");
        System.out.println(jackFamilyTree.description());
    }

}
