package iluo.hasGroupsSizeX_star;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for(int i = 0;i < deck.length;i++) count[deck[i]]++;
        int min = 10001;
        int flag = 0;
        int numbers = 1;
        for(int i = 0;i < count.length;i++){
            if(count[i] == 1){
                return false;
            }else{
                if(count[i] != 0){
                    if(flag == 0){
                        numbers = count[i];
                        flag = 1;
                    }
                    numbers = gcd(numbers,count[i]);
                }
            }
        }
        if(numbers == 1) return false;
        return true;
    }

    private int gcd(int m,int n){
        if(m < n){
            int temp = m;
            m = n;
            n = temp;
        }
        if(n == 0) return m;
        else return gcd(n,m % n);
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int[] deck = {1,1,1,1,2,2,2,2,2,2};
        System.out.println(solution.hasGroupsSizeX(deck));
    }
}
