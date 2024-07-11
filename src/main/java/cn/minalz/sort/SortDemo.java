package cn.minalz.sort;

/**
 * @author zhouwei
 * @date 2024/7/11 9:35
 */
public class SortDemo {

    public static void main(String[] args) {
        int[] array = new int[100];
        long start1 = System.currentTimeMillis();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            array[i] = (int)(Math.random()*10000);
        }
//        bubbleSort(array);
        insertSort(array);
//        selectSort(array);
//        quickSort(array);
//        mergeSort(array);
        long end1 = System.currentTimeMillis();
        System.out.println("quick sort->" + (end1 - start1));
        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }

            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] array) {
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

    /**
     * 选择排序
     */
    public static void selectSort(int[] array) {
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

    /**
     * 快速排序
     */
    public static void quickSort(int[] array) {
        sort(array, 0, array.length -1);
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = array[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                // 找到左边第一个大于pivot的值
                left++;
            }
            while (left <= right && array[right] > pivot) {
                // 找到右边第一个小于pivot的值
                right--;
            }
            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
            // 左半
            sort(array, start, right);
            // 右半
            sort(array, left, end);
        }
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSortImpl(array, 0, array.length - 1, temp);
    }

    public static void mergeSortImpl(int[] array, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortImpl(array, start, mid, temp);
        mergeSortImpl(array, mid + 1, end, temp);
        merge(array, start, mid, end, temp);
    }

    public static void merge(int[] array, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = array[left++];
        }
        while (right <= end) {
            temp[index++] = array[right++];
        }
        for (index = start; index <= end; index++) {
            array[index] = temp[index];
        }
    }


}
