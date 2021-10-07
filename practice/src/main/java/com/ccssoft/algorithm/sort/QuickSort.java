package com.ccssoft.algorithm.sort;

import java.util.Random;


public class QuickSort {

    public static void main(String[] args) {

        int length=50;

        int[] nums=new int[length];


        Random random=new Random();

        for (int i=0;i<length;i++)
            nums[i]=random.nextInt(length);

        System.out.println("============================排序前================================");
        SortUtils.printArray(nums);

        // 6	23	23	13	2	12	22	3	29	27	12	10	0
        quickSort(nums,0,nums.length-1);

        System.out.println("============================排序后================================");
       SortUtils.printArray(nums);

    }


    public static void quickSort(int[] nums,int left,int right){

        if (right-left<1)
            return;

        //找到轴点元素
        int pivotal = processPivotal(nums, left, right);

        //对轴点之前的元素快速排序
        quickSort(nums,left,pivotal-1);
        //对轴点之后的元素快速排序
        quickSort(nums,pivotal+1,right);

    }

    /**
     * 获取当前[left,right]范围的轴点元素(基点) 使其轴点左边的元素都小于等于轴点，轴点右边的元素都大于轴点
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int processPivotal(int[] nums,int left,int right){

        int pivotal=nums[left];

        while(left<right) {

            while (left < right) {

                //先从右往左开始判断，如果当前right的元素大于轴点元素，right--,
                // 否则把当前left的元素覆盖当前right的元素然后下次循环调转方向(从左往右就开始判断)
                if (nums[right] > pivotal) {
                    right--;
                } else {
                    nums[left++] = nums[right];
                    break;
                }
            }

            while (left < right) {

                if (nums[left] < pivotal) {
                    left++;
                } else {
                    nums[right--] = nums[left];
                    break;
                }
            }
        }

        //left==right时把缓存的pivotal元素设置到此位置

        nums[left]=pivotal;

        return left;

    }


}
