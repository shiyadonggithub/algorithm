package leetcode;

public class _36ValidSudoku {
    public static void main(String[] args) {
        int[] flagArray = new int[10];
        for (int i = 0; i < flagArray.length; i++) {
            System.out.println(flagArray[i]);
        }
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] flagArray = new int[10];
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                if (flagArray[board[i][j] - '.'] == 0) {
                    flagArray[board[i][j] - '.'] = 1;
                } else {
                    return false;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            int[] flagArray = new int[10];
            for (int i = 0; i < 9; i++) {
                if(board[i][j] == '.'){
                    continue;
                }
                if (flagArray[board[i][j]-'.'] == 0) {
                    flagArray[board[i][j]-'.'] = 1;
                } else {
                    return false;
                }
            }
        }

        for (int m = 0; m < 9; m++) {
            int i = (m / 3) * 3;
            int j = (m % 3) * 3;
            int[] flagArray = new int[10];
            for (; i < i + 3; i++) {
                for (; j < j + 3; j++) {
                    if(board[i][j] == '.'){
                        continue;
                    }
                    if (flagArray[board[i][j]-'.'] == 0) {
                        flagArray[board[i][j]-'.'] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}