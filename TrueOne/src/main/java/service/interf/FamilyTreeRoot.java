package service.interf;

public interface FamilyTreeRoot {

    /***/
    void goHome();

    /***/
    void leave();

    /***/
    void born();

    /***/
    void dead();

    default String description(){
        return  "this is family tree root!";
    }

    static String  name(String name){
        return  "My name is ".concat(name).concat(", ");
    }

    void setRealName(String name);

}
