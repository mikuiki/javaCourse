package q5_CGLIB;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Entrance {

	public static void main(String[] args) {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Student.class);
		enhancer.setCallback(new MyMethodInterceptor());
		
		Student st = (Student)enhancer.create();
		st.test();
		
	}

}

class MyMethodInterceptor implements MethodInterceptor{
	
	@Override
	public Object intercept(Object obj, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
		
		// TODO Auto-generated method stub
		System.out.println("content before added");
		Object obj1= proxy.invokeSuper(obj, arg2);
		return obj1;
		
	}
}
