package com.github.shy526.subject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shy526
 */
public class ThreadTest {


    public void solution() {
        ReentrantLock lock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                try {
                    countDownLatch.countDown();
                    condition1.await();
                    System.out.println("t1 start");
                    condition2.signal();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
                java.lang.Thread.sleep(100);

                lock.lock();
                try {
                    condition1.await();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }

                System.out.println("t1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                countDownLatch.await();
                lock.lock();
                try {
                    condition1.signal();
                    condition2.await();
                    System.out.println("t2 start");
                    condition3.signal();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
                java.lang.Thread.sleep(200);
                lock.lock();
                try {
                    condition2.await();
                    condition1.signal();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                lock.lock();
                try {
                    condition1.signal();
                    condition3.await();
                    System.out.println("t3 start");
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
                java.lang.Thread.sleep(300);
                System.out.println("t3 end");
                lock.lock();
                try {
                    condition2.signal();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 修改下面的代码 使其输出顺序为
     *t1 start t2 start  t3 start    t3end  t2 end  t1 end
     */
    public void subject(){
        Thread t1 = new Thread(()->{

                try {
                    System.out.println("t1 start");
                    Thread.sleep(1000);
                    System.out.println("t1 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        });

        Thread t2 = new Thread(()->{

                try {
                    System.out.println("t2 start");
                    Thread.sleep(2000);
                    System.out.println("t2 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });


        Thread t3 = new Thread(()->{

                try {
                    System.out.println("t3 start");
                    Thread.sleep(3000);
                    System.out.println("t3 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
