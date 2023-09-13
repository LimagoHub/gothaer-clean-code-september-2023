package de.gothaer.time;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

public class TimeMeasureDecorator implements java.lang.reflect.InvocationHandler {

    private Object obj;

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new TimeMeasureDecorator(obj));
    }

    private TimeMeasureDecorator(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args)
            throws Throwable
    {
        Instant start= null;
        Object result;
        try {
           start = Instant.now();
            result = m.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                    e.getMessage());
        } finally {
           Instant end = Instant.now();
            Duration duration = Duration.between(start,end);
            System.out.println("Duration = " + duration.toMillis());
        }
        return result;
    }
}