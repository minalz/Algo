package cn.minalz.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 78.子集
 * @author: minalz
 * @date: 2021-05-31 00:27
 **/
public class SubSetsDemo {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
//        Arrays.sort(nums);
        dfs(result, nums, list, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> list, int pos) {
        result.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test01() {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
 }
