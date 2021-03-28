package test;

public class Person<T> {
    public String name;
    public int age;
    public T es;

    public Person(String name, int age, T es) {
        this.name = name;
        this.age = age;
        this.es = es;
    }

    public static void main(String[] args) {
        Person<String> p1 = new Person<>("Student",18,"String");
        //  Person<Student> p2 = new Person<>("Student",20,new Student());
    }
}
