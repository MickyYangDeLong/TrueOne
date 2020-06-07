package study.jvm;

import sun.misc.Launcher;
import sun.util.calendar.ZoneInfo;

public class TestClassLoder {
    public static void main(String[] args) {

        System.out.println(TestClassLoder.class.getClassLoader());
        System.out.println(Object.class.getClassLoader());
        System.out.println(Integer.class.getClassLoader());
        TestClassLoder test = new TestClassLoder();
        System.out.println(test.getClass().getClassLoader());
        System.out.println(Launcher.class.getClassLoader());
        System.out.println(ZoneInfo.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        System.out.println("----");
        test.getClass().equals(new Object());
        try {
            Class s = test.getClass().getClassLoader().loadClass("java.lang.String");
            System.out.println(s);
            Class ss = test.getClass().getClassLoader().getParent().loadClass("java.lang.String");
            System.out.println(ss);
            System.out.println(s.equals(ss));
            System.out.println(s.getClassLoader());
            System.out.println(ss.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Created by zejian on 2017/6/18.
     * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
     *//*
//自定义ClassLoader，完整代码稍后分析
    class FileClassLoader extends  ClassLoader{
        private String rootDir;

        public FileClassLoader(String rootDir) {
            this.rootDir = rootDir;
        }
        // 编写获取类的字节码并创建class对象的逻辑
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            //...省略逻辑代码
        }
        //编写读取字节流的方法
        private byte[] getClassData(String className) {
            // 读取类文件的字节
            //省略代码....
        }
    }

     class ClassLoaderTest {

        public void main(String[] args) throws ClassNotFoundException {

            FileClassLoader loader1 = new FileClassLoader(rootDir);

            System.out.println("自定义类加载器的父加载器: "+loader1.getParent());
            System.out.println("系统默认的AppClassLoader: "+ClassLoader.getSystemClassLoader());
            System.out.println("AppClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent());
            System.out.println("ExtClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent().getParent());

            *//**
             输出结果:
             自定义类加载器的父加载器: sun.misc.Launcher$AppClassLoader@29453f44
             系统默认的AppClassLoader: sun.misc.Launcher$AppClassLoader@29453f44
             AppClassLoader的父类加载器: sun.misc.Launcher$ExtClassLoader@6f94fa3e
             ExtClassLoader的父类加载器: null
             *//*

        }
    }*/


}
