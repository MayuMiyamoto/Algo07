import java.util.Scanner;

class Algo7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nl = sc.nextLine().split(" ");
        int n = Integer.parseInt(nl[0]);//試験の種類
        int l = Integer.parseInt(nl[1]);//学生の人数

        //生徒と試験の全管理
        int[][] score = new int[l][n];
        for ( int i = 0; i < l; i++){
            String[] tmp = sc.nextLine().split(" ");
            for(int j = 0; j < n; j++) {
                score[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        //試験ごとの最高得点とそれをとった学生の取得回数をカウント
        int[] winCount = new int[l];
        for (int j = 0; j < n; j++) {
            //最高得点を探す
            int max = score[0][j];
            for (int i = 1; i < l; i++) {
                if ( score[i][j] > max) {
                    max = score[i][j];
                }
            }

            //最高得点を取った学生をカウント
            for(int i = 0; i < l; i++) {
                if (score[i][j] == max) {
                    winCount[i]++;
                }
            }
        }
       
        //最も多く1位を取った学生の番号と回数を取得
        int maxCount = -1;
        int topStudent = 0;
        for (int i = 0; i < l; i++) {
            if (winCount[i] > maxCount) {
                maxCount = winCount[i];
                topStudent = i + 1;
            }
        }
    System.out.println(topStudent + " " + maxCount);
    }
}