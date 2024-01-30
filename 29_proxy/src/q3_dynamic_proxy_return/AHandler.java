package q3_dynamic_proxy_return;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AHandler implements InvocationHandler {
     Object object;
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return null;
    }
}
