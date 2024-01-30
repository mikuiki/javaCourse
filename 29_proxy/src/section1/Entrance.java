package section1;

class Utils {
    A a;

    void abc(){
        System.out.println("JAVA");
        a.test();
    }
}

class Entrance {
    public static void main(String[] args){
        C c=new C();
        Utils utils=new Utils();
        utils.a=c;
        utils.abc();
        
        B b = new B();
        utils.a = b;
        utils.abc();
    }

}
