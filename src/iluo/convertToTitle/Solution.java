package iluo.convertToTitle;
import java.util.ArrayList;

/**
 * Created by Yang Xing Luo on 2019/2/15.
 */
public class Solution {
    public String convertToTitle(int n) {
        if(n < 0){
            return "";
        }
        String[] a = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        ArrayList<String> result = new ArrayList<>();
        for(;n != 0;){
            int remain = n % 26;
            if(remain == 0){
                result.add(a[25]);
                n = n / 26 - 1;
            }else{
                result.add(a[remain-1]);
                n = n / 26;
            }
        }
        String title = "";
        for(int i = result.size(); i >= 1;i--){
            title += result.get(i-1);
        }
        return title;
    }
}
