package 队列;

import java.util.NoSuchElementException;

public interface Queue {

    // 1、这组方法通过特殊的返回值，通知错误

    // 插入
    // true 插入成功，false 失败（例如容量满了）
    boolean offer(Integer e);

    // 看队首元素，但不删除
    // 返回 null ，代表队列是空的
    Integer peek();

    // 返回并删除队首元素
    Integer poll();

    // 2、这组方法通过抛出异常，通知错误

    // 插入
    // 永远返回 true
    default boolean add(Integer e){
        if (offer(e) == false) {
            throw new IllegalStateException();
        }
        return true;
    }

    // 看队首元素，但不删除
    default Integer element() {
        Integer e = peek();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    // 返回并删除队首元素
    default Integer remove(){
        Integer e = poll();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }



}

