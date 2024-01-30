package section3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class Entrance{
    public static void main(String[] args){
        Student student=new Student();
        A a=new A();
        a.object=student;
        Person p=(Person) Proxy.newProxyInstance(student.getClass().getClassLoader(),student.getClass().getInterfaces(),a);
        p.test();
    }
}

class A implements InvocationHandler {
    Object object;
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("java前-->");
        method.invoke(object,objects);
        System.out.println("java后-->");
        return null;
    }
}