package test8;

import java.util.ArrayList;

public class Stack {
    ArrayList<Object> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public Object getStackTop() {
        if(stack.size() == 0) return null;
        return stack.get(stack.size()-1);
    }

    public void push(Object obj) {
        stack.add(obj);
    }

    public Object pop() {
        if(stack.size() == 0) return null;
        Object obj = getStackTop();
        stack.remove(stack.size()-1);
        return obj;
    }

    public void clear() {
        stack.clear();
    }

    public String getAllElement() {
        return stack.toString();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public int getStackSize() {
        return stack.size();
    }
}
