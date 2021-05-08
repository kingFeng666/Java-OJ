class Solution {
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //第一步:排序
        int p =0,p1=0,p2=0;//p指针用来查找nums数组,p1用来查找nums1,p2查找nums2
        int len = nums1.length + nums2.length;
        int[] nums = new int[len];//保存结果的数组
        while (p < nums.length){
            if (p1>=nums1.length){
                //nums1耗尽,nums2直接拷贝
                nums[p] = nums2[p2];
                p++;
                p2++;
                continue;//直接拷贝,不用走后面流程
            }
            if (p2>=nums2.length){
                //nums2耗尽,nums1直接拷贝
                nums[p] = nums1[p1];
                p++;
                p1++;
                continue;//直接拷贝,不用走后面流程
            }
            if (nums1[p1] < nums2[p2]){//将nums1和nums2中较小的值保存到nums中
                nums[p] = nums1[p1];
                p++;
                p1++;
            }else {
                nums[p] = nums2[p2];
                p++;
                p2++;
            }
        }
        // 第二步:查找
        double mid = 0;
        int midIndex = 0;
        if (len%2 == 0){
            //结果数组长度为偶数,取中间两个值的平均值
            midIndex = len/2-1;
            mid = (nums[midIndex]+nums[midIndex+1])/2d;
        }else {
            //结果数组长度为奇数,直接取中间值
            midIndex = len/2;
            mid = nums[midIndex];
        }
        return mid;
    }
}