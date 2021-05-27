package cn.minalz.heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 数据流中的中位数
 * @author: minalz
 * @date: 2021-05-27 22:44
 **/
public class StreamMidNumber {

    public int[] medianII(int[] nums) {
        int count = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(count, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // 最大堆 降序
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count);
        int[] answer = new int[count];
        int number = nums[0];
        answer[0] = number;
        for (int i = 1; i < count; i++) {
            if (nums[i] > number) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
            if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(number);
                    number = minHeap.poll();
                } else {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            } else {
                if (maxHeap.size() - minHeap.size() == 1 && maxHeap.peek() < number) {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            }
            answer[i] = number;
        }
        return answer;
    }

    @Test
    public void test01() {
        int[] nums1 = {1,2,3,4,5}; // 1,1,2,2,3
        Arrays.stream(medianII(nums1)).forEach(x -> System.out.print(x + ","));
        System.out.println();

        System.out.println("------------");

        int[] nums2 = {4,5,1,3,2,6,0}; // 4,4,4,3,3,3,3
        Arrays.stream(medianII(nums2)).forEach(x -> System.out.print(x + ","));
        System.out.println();

    }
}
