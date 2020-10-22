package exercises;

/**
 * 前置知识 相关习题：
 * 对象的比较 、 包装类的使用
 *
 */

public class preposition {

    /*public String name="abc";
    public static void main(String[] args){
        preposition test=new preposition();
        preposition testB=new preposition();
        System.out.println(test.equals(testB)+","+test.name.equals(testB.name));
    }*/

    public static void main(String[] args){
        Object o=new Object(){
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }

}
