package stack;

import java.util.Stack;

public class DeleteMiddleStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        new DeleteMiddleStack().deleteMid(st, 5);
    }

    public void deleteMid(Stack<Integer> s, int size){
        // code here
        int mid = 1;
        if (size % 2 == 0) {
            mid = size/2;
        } else {
            mid = (size + 1) / 2;
        }

        deleteAtPosition(s, size, mid);
    }

    void deleteAtPosition(Stack<Integer> s, int size, int mid) {
        if (size == mid) {
            s.pop();
            return;
        }

        int num = s.pop();
        deleteAtPosition(s, size - 1, mid);
        s.push(num);
    }
}
