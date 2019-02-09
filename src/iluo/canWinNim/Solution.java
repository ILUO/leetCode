package iluo.canWinNim;

/**
 * Created by Yang Xing Luo on 2019/2/9.
 */
public class Solution {
    public boolean canWinNim(int n) {
        if(n % 4 == 0){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.canWinNim(1348820612));
    }

}
