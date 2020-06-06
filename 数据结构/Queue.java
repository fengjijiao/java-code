package test8;

import java.util.ArrayList;

public class Queue {
    ArrayList<Object> queue;

    public Queue() {
        this.queue = new ArrayList<>();
    }

    public Object getQueueHead() {
        if(queue.size() == 0) return null;
        return queue.get(0);
    }

    public Object getQueueTail() {
        if(queue.size() == 0) return null;
        return queue.get(queue.size()-1);
    }

    public void push(Object obj) {
        queue.add(obj);
    }

    public Object pop() {
        if(queue.size() == 0) return null;
        Object obj = getQueueHead();
        queue.remove(0);
        return obj;
    }

    public String getAllElement() {
        return queue.toString();
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public int getQueueSize() {
        return queue.size();
    }
}
