package thinking_in_java.aop.sub.puc.claz.fish;
    /***
     *
     * 由于java支持一个实现类可以实现多个接口，
     * 如果多个接口中存在同样的static和default方法会怎么样呢？
     * 如果有两个接口中的静态方法一模一样，并且一个实现类同时实现了这两个接口，
     * 此时并不会产生错误，因为jdk8只能通过接口类调用接口中的静态方法，
     * 所以对编译器来说是可以区分的。但是如果两个接口中定义了一模一样的默认方法，
     * 并且一个实现类同时实现了这两个接口，
     * 那么必须在实现类中重写默认方法，即,将两种默认方法归并为一个.否则编译失败
     *
     * */

public interface Fish {

    void swimming();
    default void eat(){
        System.out.println("fish is eating!");
    }
    default void drink(){
        System.out.println("fish is drinking!");
    }

}
