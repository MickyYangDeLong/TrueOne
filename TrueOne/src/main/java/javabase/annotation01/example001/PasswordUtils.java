package javabase.annotation01.example001;

public class PasswordUtils {

    @UseCase(id=48,description = "sfsdfgfsf")
    public boolean validatePassWordww(String password){
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id=49,description = "sfsdfsf")
    public boolean validatePassWordwww(String password){
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id=47,description = "sfsfsf")
    public boolean validatePassWord(String password){
        return password.matches("\\w*\\d\\w*");
    }


}
