package iluo.hammingDistance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int t = x ^ y;
        while (t != 0) {
            count += t & 1;
            t = t >> 1;
        }
        return count;
    }
}
