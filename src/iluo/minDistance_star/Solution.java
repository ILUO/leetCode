package iluo.minDistance_star;

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[] dp = new int[len2+1];
        int temp,leftup;

        for(int i = 0;i <= len2;i++){
            dp[i] = i;
        }

        for(int i = 1;i <= len1;i++){
            leftup = i - 1;
            dp[0] = i;
            for(int j = 1;j <= len2;j++){
                temp = dp[j];
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[j] = leftup;
                }else{
                    if(dp[j] + 1 < dp[j-1] + 1) dp[j] = dp[j] + 1;
                    else dp[j] = dp[j-1] + 1;
                    if(dp[j] > leftup + 1) dp[j] = leftup + 1;
                }
                leftup = temp;
            }
        }

        return dp[len2];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.minDistance("intention","execution"));
    }
}
