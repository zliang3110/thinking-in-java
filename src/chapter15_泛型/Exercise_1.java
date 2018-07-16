package chapter15_泛型;

/**
 * Created by 2018年7月8日12:37:22
 * 15.2练习1
 *
 * 如果某个类持有基类类型，那么他也能持有导出类型
 */
public class Exercise_1<T>{
    T clazz;

    Exercise_1(T clazz){
        this.clazz = clazz;
    }

    public T getClazz() {
        return clazz;
    }

    public static void main(String[] args) {

        Exercise_1<Pet> petHolder = new Exercise_1<Pet>(new Dog());

        Pet pet = petHolder.getClazz();

        pet.Walk();


    }

}


class Pet{
    public void Walk(){
        System.out.println("Pets walk");
    }
}

class Dog extends Pet{
    @Override
    public void Walk() {
        System.out.print("Dog walk");
    }
}
