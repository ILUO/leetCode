package iluo.maxSubArray_star;

public class SOlution2 {
    public int maxSubArray(int[] nums){
        return MaxSubSum(nums,0,nums.length-1);
    }

    private int MaxSubSum(int[] A,int Left,int Right){
        if (Left == Right)    /* 递归的基准情形 */
            return A[Left];

        int Center;
        Center = (Left + Right) / 2;   /* 求分界点 */
        int MaxLeftSum;
        MaxLeftSum = MaxSubSum(A, Left, Center);   /* 递归，求左半部分子序列的最大子序列和 */
        int MaxRightSum;
        MaxRightSum = MaxSubSum(A, Center + 1, Right);  /* 递归，求右半部分子序列的最大子序列和 */

        /* 求横跨左半部分和右半部分的最大子序列和 */
        /* 首先是左半部分子序列中包含最后一个元素的最大子序列和 */
        int MaxLeftBorderSum = A[Center], LeftBorderSum = A[Center];
        for (int i = Center - 1; i >= Left; --i) {
            LeftBorderSum += A[i];
            if (LeftBorderSum > MaxLeftBorderSum)
                MaxLeftBorderSum = LeftBorderSum;
        }

        /* 接着是右半部分子序列中包含第一个元素的最大子序列和 */
        int MaxRightBorderSum = A[Center + 1], RightBorderSum = A[Center + 1];
        for (int i = Center + 2; i <= Right; ++i) {
            RightBorderSum += A[i];
            if (RightBorderSum > MaxRightBorderSum)
                MaxRightBorderSum = RightBorderSum;
        }

        int max = MaxLeftSum;
        if(max < MaxRightSum) max = MaxRightSum;
        if(max < MaxLeftBorderSum+MaxRightBorderSum) max = MaxLeftBorderSum+MaxRightBorderSum;

        /* Max3 返回左、右半部分子序列的最大子序列和以及横跨左、右半部分的最大子序列和中的最大者 */
        return max;
    }

    public static void main(String[] args){
        SOlution2 sOlution2 = new SOlution2();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(sOlution2.maxSubArray(nums));
    }
}



