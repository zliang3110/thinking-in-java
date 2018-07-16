package chapter15_泛型;

import java.util.Iterator;

/**
 * Created by zhangll on 2018/7/16.
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{

    private int count = 0;

    public IterableFibonacci(int count) {
        this.count = count;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Integer next() {
                count--;
                return IterableFibonacci.this.next();
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
        };
    }

    public static void main(String[] args) {
        for (Integer i : new IterableFibonacci(20)
             ) {
            System.out.print(i+" ");
        }
    }
}
