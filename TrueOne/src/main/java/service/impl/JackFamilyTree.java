package service.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.interf.FamilyTreeRoot;

@Data
@Component("jackFamilyTree")
public class JackFamilyTree implements FamilyTreeRoot {

    private  String name;

    JackFamilyTree(){}
    JackFamilyTree(String name){
        this.name = name;
    }

    @Override
    public void goHome() {
        System.out.println(getRealName().concat("will be go home!"));
    }

    @Override
    public void leave() {
        System.out.println(getRealName().concat("will be leave home from 16!"));
    }

    @Override
    public void born() {
        System.out.println(getRealName().concat("born in 1990!"));
    }

    @Override
    public void dead() {
        System.out.println(getRealName().concat("will dead after 100 years later from now!"));

    }

    private String getRealName() {
        return FamilyTreeRoot.name(getName());
    }

    @Override
    public  void setRealName(String name){
        this.name = name;
    }

    @Autowired(required = false)
    public void setAttribute(String MickyFa){
        System.out.println(MickyFa);
        System.out.println("exe or not!");

    }
}
