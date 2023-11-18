package stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        new ReverseStack().reverse(st);
        System.out.println(st);
    }

    void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int num = s.pop();
        reverse(s);

        addAtStart(s, num);
    }

    void addAtStart(Stack<Integer> s, Integer num) {
        if (s.isEmpty()) {
            s.push(num);
        } else {

            Integer n = s.pop();
            addAtStart(s, num);

            s.push(n);
        }
    }
}
