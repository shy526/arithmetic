package com.github.shy526.sort;

/**
 * 堆排序
 * @author shy526
 */
public class HeapSort {

    public static void sort(int[] arr) {
        //初始化堆
        for (int i = arr.length / 2 - 1; i >= 0; --i) {
            floatMax(arr, i, arr.length - 1);
        }
        // 进行排序
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            floatMax(arr, 0, i - 1);

        }
    }

    /**
     * 堆排序,上浮数据
     */
    public static void floatMax(int[] arr, int pnode, int length) {
        //获取父节点数据
        int temp = arr[pnode];
        //i从左子节点开始
        for (int i = 2 * pnode + 1; i <= length; i = 2 * i + 1) {
            //查看是否为双节点
            if (i + 1 < length) {
                //筛选左右节点
                if (i < length && arr[i] < arr[i + 1]) {
                    i++; //右节点则+1
                }
            }
            //父节点与子节点比较
            if (temp < arr[i]) {
                //替换父节点
                arr[pnode] = arr[i];
                pnode = i;
            }
        }
        //归还父节点
        arr[pnode] = temp;
    }
}
