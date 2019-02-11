package iluo.largestSumOfAverages_star;

/**
 * Created by Yang Xing Luo on 2019/2/11.
 */
public class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double[] sum = new double[A.length + 1];

        for (int i = 1; i <= A.length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }

        double[] dp = new double[A.length];

        for (int i = 0; i < A.length; i++) {
            dp[i] = (sum[A.length] - sum[i]) / (A.length - i);
        }

        for (int k = 1; k < K; k++) {
            for (int i = 0; i < A.length - 1; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    double temp = (sum[j] - sum[i]) / (j - i) + dp[j];
                    if (dp[i] < temp) {
                        dp[i] = temp;
                    }
                }
            }
        }
        return dp[0];
    }
}
