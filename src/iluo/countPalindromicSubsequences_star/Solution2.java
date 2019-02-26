package iluo.countPalindromicSubsequences_star;

public class Solution2 {
    private int M = 1000000007;
    public int countPalindromicSubsequences(String S) {
        int length =  S.length();
        int[][] count = new int[length][length];

        for(int right = 0;right < length;right++){
            count[right][right] = 1;
        }
        for(int len = 1;len < length;len++){
            for(int i = 0;i < length - len;i++){
                int j = i + len;
                if(S.charAt(i) == S.charAt(j)){
                    int left= i+1,right = j-1;
                    while(left <= right && S.charAt(left) != S.charAt(i)) left++;
                    while(left <= right && S.charAt(right) != S.charAt(i)) right--;
                    if(left > right){
                        count[i][j] = count[i+1][j-1]*2 + 2;
                    }else if(left == right){
                        count[i][j] = count[i+1][j-1]*2 + 1;
                    }else{
                        count[i][j] = count[i+1][j-1] * 2 - count[left+1][right-1];
                    }
                }else {
                    count[i][j] = count[i][j-1] + count[i+1][j] - count[i+1][j-1];
                }
                count[i][j] = (count[i][j] < 0)?count[i][j]+ M : count[i][j] % M;
            }
        }

        return count[0][length-1];
    }

    public static void main(String[] args){
        Solution2 solution = new Solution2();
        System.out.println(solution.countPalindromicSubsequences("bccb"));
    }
}
