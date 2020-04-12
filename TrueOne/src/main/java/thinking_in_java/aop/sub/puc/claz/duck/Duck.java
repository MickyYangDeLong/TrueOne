package thinking_in_java.aop.sub.puc.claz.duck;

public interface Duck {
    void swimming();
    default void eat(){
        System.out.println("Duck is eating!");
    }
    default void drink(){
        System.out.println("Duck is drinking!");
    }
}
