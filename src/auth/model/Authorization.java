package auth.model;

import code.model.ICode;

/**
 * Created by Alexandr on 8/18/2015.
 */
public class Authorization implements IAuthorizable {
    private boolean isAuth = false;

    private ICode code;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCode(ICode code) {
        this.code = code;
    }

    public boolean authorize(){
        if(code.decodePassword().equalsIgnoreCase(password)) {
            isAuth = true;
            System.out.println("Welcome!");
            return true;
        }

        isAuth = false;
        return false;
    }

    public void method1(){
        System.out.println("method 1");
    }
    public void method2(){
        System.out.println("method 2");
    }
    public void method3(){
        System.out.println("method 3");
    }
    public void method4(){
        System.out.println("method 4");
    }

    @Override
    public boolean isAuthorize() {
        return isAuth;
    }
}