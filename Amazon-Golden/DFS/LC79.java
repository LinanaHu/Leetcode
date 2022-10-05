package DFS;

public class LC79 {
    public boolean exist(char[][] board, String word){
        int row=board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0; i < row; i++){
            for(int j=0; j< col; j++){
                if(dfs(visited, board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] visited,char[][] board, int i, int j, String word, int wordIdx){
        int len =word.length();
        //success
        if(wordIdx == len){
            return true;
        }
        //Failure
        if( i <0 || j<0|| i >= board.length || j >= board[0].length|| word.indexOf(wordIdx)!= board[i][j]||visited[i][j]) {
            return false;
        }

        wordIdx++;
        visited[i][j] = true;
        boolean res =
                dfs(visited, board, i + 1, j, word, wordIdx)||
                dfs(visited, board, i - 1, j, word, wordIdx)||
                dfs(visited, board, i, j + 1, word, wordIdx)||
                dfs(visited, board, i, j - 1, word, wordIdx);
        visited[i][j] =false;

        return res;

    }

    public static void main(String[] args) {
        String test = "String";
        System.out.println(test[0]);

    }
}
