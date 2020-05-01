package javabase.annotation01.example001;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class UseCaseTracker {
    public static void main(String[] args) {
        try {
            List<Integer> useCaseList = new ArrayList<Integer>(){{ add(47);add(48);add(49);add(50); }};
            UseCase useCase;
            for (Method method:PasswordUtils.class.getDeclaredMethods()){
                useCase = method.getAnnotation(UseCase.class);
                if (Objects.nonNull(useCase)){
                    System.out.println(useCase.id() + "======="+useCase.description());
                    useCaseList.remove(new Integer(useCase.id()));
                }
            }
            System.out.println("missed : === "+useCaseList);
        }catch (Exception e){
            log.error("exception happened!",e,e.getMessage());
        }
    }
}
