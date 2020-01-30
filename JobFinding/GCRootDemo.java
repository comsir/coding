package JobFinding;

/*
* 可作为GCroots 的对象：
*1.虚拟机栈（栈帧中的局部变量区，也叫做局部变量表）中引用的对象
*2.方法区中的类静态属性引用的对象
*3.方法区中常量引用的对象
*4.本地方法栈中JNI（Native方法）引用的对象
* */
public class GCRootDemo {

    private byte[] bytearray = new byte[100 * 1024 * 1024];//100M

//    private static GCRootDemo2 t2;//static 2.方法区中的类静态属性引用的对象 (静态的是只有一份 全部实例共用)
//    private static final GCRootDemo3 t3 = new GCRootDemo3(8);//3.方法区中常量引用的对象 （强引用）
    public static void m1() {
        GCRootDemo t1 = new GCRootDemo();//1.t1就是虚拟机栈（局部变量表中）中引用的对象
        System.gc();
        System.out.println("完成第一次GC");
    }
    public static void main(String[] args) {
        m1();
    }
}
