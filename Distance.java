public class Distance {
    /**
     * 计算两个字符串的Levenshtein编辑距离相似度。
     *
     * @param s1 第一个字符串
     * @param s2 第二个字符串
     * @return 相似度，值在0到1之间，值越大表示相似度越高
     */
    public static double calculateLevenshteinDistance(String s1, String s2) {
        // 创建一个二维数组用于存储编辑距离
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // 初始化第一行和第一列
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = j;
        }

        // 填充二维数组，计算编辑距离
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // 如果两个字符相同，则cost为0，否则为1
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + cost));
            }
        }

        // 计算相似度，返回值在0到1之间
        int maxLength = Math.max(s1.length(), s2.length());
        return 1.0 - (double) dp[s1.length()][s2.length()] / maxLength;
    }
}

