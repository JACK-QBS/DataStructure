import java.util.Comparator;

class Student2 implements Comparable<Student2> {
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

    @Override
    public int compareTo(Student2 student2) {
        // 通过比较年龄的大小来比较 两对象的大小
        if(this.age < student2.age) {
            // this 指向的对象 小于 o指向的对象
            return -1;
        } else if (this.age == student2.age){
            // this 指向的对象 等于 o指向的对象
            return 0;
        } else {
            // this 指向的对象 大于 o指向的对象
            return 1;
        }
    }
}

// 通过 身高 比较两对象的大小
class ByHeightComparator implements Comparator<Student2> {

    @Override
    public int compare(Student2 student2, Student2 t1) {
        return student2.height - t1.height;
    }
}

// 通过 体重 比较两对象的大小
class ByWeightComparator implements Comparator<Student2> {

    @Override
    public int compare(Student2 student2, Student2 t1) {
        return student2.weight - t1.weight;
    }
}


public class ComparableDemo {
    public static void main(String[] args) {
        Student2 s1 = new Student2("乔邦朔",21,180,80);
        Student2 s2 = new Student2("马乐",20,172,60);

        /*int r = s1.compareTo(s2);
        if(r < 0) {
            System.out.println("小于");
        } else if(r == 0) {
            System.out.println("等于");
        } else {
            System.out.println("大于");
        }*/

        // 构造两个比较器：
        Comparator<Student2> byHeight = new ByHeightComparator();
        Comparator<Student2> byWeight = new ByWeightComparator();
        int s;

        // 按照年龄比较
        s = s1.compareTo(s2);
        System.out.println(s);
        // 按照身高比较
        s = byHeight.compare(s1,s2);
        System.out.println(s);
        // 按照体重比较
        s = byWeight.compare(s1,s2);
        System.out.println(s);


    }

}
