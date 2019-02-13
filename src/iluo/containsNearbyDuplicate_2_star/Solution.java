package iluo.containsNearbyDuplicate_2_star;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang Xing Luo on 2019/2/13.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer val = data.get(nums[i]);
            if (null != val && k >= i - val) {
                return true;
            } else {
                data.put(nums[i], i);
            }
        }
        return false;
    }
}
