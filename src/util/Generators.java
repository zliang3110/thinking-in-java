package util;

import chapter15_泛型.CoffeGenerator;
import chapter15_泛型.Fibonacci;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by zhangll on 2018/7/16.
 *
 * generator的泛化方法
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> col,
                                         Generator<T> gen,
                                         int n){

        for (int i = 0; i < n; i++) {
            col.add(gen.next());
        }

        return col;
    }

    public static <T> List<T> fill(List<T> list,
                                   Generator<T> gen,
                                   int n){
        System.out.println("List");
        for (int i = 0; i < n; i++) {
            list.add(gen.next());
        }

        return list;
    }

    public static void main(String[] args) {
        String clazz = Generators.fill(new ArrayList<Integer>(), new Fibonacci(),10).getClass().getSimpleName();
        System.out.println(clazz);
    }

}
