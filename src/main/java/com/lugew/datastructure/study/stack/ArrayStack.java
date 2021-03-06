package com.lugew.datastructure.study.stack;

import com.lugew.datastructure.util.Stack;

/**
 * 栈
 * 复杂度分析:pop:O(1),peek:O(1),push:O(1)
 *
 * @param <T> 泛型
 */
public class ArrayStack<T> implements Stack<T> {
    private static final int CAPACITY = 50;
    private int maxSize;
    private T[] array;
    private int index;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int maxSize) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
            array = (T[]) new Object[maxSize];
            index = -1;
        }
    }

    public T pop() {
        if (!isEmpty()) {
            return array[index--];
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return array[index];
        }
        return null;
    }

    public T peek(int index) {
        if (index >= 0 && index <= this.index) {
            return array[index];
        }
        return null;
    }

    public boolean push(T value) {
        if (!isFull()) {
            array[++index] = value;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return index == -1;
    }

    public int size() {
        return index + 1;
    }

    public boolean isFull() {
        return index == maxSize - 1;
    }

    public void display() {
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peek(i));
            System.out.print(" ");
        }
        System.out.println();
    }
}
