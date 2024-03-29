package thinking_in_java.jenerics_015;

/***
 *
 * 406 page
 *
 * 泛型：：自限定类型
 */


class SelfBounded<T extends SelfBounded<T>>{
    T element;
    SelfBounded<T>  set(T arg){
        element = arg;
        return  this;
    }

    T get(){
        return element;
    }
}

class A extends SelfBounded<A>{
}

class B extends  SelfBounded<A>{

}

class C extends  SelfBounded<C>{
    C setAndGet(C arg){
        set(arg);
        return get();
    }
}

class D {}

class F extends SelfBounded{}

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();

        C c = new C();
        c = c.setAndGet(new C());

    }

}