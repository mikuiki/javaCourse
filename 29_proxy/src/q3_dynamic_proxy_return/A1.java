package q3_dynamic_proxy_return;

public class A1 implements A{
    @Override
    public int test() {
        System.out.println("A1 Test");
        return 100;
    }
}
