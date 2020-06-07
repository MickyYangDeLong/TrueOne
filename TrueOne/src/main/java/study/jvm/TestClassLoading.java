package study.jvm;

public class TestClassLoading {
    public static void main(String[] args) {

    }
}


interface A {
    int a=1;
}

interface B extends A {
    int a=2;
}

class C implements B{
    public C(int a){}
}

class D extends C{
    public D(){
        super(1);
    }
}
