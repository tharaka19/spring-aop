package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp){
        System.out.println(jp.getSignature());
        System.out.println("Before Loggers with Argument: " + jp.getArgs()[0].toString());
    }

    @After("execution(* *.*.checkout(..))")
    public void afterLogger(){
        System.out.println("After Loggers");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCart(){}

    @AfterReturning(pointcut = "afterReturningPointCart()", returning = "returnValue")
    public void afterReturning(String returnValue){
        System.out.println("After Returning: " + returnValue);
    }
}
