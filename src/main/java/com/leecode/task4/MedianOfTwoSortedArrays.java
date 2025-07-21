package com.leecode.task4;

import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
    private int[] nums1;
    private int[] nums2;

    public MedianOfTwoSortedArrays() {
    }

    public int[] getNums1() {
        return nums1;
    }

    public int[] getNums2() {
        return nums2;
    }

    public void setNums1(int[] nums1) {
        this.nums1 = nums1;
    }

    public void setNums2(int[] nums2) {
        this.nums2 = nums2;
    }

    public double findMedian(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        Arrays.sort(arr);
        return (arr.length % 2 == 0) ? (double) (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2 : arr[arr.length / 2];
    }
}
