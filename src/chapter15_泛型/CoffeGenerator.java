package chapter15_泛型;


import util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by zhangll on 2018/7/16.
 */
public class CoffeGenerator implements Generator<Coffee>, Iterable<Coffee>{

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class,
        Americano.class, Breve.class};

    private static Random rand = new Random(47);

    private int size;

    public CoffeGenerator(int size) {
        this.size = size;
    }

    public CoffeGenerator() {
        this.size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee>{
        int count = size;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         *
         */
        @Override
        public Coffee next() {
            count--;
            return CoffeGenerator.this.next();
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        CoffeGenerator gen = new CoffeGenerator(10);
        for (Coffee c: gen) {
            System.out.println(c);
        }
    }


}

class Coffee{
    public static long counter = 0;
    public long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Latte extends Coffee{}

class Mocha extends Coffee{}

class Cappuccino extends Coffee{}

class Americano extends Coffee{}

class Breve extends Coffee{}



