package q1_static_proxy;

public class Entrance {
    public static void main(String[] args){
        OuterClass.InnerClass innerClass=new OuterClass().new InnerClass();
        //TODO
        Utils utils = new Utils();
        utils.a = innerClass; 
        utils.test();

    }
}


// 构建代理类，实现同一接口
class Utils implements A{
	OuterClass.InnerClass a;
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("A1 Test Before");
		a.testInner();
	}
}