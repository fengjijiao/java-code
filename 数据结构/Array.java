package test8;

import java.util.ArrayList;

public class Array {
    ArrayList<Object> array;

    public Array() {
        this.array = new ArrayList<>();
    }

    public Object get() {
        return get(0);
    }

    public Object get(int n) {
        if(array.size() == 0 || (array.size()-1) < n) return null;
        return array.get(n);
    }

    public void push(Object obj) {
        array.add(obj);
    }

    public void push(Object obj, int n) {
        array.add(n, obj);
    }

    public Object pop() {
        return pop(0);
    }

    public Object pop(int n) {
        if(array.size() == 0 || (array.size()-1) < n) return null;
        Object obj = get(n);
        array.remove(n);
        return obj;
    }

    public String getAllElement() {
        return array.toString();
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }

    public int getArraySize() {
        return array.size();
    }
}
