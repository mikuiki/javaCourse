package section2;

class Utils implements A{
    A a;

    @Override
    public void test() {
        System.out.println("JAVA");
        a.test();

    }


}
//utils叫做代理类Utils的一个代理对象
//c其实叫做被代理对象

class Entrance {
   public static void main(String[] args){

       C c=new C();
       B b = new B();
       Utils utils=new Utils();
       utils.a=b;

       utils.test();


   }

}
