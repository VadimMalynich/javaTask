package com.leecode.task1;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class TwoSum {
    private int[] nums;
    private int target;

    public TwoSum() {
    }

    public TwoSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int[] getNums() {
        return nums;
    }

    public int getTarget() {
        return target;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    i = nums.length;
                    break;
                }
            }
        }
        return result;
    }
}
