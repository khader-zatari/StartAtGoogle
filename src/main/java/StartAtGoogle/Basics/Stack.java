package StartAtGoogle.Basics;

public class Stack {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s);
    }

    int[] arr = null;
    int top = 0;

    public Stack() {
        arr = new int[1];
    }

    public void push(int x) {


        if (top == this.arr.length) {

            int[] newArr = new int[top + 1];
            System.arraycopy(this.arr, 0, newArr, 0, this.arr.length);

            newArr[top] = x;
            this.arr = newArr;

        } else {
            arr[top] = x;
        }
        this.top++;


    }
    public int pop() {
        this.top -= 1;
        if (top < 0) {
            return -1;
        }
        return this.arr[this.top];

    }


    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.top; i++) {
            str += this.arr[i] + " ";

        }
        return str;

    }
}
