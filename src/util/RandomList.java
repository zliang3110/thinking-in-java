package util;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zhangll on 2018/7/16.
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random();

    public void add(T item){
        storage.add(item);
    }

    public T select(){
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for(String str : "Hello World !".split(" ")){
            rs.add(str);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(rs.select());
        }

    }
}

