package excaption.model;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Alexandr on 8/18/2015.
 */
/*AOP Exception Handling*/
@Aspect
public class CatchException {
    @AfterThrowing(pointcut = "execution(* auth.model.Authorization* (..))", throwing = "ex")
    public void catchException(Throwable ex) {
        System.out.println("Catch Exception: " + ex.getMessage());
    }
}
