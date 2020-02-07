public class uglydigit {
    public static void main(String[] args) {
//        System.out.println("GetUglyNumber_Solution(11) = " + nthUglyNumber(11));
        String s="226";
        String  s1 = s.substring(1,3);
        System.out.println("s1 = " + s1);
        System.out.println("numDecodings() = " + numDecodings(s));
    }
    public static int nthUglyNumber(int n) {
        if(n <= 0 ) return 0;
        int[] pUglyNums = new int[n];
        pUglyNums[0] = 1;
        int nextUglyIndex = 1;
        int pMultiply2 = 0;
        int pMultiply3 = 0;
        int pMultiply5 = 0;
        while(nextUglyIndex < n){
            int min = Math.min(pUglyNums[pMultiply2]*2,pUglyNums[pMultiply3]*3);
            min = Math.min(min,pUglyNums[pMultiply5]*5);
            pUglyNums[nextUglyIndex] = min;
            System.out.printf("%d,",min);
            while(pUglyNums[pMultiply2]*2<=pUglyNums[nextUglyIndex]) pMultiply2++;
            while(pUglyNums[pMultiply3]*3<=pUglyNums[nextUglyIndex]) pMultiply3++;
            while(pUglyNums[pMultiply5]*5<=pUglyNums[nextUglyIndex]) pMultiply5++;
            nextUglyIndex++;
        }
        int num = pUglyNums[nextUglyIndex-1];
        return num;
    }
    public static int numDecodings(String s) {
        if(s == null || s.length() <=0) return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1;
        if(s.charAt(len-1) == '0'){
            dp[len-1] = 0;
        }else{
            dp[len-1] = 1;
        }
        for(int i=len-2;i>=0;++i){
            if(i < len-1){
                if(s.charAt(i) == '0'){
                    dp[i] = 0;
                    continue;
                }
                String ds = s.substring(i,i+2);
                int num = Integer.parseInt(ds);
                if(num > 0 && num <= 26){
                    dp[i] = dp[i+1] + dp[i+2];
                }else{
                    dp[i] = dp[i+1];
                }
            }
        }
        return dp[0];
    }
}
