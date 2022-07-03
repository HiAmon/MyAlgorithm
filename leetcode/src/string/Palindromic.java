package string;

public class Palindromic {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int l = 0;l<n;l++){
            for (int i = 0 ; i < n-l;i++){
                int j = i + l;
                if (l==0){
                    dp[i][j] = true;
                }
                if ((l == 1) && (s.charAt(i) == s.charAt(j))){
                    dp[i][j] = true;
                }
                dp[i][j] = false;
            }
        }
        return null;
    }
}
