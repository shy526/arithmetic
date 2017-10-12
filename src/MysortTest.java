import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MysortTest {
    /**
     * 生成随机数 数组
     *
     * @param index 数组长度
     * @param min   随机数最小值
     * @param max   随机数最大值
     * @return
     */
    private int[] randomInt(int index, int min, int max) {
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
    public static void foeach(int[] arr, String message) {
        System.out.println(message + "  ");
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    /**
     * 测试快速排序
     */
    @Test
    public void sort1() {
        int [] sort=randomInt(10,0,111);
      //  int[] sort = {18, 48, 32, 5, 108};

        foeach(sort, "排序前:");
        //Mysort.quickSort(sort, new Random().nextInt(sort.length - 1), sort.length - 1);
        Mysort.quickSort(sort,0, sort.length - 1);
        foeach(sort, "排序后:");

    }

    @Test
    public  void  sort2(){
        int[] sort = {18, 48, 32, 5, 108,47};
        foeach(sort, "排序前:");
        //n/2-1 得到非页子节点
            Mysort.heapSort(sort);
        foeach(sort, "排序后:");

    }
}