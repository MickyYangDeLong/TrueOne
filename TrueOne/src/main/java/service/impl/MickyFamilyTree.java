package service.impl;

import lombok.Data;
import org.springframework.stereotype.Service;
import service.interf.FamilyTreeRoot;

@Data
@Service
public class MickyFamilyTree implements FamilyTreeRoot {

    private  String name;

    MickyFamilyTree(){}
    MickyFamilyTree(String name){
        this.name = name;
    }

    @Override
    public void goHome() {
        System.out.println(getRealName().concat("will be go home!"));
    }

    @Override
    public void leave() {
        System.out.println(getRealName().concat("will be leave home from 18!"));
    }

    @Override
    public void born() {
        System.out.println(getRealName().concat("born in 1991!"));
    }

    @Override
    public void dead() {
        System.out.println(getRealName().concat("will dead after 70 years later from now!"));

    }

    private String getRealName() {
        return FamilyTreeRoot.name(getName());
    }

    @Override
    public void setRealName(String name){
        this.name = name;
    }
}
