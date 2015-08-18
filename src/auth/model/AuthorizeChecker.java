package auth.model;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Alexandr on 8/18/2015.
 */
public class AuthorizeChecker {
    private String[] methods;
    private boolean flagMethods;

    public void setFlagMethods(boolean flagMethods) {
        this.flagMethods = flagMethods;
    }

    public void setMethods(String[] methods) {
        this.methods = methods;
    }

    public void checkAuthorization(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        String methodName = point.getSignature().getName();

        if(flagMethods && isInCheckList(methodName)) {
            IAuthorizable authObject = (IAuthorizable) point.getTarget();
            if(!authObject.isAuthorize()) throw new SecurityException(String.format("Not authorize %s()", methodName));
        }

        point.proceed(args);
     }

    private boolean isInCheckList(String methodName) {
        for (String method : methods) {
            if(method.equalsIgnoreCase(methodName)) return true;
        }
        return false;
    }
}
