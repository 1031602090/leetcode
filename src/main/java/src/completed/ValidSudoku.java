package completed;

/**
 * leetcode 36
 * @link https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    private static boolean[] b = new boolean[9];

    private boolean isValidSudoku(char[][] board) {
        return checkCol(board) && checkRow(board) && checkSubBoxes(board);
    }

    private boolean checkSubBoxes(char[][] board) {
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                for(int m=i;m<i+3;m++){
                    for(int n = j;n<j+3;n++){
                        if('.' == board[m][n])
                            continue;
                        if(b[board[m][n]-'1']){
                            System.out.println(1);
                            return false;
                        }
                        b[board[m][n]-'1'] = true;
                    }
                }
                for (int t=0;t<9;t++){
                    b[t] = false;
                }
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board) {
        for(int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if('.' == board[i][j])
                    continue;
                if(b[board[i][j]-'1']){
                    System.out.println(2);
                    return false;
                }
                b[board[i][j]-'1'] = true;
            }
            for (int j=0;j<9;j++){
                b[j] = false;
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board) {
        for(int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if(board[j][i]=='.')
                    continue;
                if(b[board[j][i]-'1']){
                    System.out.println(3);
                    return false;
                }
                b[board[j][i]-'1'] = true;
            }
            for (int j=0;j<9;j++){
                b[j] = false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] t = new char[][]{  {'5','3','.','.','7','.','.','.','.'},
                                    {'6','7','.','1','9','5','.','.','.'},
                                    {'.','9','8','.','.','.','.','6','.'},
                                    {'8','.','.','.','6','.','.','.','3'},
                                    {'4','.','.','8','.','3','.','.','1'},
                                    {'7','.','.','.','2','.','.','.','6'},
                                    {'.','6','.','.','.','.','2','8','.'},
                                    {'.','.','.','4','1','9','.','.','5'},
                                    {'.','.','.','.','8','.','.','7','9'}
                                    };
        System.out.println(new ValidSudoku().isValidSudoku(t));
    }
}
