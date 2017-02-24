package ctci.ch3_stacksqueues;

import other.Utilities;

public class ThreeInOne {

    private int [] arr;
    private int [] sizes;
    private int stackCap;
    private final int NUM_STACKS = 3;
    
    public ThreeInOne(int stackSize) {
        this.stackCap = stackSize;
        this.arr = new int [stackSize * this.NUM_STACKS];
        this.sizes = new int [this.NUM_STACKS];
    }
    
    public void push(int s, int v) {
        int top = indexOfTop(s);
        System.out.println(top);
        this.arr[top] = v;
        this.sizes[s]++;
    }
    
    public int pop(int s) {
        int v = this.arr[indexOfTop(s)];
        this.sizes[s]--;
        return v;
    }
    
    public int peek(int s) {
        int v = this.arr[indexOfTop(s)];
        return v;
    }

    public boolean isEmpty(int s) {
        return this.sizes[s] > 0;
    }
    
    public int indexOfTop(int s) {
        int offset = s * stackCap;
        int index = offset + sizes[s];
        return index;
    }
    
    public static void main(String [] args) {
        ThreeInOne stacks = new ThreeInOne(10);
        stacks.push(0, 100);
        stacks.push(0, 101);
        stacks.push(1, 200);
        stacks.push(1, 201);
        stacks.push(2, 300);
        stacks.push(2, 301);
        Utilities.printArray(stacks.arr);
    }
}
