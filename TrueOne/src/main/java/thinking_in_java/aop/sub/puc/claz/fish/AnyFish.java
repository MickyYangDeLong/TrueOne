package thinking_in_java.aop.sub.puc.claz.fish;

public class AnyFish extends LittleFish implements Fish{
    @Override
    public void swimming() {
        System.out.println("any fish swimming!");
    }

    @Override
    public void eat() {
        System.out.println("any fish eat!");

    }

    @Override
    public void drink() {
        System.out.println("any fish drink!");

    }
}
