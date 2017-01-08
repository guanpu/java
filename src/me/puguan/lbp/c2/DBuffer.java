/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.c2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author XiaoPu
 */
public class DBuffer {

    private LinkedList<String> buffer;

    private int maxSize;

    private Lock lock;

    private Condition canRead;

    /**
     * Get the value of canRead
     *
     * @return the value of canRead
     */
    public Condition getCanRead() {
        return canRead;
    }

    /**
     * Set the value of canRead
     *
     * @param canRead new value of canRead
     */
    public void setCanRead(Condition canRead) {
        this.canRead = canRead;
    }

    private Condition canWrite;

    /**
     * Get the value of canWrite
     *
     * @return the value of canWrite
     */
    public Condition getCanWrite() {
        return canWrite;
    }

    /**
     * Set the value of canWrite
     *
     * @param canWrite new value of canWrite
     */
    public void setCanWrite(Condition canWrite) {
        this.canWrite = canWrite;
    }

    /**
     * Get the value of maxSize
     *
     * @return the value of maxSize
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Set the value of maxSize
     *
     * @param maxSize new value of maxSize
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public DBuffer() {
        this.maxSize = 10;
        this.buffer = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.canRead = lock.newCondition();
        this.canWrite = lock.newCondition();
    }

    /**
     * Get the value of buffer
     *
     * @return the value of buffer
     */
    public LinkedList<String> getBuffer() {
        return buffer;
    }

    /**
     * Set the value of buffer
     *
     * @param buffer new value of buffer
     */
    public void setBuffer(LinkedList<String> buffer) {
        this.buffer = buffer;
    }

    public void add(String string) {
        lock.lock();
        try {
            while (buffer.size() == maxSize) {
                canWrite.await();
            }
            buffer.offer(string);
            canRead.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get() {
        lock.lock();
        String result = null;
        try {
            while (buffer.isEmpty()) {
                canRead.await();
            }
            result = buffer.poll();
            canWrite.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;

    }
}
