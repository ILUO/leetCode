package iluo.uniqueMorseRepresentations;

import java.util.ArrayList;

/**
 * Created by Yang Xing Luo on 2019/2/6.
 */
public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        ArrayList<String> encode = new ArrayList<>();
        ArrayList<String> decode = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        String[] encodeString = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] decodeString = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        for(int i = 0;i < encodeString.length;i++){
            encode.add(encodeString[i]);
            decode.add(decodeString[i]);
        }

        for(int i = 0;i < words.length;i++){
            String tempRes = "";
            String temp = words[i];
            for(int j = 0;j < temp.length();j++){
                tempRes += encode.get(decode.indexOf(temp.substring(j,j+1)));
            }
            int test = result.indexOf(tempRes);
            if(result.indexOf(tempRes) == -1){
                result.add(tempRes);
            }
        }
        return result.size();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(solution.uniqueMorseRepresentations(words));
    }
}
