

/**
 * 泛型方法 （通用类型）
 *
 * 1、为什么要引入泛型？
 * 例如： 实现一个冒泡排序（我们之前只能排序 int[] 数组）
 * 现在想冒泡排序 （ double类型  Student 类型）
 * 我们不可能每个类型写一个冒泡排序，所以我们抽取出不变的部分，把变化的部分独立
 * 在冒泡排序中，只有类型在变化，其他的不变
 * 所以，泛型（通用类型 - 类型做变量） 为此而生
 *
 * 2、语法规则：
 * （1）定义普通方法：
 * public static 返回值类型 方法名称（形参列表）{...}
 * （2）定义泛型方法：
 * public static <类型变量> 返回值类型 方法名称（形参列表） {.....}
 */

import java.util.Arrays;
import java.util.Comparator;

public class GenericMethodDemo {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public static <S> void bubbleSort(S[] array, Comparator<S> comparator) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length; j++) {
                // S 实践上是什么类型 （引用）
                int r = comparator.compare(array[i],array[j]);
                // 代表 array[i]指向的对象 大于 array[j]指向的对象
                if(r > 0) {
                    S s = array[j];
                    array[j] = array[i];
                    array[i] = s;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] array = {1,9,3,7,7,7,12,4};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

        Student2[] students = {
                new Student2("乔邦朔",21,180,80),
                new Student2("马乐",20,174,65)
        };
        System.out.println(students); // 错误的，打印不出预期的效果
        System.out.println("排序之前");
        System.out.println(Arrays.toString(students));

        Comparator<Student2> byHeight = new ByHeightComparator();
        Comparator<Student2> byWeight = new ByWeightComparator();

        // 完整写法：
        //GenericMethodDemo.<Student>bubbleSort(students,byHeight);
        // 编译器有能力算出来，这里的S就是Student 类型（省略）
        bubbleSort(students,byWeight);
        bubbleSort(students,byHeight);

        bubbleSort(students, new Comparator<Student2>() {
            @Override
            public int compare(Student2 student2, Student2 t1) {
                if (student2.age != t1.age) {
                    // 年龄不同，按年龄排
                    return student2.age - t1.age;
                } else {
                    // 年龄相同，按身高排
                    return student2.height - t1.height;
                }
            }
        });
        System.out.println("优先按年龄排，年龄相同按身高排");
        System.out.println(Arrays.toString(students));

    }

}

