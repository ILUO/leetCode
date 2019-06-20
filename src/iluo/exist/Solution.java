package iluo.exist;

public class Solution {
    private boolean res = false;
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(word.charAt(0) == board[i][j]) res = search(board,i,j,word,0);
                if(res) return res;
            }
        }
        return res;
    }

    private boolean search(char[][] board,int i,int j,String word,int index){
        if(i < 0 || i >= board.length ||  j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) return false;
        else if(index == word.length() - 1 || res) return true;
        else{
            char temp= board[i][j];
            board[i][j] = '*';
            res = res | search(board,i-1,j,word,index+1)| search(board,i+1,j,word,index+1) | search(board,i,j-1,word,index+1) | search(board,i,j+1,word,index+1);
            board[i][j] = temp;
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(board,"ABCESEEEFS"));
    }
}
