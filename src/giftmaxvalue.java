/*
public class giftmaxvalue {
    public static void main(String[] args) {
        int[][] arr = { { 1, 10, 3, 8 },
                { 12, 2, 9, 6 },
                { 5, 7, 4, 11 },
                { 3, 7, 16, 5 } };
        System.out.println(getMaxValue1(arr));
    }

    private static int getMaxValue1(int[][] arr) {
        //输入处理
        if (arr == null || arr[0].length <= 0) {
            return 0;
        }
        //动态规划求解
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] maxValue = new int[rows][cols];
        for(int i=0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if(i > 0){
                    up = maxValue[i-1][j];
                }
                if(j > 0){
                    left = maxValue[i][j-1];
                }
                maxValue[i][j] = Math.max(up,left) +arr[i][j];
            }
        }

        return maxValue[rows-1][cols-1];
    }

}
*/

/**
 * 礼物的最价值
 */
public class giftmaxvalue {
    public static void main(String[] args) {
        int[][] map = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        int[][] dp = new int[map.length][map[0].length];
        for (int i = map.length-1; i>=0 ; i--) {
            for (int j = map[0].length-1; j >=0 ; j--) {
                //最后一行
                if (i == map.length-1 && j !=map[0].length-1){
                    dp[i][j] = map[i][j] + dp[i][j+1];
                }
                //最后一列
                else if (i != map.length-1 && j == map[0].length-1){
                    dp[i][j] = map[i][j] + dp[i+1][j];
                }
                else if (i != map.length-1 || j != map[0].length-1){
                    if (map[i+1][j]>map[i][j+1]){
                        dp[i][j] = dp[i+1][j] + map[i][j];
                    }else{
                        dp[i][j] = dp[i][j+1]+ map[i][j];
                    }
                }
                else {
                    //赋初值
                    dp[i][j] = map[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
