package q1_static_proxy;

public class OuterClass {
    A a=new A1();
    class InnerClass{
        void testInner(){
            a.test();
        }
    }
}
