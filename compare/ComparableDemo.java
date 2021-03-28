package List;

public class ComparableDemo {
    public static void main(String[] args) {
        Student2 s1 = new Student2("qbs",22,178,78);
        Student2 s2 = new Student2("ml",21,172,65);

        int i = s1.compareTo(s2);
        if (i < 0) {
            System.out.println("小于");
        } else if (i == 0) {
            System.out.println("等于");
        } else {
            System.out.println("大于");
        }
    }
}

// 在java中，要声明比较大小能力，需要实现 comparable 接口
class Student2 implements Comparable<Student2>{
    String name;
    int age;
    int height;
    int weight;

    public Student2(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    //指导 java，进行对象大小比较
    @Override
    public int compareTo(Student2 o) {
        if (this.age < o.age) {
            return -1;
        } else if (this.age == o.age) {
            return 0;
        } else {
            return 1;
        }
    }
}
