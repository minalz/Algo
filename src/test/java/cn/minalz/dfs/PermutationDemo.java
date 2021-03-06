package cn.minalz.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 46.全排列
 * @author: minalz
 * @date: 2021-05-30 23:38
 **/
public class PermutationDemo {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null ) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<Integer> list = new ArrayList<>();
        dfs(result, nums, list);
        return result;
    }

    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(result, nums, list);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test01() {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
