package cn.minalz.sort;

import org.junit.jupiter.api.Test;

/**
 * @description: 冒泡排序
 * @author: minalz
 * @date: 2021-06-08 00:06
 **/
public class BubbleSort {


    /**
     * 冒泡排序
     * @param array
     */
    public void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    @Test
    public void testBubble() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 10000);
        }

        bubbleSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
