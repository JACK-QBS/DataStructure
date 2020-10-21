

/**
 * 1、泛型本质是把类型提取成变量了
 * 2、分为泛型方法和泛型类（泛型类使用较多）
 * 3、泛型类/泛型方法 分为 定义 / 使用 阶段
 * 4、定义、使用、赋值 泛型变量
 *
 * 泛型本质上是利用 Object 类型的引用可以指向任意对象这一前提做到的！！
 * 隐含着，凡是泛型中的类型变量，一定都是引用数据类型（不能使用基本数据类型）
 *
 */


class Student3 {

}
class Student4 {

}

public class GenericMethod<S> { // 定义一个类型变量 S
    public String name;
    public int age;
    public S especial; // 把 S 当成一个类型去使用

    public GenericMethod(String name, int age, S especial) {
        this.name = name;
        this.age = age;
        this.especial = especial;
    }

    public static void main(String[] args) {
        GenericMethod<String> p1 = new GenericMethod<>("String",18,"String");
        GenericMethod<Student3> p3 = new GenericMethod<>("Student3",18,new Student3());
        GenericMethod<Student4> p4 = new GenericMethod<>("Student4",18,new Student4());
    }
}
