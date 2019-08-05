package iluo.findKthLargest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Yang Xing Luo on 2019/8/5.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(nums.length,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
        for(int i = 0;i < nums.length;i++){
            queue.add(nums[i]);
        }
        int result = 0;
        for(int i = 0;i < k;i++){
            result = queue.poll();
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(solution.findKthLargest(nums,3));
    }
}
