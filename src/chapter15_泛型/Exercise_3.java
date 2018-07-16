package chapter15_泛型;

import java.text.MessageFormat;

/**
 * Created by 2018年07月16日21:31:47
 * 使用泛型编写一个SixTuple类
 */
public class Exercise_3{

    public static void main(String[] args) {
        SixTuple<String,String,Integer,String,String,String> sixTuple =
                new SixTuple<>("123","456",1,"qwe","123","123");

        System.out.println(MessageFormat.format
                ("first->{1}, second->{2}, third->{3}, four->{4}, five->{5}, six->{6}",
                        sixTuple.first,
                        sixTuple.second,
                        sixTuple.third,
                        sixTuple.four,
                        sixTuple.five,
                        sixTuple.six));
    }

}

class TwoTuple<A,B>{
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }
}

class ThreeTuple<A,B,C> extends TwoTuple<A,B>{
    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }
}


class FourTuple<A,B,C,D> extends ThreeTuple{
    public final D four;

    public FourTuple(Object first, Object second, Object third, D four) {
        super(first, second, third);
        this.four = four;
    }
}

class FiveTuple<A,B,C,D,E> extends FourTuple{
    public final E five;

    public FiveTuple(Object first, Object second, Object third, Object four, E five) {
        super(first, second, third, four);
        this.five = five;
    }
}

class SixTuple<A,B,C,D,E,F> extends FiveTuple{
    public final F six;

    public SixTuple(Object first, Object second, Object third, Object four, Object five, F six) {
        super(first, second, third, four, five);
        this.six = six;
    }
}