package top.auntie.leetcode;

public class Code4 {

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] total = new int[nums1.length + nums2.length];
        boolean isOdd = (nums1.length + nums2.length) % 2 == 1;
        int i = 0, i1 = 0, i2 = 0;
        for (; i < total.length; ) {
            if (i1 < nums1.length && i2 < nums2.length) {
                total[i++] = nums1[i1] < nums2[i2] ? nums1[i1++] : nums2[i2++];
            } else {
                break;
            }
        }
        if (i1 >= nums1.length) {
            for (; i < total.length; i++) {
                total[i] = nums2[i2++];
            }
        } else {
            for (; i < total.length; i++) {
                total[i] = nums1[i1++];
            }
        }
        return isOdd ? total[(total.length / 2)] : (total[(total.length / 2) - 1] + total[total.length / 2]) / 2.0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 二分法查找两个数组相等或“相邻”的数字除以2
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2d;
    }

    /**
     * 二分查找，已知两个数组，存在数值k为两个数组的中位数
     *
     * @param nums1
     * @param start1
     * @param nums2
     * @param start2
     * @param k 两个数组长度之和的一半
     * @return
     */
    private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // 一方数组为空，直接取不为空数组的中间值
        if (start1 >= nums1.length) return nums2[start2 + k - 1];
        if (start2 >= nums2.length) return nums1[start1 + k - 1];
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        // 取数组的“相对中位”，如果数组长度不足“相对数量”，“中位数”设为最大
        int midVal1 = (start1 + k / 2 - 1) < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (start2 + k / 2 - 1) < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;

        if (midVal1 < midVal2) {
            // 如果nums2的中位数大于nums1的中位数，则认为中位数存在于nums1
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            // 如果nums1的中位数大于nums2的中位数，则认为中位数存在于nums2
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        System.out.println(new Code4().findMedianSortedArrays(nums1, nums2));
    }

}
