package com.github.shy526.sort;

import java.util.Random;

/**
 * 排序算法
 *
 * @author sun
 */
public class Mysort {
    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int l, int r) {
        int left = l;
        int right = r;
        int temp = 0;
        //待排序至少有两个
        if (l < r) {
            //随机
            int x = new Random().nextInt((right - left)) + left;
            temp = arr[x];
            arr[x] = arr[left];
            arr[left] = temp;
            //不随机
            // temp=arr[left];  //选取基准元素*/
            //左右两边同时扫描
            while (left != right) {
                // 右->左扫描 比基准小的元素
                while (right > left && arr[right] >= temp) {
                    right--;
                }
                //找到元素后交换
                arr[left] = arr[right];
                //从左->右扫描，找到比基准大的元素
                while (left < right && arr[left] <= temp) {
                    left++;
                }
                //找到这种元素arr[left]后，与arr[right]交换
                arr[right] = arr[left];
                //基准元素归位
                arr[left] = temp;
                //对基准元素左边的元素进行递归排序
                quickSort(arr, l, left - 1);
                //对基准元素右边的进行递归排序
                quickSort(arr, right + 1, r);
            }
        }
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr) {
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
