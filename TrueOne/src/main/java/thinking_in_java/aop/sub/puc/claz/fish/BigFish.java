package thinking_in_java.aop.sub.puc.claz.fish;

public class BigFish implements Fish{
    @Override
    public void swimming() {
        System.out.println("big fish swimming!");
    }

    @Override
    public void eat() {
        System.out.println("big fish eat!");

    }

    @Override
    public void drink() {
        System.out.println("big fish drink!");

    }
}
