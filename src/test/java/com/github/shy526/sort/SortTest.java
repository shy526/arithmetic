package com.github.shy526.sort;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;
@RunWith(JUnit4.class)
public class SortTest extends TestCase{
    public static int[] testClassArray = null;
    public int[] testArray = null;
    public Long startTime;
    @Rule
    public TestName name = new TestName();
    /**
     * 生成随机数 数组
     *
     * @param index 数组长度
     * @param min   随机数最小值
     * @param max   随机数最大值
     * @return int[]
     */
    public static int[] randomInt(int index, int min, int max) {
        Random random = new Random();
        int[] temp = new int[index];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = random.nextInt(max - min + 1) + min;
        }
        return temp;
    }

    /**
     * 打印数组
     *
     * @param arr     所要打印的数据
     * @param message 打印数据前提示的消息
     */
    public static void foEach(int[] arr, String message) {
        System.out.println(message);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    @BeforeClass
    public static void beforeClass(){
        testClassArray=randomInt(100000, 0, 100000000);
    }
    @Before
    public void before() {
        testArray=randomInt(10, 0, 100000000);
        foEach(testArray,"排序前数组:");
        startTime=System.currentTimeMillis();
    }

    @After
    public void after() {
         long endTime = System.currentTimeMillis();
        foEach(testArray,"排序后数组:");
        System.out.println(name.getMethodName()+":"+(endTime-startTime)+"ms");
    }

}
