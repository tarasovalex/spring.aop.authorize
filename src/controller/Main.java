package controller;

import auth.model.Authorization;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by Alexandr on 8/18/2015.
 */
public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("spring-config.xml");
        Authorization authorization = (Authorization)context.getBean("authorization"); //http://stackoverflow.com/questions/16047829/proxy-cannot-be-cast-to-class?answertab=votes#tab-top

        authorization.setPassword("p@ssw0rd1");
        authorization.authorize();

        try {
            authorization.method4();
            authorization.method1();
            authorization.method2();
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

    }
}
