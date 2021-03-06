package cn.minalz.sort;

import org.junit.jupiter.api.Test;

/**
 * @description: 选择排序
 * @author: minalz
 * @date: 2021-06-08 00:15
 **/
public class SelectSort {

    /**
     * 选择排序
     * @param array
     */
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            for (int j = i; j < array.length; j++) {
                if (array[pos] > array[j]) {
                    pos = j;
                }
            }
            if (pos != i) {
                int temp = array[i];
                array[pos] = array[i];
                array[i] = temp;
            }
        }
    }

    @Test
    public void testSelect() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 10000);
        }

        selectSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
