package iluo.shortestCompletingWord;

public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String result = "";
        licensePlate = licensePlate.toLowerCase();
        int[] licenseTable = new int[128];
        for(int i = 0;i < licensePlate.length();i++){
            licenseTable[licensePlate.charAt(i)]++;
        }
        for(int i = 0;i < words.length;i++){
            int[] wordsTable = new int[128];
            words[i] = words[i].toLowerCase();
            for(int j = 0;j < words[i].length();j++){
                wordsTable[words[i].charAt(j)]++;
            }
            int flag = 0;
            for(int j = 97;j <= 122;j++){
                if(licenseTable[j] > wordsTable[j]){
                    flag = 1;
                    break;
                }
            }
            if(result.length() == 0 && flag == 0){
                result= words[i];
            }
            if(flag == 0 && result.length() > words[i].length()){
                result = words[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String license = "Ar16259";
        String[] a = {"our"};
        solution.shortestCompletingWord(license,a);
    }
}
