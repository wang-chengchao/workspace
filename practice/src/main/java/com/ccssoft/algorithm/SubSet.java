package com.ccssoft.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 */
public class SubSet {

    public static void main(String[] args) {

        List<List<Integer>> ret=new ArrayList<>();
        int[] nums={1,2,3};
        backtrace(0, new ArrayList<>(), nums, ret);
        System.out.println(ret);

    }

    static void backtrace(int start,List<Integer> current,int[] nums,List<List<Integer>> ret){

        ret.add(new ArrayList<>(current));

        for (int i=start;i<nums.length;i++){
            current.add(nums[i]);
            backtrace(i+1, current, nums, ret);
            current.remove(current.size()-1);
        }
    }
}
