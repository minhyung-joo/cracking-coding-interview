public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length() + 1;
        int n = s2.length() + 1;
        int[][] lcsTable = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    lcsTable[i][j] = 0;
                }
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcsTable[i][j] = lcsTable[i-1][j-1] + 1;
                } else {
                    lcsTable[i][j] = Math.max(lcsTable[i-1][j], lcsTable[i][j-1]);
                }
            }
        }

        return lcsTable[m-1][n-1];
    }
}
