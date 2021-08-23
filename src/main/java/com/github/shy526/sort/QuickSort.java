package com.github.shy526.sort;

import java.util.Random;

/**
 * 快速排序
 *
 * @author shy526
 */
public class QuickSort {
    /**
     * 快速排序
     */
    public static void sort(int[] arr, int left, int right) {

        int temp = 0;
        //待排序至少有两个
        if (left < right) {
            //随机
            int x = new Random().nextInt((right - left)) + left;
            temp = arr[x];
            arr[x] = arr[left];
            arr[left] = temp;
            //左右两边同时扫描
            quickSortCore(arr, left, right, temp);
        }
    }

    public static void sort2(int[] arr, int left, int right) {
        int temp = 0;
        //待排序至少有两个
        if (left < right) {
            temp = arr[left];
            //左右两边同时扫描
            quickSortCore(arr, left, right, temp);
        }
    }

    private static void quickSortCore(int[] arr, int left, int right, int temp) {
        int leftW = left;
        int rightW = right;
        while (leftW != rightW) {
            // 右->左扫描 比基准小的元素
            while (rightW > left && arr[rightW] >= temp) {
                rightW--;
            }
            //找到元素后交换
            arr[leftW] = arr[rightW];
            //从左->右扫描，找到比基准大的元素
            while (leftW < rightW && arr[left] <= temp) {
                leftW++;
            }
            //找到这种元素arr[left]后，与arr[right]交换
            arr[rightW] = arr[leftW];
            //基准元素归位
            arr[leftW] = temp;
            //对基准元素左边的元素进行递归排序
            sort(arr, left, left - 1);
            //对基准元素右边的进行递归排序
            sort(arr, right + 1, right);
        }
    }
}
