package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 1.在切面中，需要通过指定的注解将方法标识为通知方法
 *
 * @Before:前置通知，在目标对象方法执行之前执行
 * @After:后置通知，在目标对象方法的finally子句中执行的
 * @AfterReturning：返回通知，在目标对象返回值之后执行
 * @AfterThrowing:异常通知，在目标对象的catch字句中执行
 *
 *
 * 2.切入点表达式:设置在标识通知的注解的value属性中
 * execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int,int )
 * execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))
 * 第一个*表示任意的访问修饰符和返回类型
 * 第二个*表示类中任意的方法
 * ..任意的参数列表
 * 类的地方也可以使用*，表示包下所有的类
 *
 *
 *
 * 3.重用切入点表达式
 * //@Pointcut声明一个公点的切入点表达式
 * @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
 * public void pointCut() {}
 * 使用方法:@Before("pointCut()")
 *
 * 4.获取连接点的信息
 * 在通知方法的信息，设置JoinPoint类型的参数，就可以获取连接点所对应方法的信息
 * //获取连接点所对应方法的签名信息
 * Signature signature=joinPoint.getSignature();
 * //获取连接点所对应方法的参数
 * Object[] args = joinPoint.getArgs();
 *
 *
 * 5.切面的优先级
 * 可以通过@order注解的value属性设置优先级，默认值Integer的最大值
 * @order注解的value属性值越小，优先级越高
 */
//AOP 抽横切关注点（非核心业务代码）封装到切面中，封装为一个通知方法，再把通知方法通过切入点表达式作用到连接点上

@Component
@Aspect//将当前组件标识为切面
public class LoggerAspect {

    @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    //@Before("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int,int ))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法:" + signature.getName() + ",参数:" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:"+signature.getName()+",执行完毕");
    }
    /**
     * 在返回通知中若要获取目标对象方法的返回值，
     * 只需要通过@AfterReturning注解的returning属性
     * 就可以将通知方法的某个参数指定为接受目标对象方法的返回值的参数
     */

    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:"+signature.getName()+"结果:"+result);
    }

    /**
     * 在一异常通知中若要获取目标对象方法的异常，
     * 只需要通过@AfterThrowing注解的Throwing属性
     * 就可以将通知方法的某个参数指定为接受目标对象方法的出现的异常的参数
     */

    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:"+signature.getName()+",异常:"+ex);

    }

    @Around("pointCut()")
    //环绕通知的方法的返回值一定要和目标对象方法的返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result =null;
        try {
            System.out.println("环绕通知-->前置通知");
            //表示目标对象方法的执行
            result=joinPoint.proceed();
            System.out.println("环绕通知-->返回通知"+joinPoint.getSignature().getName());
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        }finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }

}
