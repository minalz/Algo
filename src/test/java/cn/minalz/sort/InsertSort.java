package cn.minalz.sort;

import org.junit.jupiter.api.Test;

/**
 * @description: 插入排序
 * @author: minalz
 * @date: 2021-06-08 00:07
 **/
public class InsertSort {
    /**
     * 插入排序
     * @param array
     */
    public void insertSort(int[] array) {
        // 插入的节点
        int insertNode;
        int j;
        for (int i = 1; i < array.length; i++) {
            insertNode = array[i];
            j = i - 1;
            while (j >= 0 && insertNode < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertNode;
        }

    }

    @Test
    public void testInsert() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 10000);
        }

        insertSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
