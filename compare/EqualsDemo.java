package List;

import java.util.Objects;

public class EqualsDemo {
    public static void main(String[] args) {
        Student t1 = new Student("s1");
        Student t2 = new Student("s1");
        Student t3 = new Student("s2");
        Student t4 = new Student("s2");

        System.out.println(t1.equals(t2));
        System.out.println(t1.equals(t3));
    }
}
 class Student {
    String name;
    public Student(String name) {
        this.name = name;
    }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Student student = (Student) o;
         return Objects.equals(name, student.name);
     }
 }