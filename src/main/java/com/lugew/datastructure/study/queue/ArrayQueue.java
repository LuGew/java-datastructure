package com.lugew.datastructure.study.queue;

import com.lugew.datastructure.util.Display;
import com.lugew.datastructure.util.Queue;

/**
 * 循环队列
 * 复杂度分析:insert:O(1),remove:O(1)
 *
 * @author LuGew
 */
public class ArrayQueue<T> implements Queue<T>, Display {
    private int maxSize;
    private T[] array;
    private int front;
    private int rear;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize + 1;
        array = (T[]) new Object[this.maxSize];
        front = 0;
        rear = -1;
    }

    @Override
    public boolean add(T element) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        array[++rear] = element;
        return true;
    }

    @Override
    public T remove() {
        T temp = array[front++];
        if (front == maxSize) {
            front = 0;
        }
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return (rear + 1 == front) || (front + maxSize - 1 == rear);
    }

    public boolean isFull() {
        return (rear + 2 == front) || (front + maxSize - 2 == rear);
    }

    @Override
    public int size() {
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return (maxSize - front + rear + 1);
        }
    }

    @Override
    public void display() {
        if (!isEmpty()) {
            if (rear >= front) {
                for (int i = front; i <= rear; i++) {
                    System.out.print(array[i] + " ");
                }
            } else {
                for (int i = front; i < maxSize; i++) {
                    System.out.print(array[i] + " ");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println();
        }
    }
}
