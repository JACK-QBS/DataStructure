
/**
 * 包装类： 总有一些地方，必须用到对象，但8种基本数据类型作为特例，总是显得格格不入
 *          java为每种基本数据类型一一对应了一个类，由该类将基本数据类型包装起来
 *
 *  int(Integer)、char(Character)
 *  byte(Byte)、short(Short)、long(Long)、float(Float)、double(Double)、boolean(Boolean)
 *
 *  使用包装类： 以 int 和 Integer 为例：
 *  1、可以将 int 类型变成 Integer 类型 -- 装箱
 *  int a = 100;
 *  Integer aBox = new Integer(a);
 *  a = 200;
 *  一旦装箱完成，和原来的a 就没关系了
 * 2、
 */


public class PackagingClass {
    public static void method(Integer i) {
    }
    public static void main(String[] args) {
        int a = 100;
        System.out.println(a);
        Integer aBox = new Integer(a);
        System.out.println(aBox);
        a = 200;
        System.out.println(a);
        System.out.println(aBox);

        // 自动装箱 auto boxing
        Integer aBox2 = a; // 隐含着一个装箱 aBox2 = new Integer(a);
        method(a); // method(new Integer(a));

        Integer b = 100;
        Integer c = 200;
        if(b == c) {} // b c 是否指向同一个对象
        if(b.equals(c)){} // b c 指向对象的内容是否相同

        System.out.println(Integer.valueOf("1024"));
        System.out.println(Integer.valueOf("20", 8));
        System.out.println(Integer.valueOf("FF", 16));

        System.out.println(Long.toHexString(19)); // 16 进制
        System.out.println(Long.toOctalString(19)); // 8 进制


    }


}
