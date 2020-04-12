package thinking_in_java.aop.sub.puc.claz;

import thinking_in_java.aop.sub.puc.claz.duck.Duck;
import thinking_in_java.aop.sub.puc.claz.duck.LittleDuck;
import thinking_in_java.aop.sub.puc.claz.fish.Fish;

public class DuckFish implements Duck,Fish {
    @Override
    public void swimming() {
        System.out.println("DuckFish  swimming!");
    }

    @Override
    public void eat() {
        Duck.super.eat();
    }

    @Override
    public void drink() {
        Fish.super.drink();
    }
}
