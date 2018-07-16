package util;

/**
 * Created by zhangll on 2018/7/16.
 */
public class LinkedStack <T>{
    public static class Node<T>{
        T item;
        Node<T> next;

        public Node() {
            this.item = null;
            this.next = null;
        }

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        public boolean end(){
            return this.next == null && this.item == null;
        }
    }

    private Node<T> top = new Node<>();

    public void push(T item){
        top = new Node<T>(item, top);
    }

    public T pop(){
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }

        return result;
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop()); // 4
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
        System.out.println(stack.pop()); // null
    }
}
