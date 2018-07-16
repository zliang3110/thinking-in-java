package chapter15_泛型;

import java.text.MessageFormat;

/**
 * Created by 2018年7月8日12:50:53
 *
 * 创建一个holder类，使其能够持有具有相同类型的3个对象，并提供相应的读写方法访问这些对象，
 * 以及一个可以初始化其持有的3个对象的构造器
 */
public class Exercise_2 {

    public static void main(String[] args) {
        Holder<String,Integer,Boolean> holder = new Holder<>("123",1,true);

        System.out.println(MessageFormat.format("String -> {0}, Integer -> {1}, Boolean -> {2}",
                holder.getVal1(),holder.getVal2(),holder.getVal3()));

    }
}


class Holder<K,V,M>{
    K val1;
    V val2;
    M val3;

    public Holder(K val1, V val2, M val3) {
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
    }

    public K getVal1() {
        return val1;
    }

    public V getVal2() {
        return val2;
    }

    public M getVal3() {
        return val3;
    }

    public void setVal1(K val1) {
        this.val1 = val1;
    }

    public void setVal2(V val2) {
        this.val2 = val2;
    }

    public void setVal3(M val3) {
        this.val3 = val3;
    }
}
