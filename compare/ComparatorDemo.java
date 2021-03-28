package List;

import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        Student2 s1 = new Student2("qbs",22,178,78);
        Student2 s2 = new Student2("ml",21,172,65);

        //构造比较器
        ByHeightComparator byHeight = new ByHeightComparator();
        ByWeightComparator byWeight = new ByWeightComparator();

        int r;
        //按照 年龄 比较
        r = s1.compareTo(s2);
        System.out.println(r);
        //按照 身高 比较
        r = byHeight.compare(s1,s2);
        System.out.println(r);
        //按照 体重 比较
        r = byWeight.compare(s1,s2);
        System.out.println(r);
    }
}

class ByHeightComparator implements Comparator<Student2> {
    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o1.height - o2.height;
    }
}

class ByWeightComparator implements Comparator<Student2> {
    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o1.weight - o2.weight;
    }
}
