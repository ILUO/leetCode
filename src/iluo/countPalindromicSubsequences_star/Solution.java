package iluo.countPalindromicSubsequences_star;

/**
 * the same string from different position is  different
 */
public class Solution {
    public int countPalindromicSubsequences(String S) {
        int length =  S.length();
        int[][] count = new int[length][length];

        for(int right = 0;right < length;right++){
            count[right][right] = 1;
            for(int left = right - 1;left >= 0;left--){
                if(S.charAt(left)== S.charAt(right)){
                    count[left][right] = count[left][right-1] + count[left+1][right] + 1;
                }else{
                    count[left][right] = count[left][right-1] + count[left+1][right] - count[left+1][right-1];
                }

            }
        }
        return count[0][length-1];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.countPalindromicSubsequences("bccb"));
    }
}
