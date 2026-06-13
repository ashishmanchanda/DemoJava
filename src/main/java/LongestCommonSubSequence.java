


public class LongestCommonSubSequence {

    static int findLongestCommonSubSequence(String str1, String str2) {
        int dp[][] = new int[str1.length()][str2.length()];
        int result = findlcs(str1, str2, 0, 0, dp);
        return result;
    }

    static int findlcs(String str1, String str2, int i1,int i2,int dp[][]){
        if(i1 == str1.length() || i2 == str2.length()){
            return 0;
        }
        if (dp[i1][i2] == 0) {
            if (str1.charAt(i1) == str2.charAt(i2)) {
                dp[i1][i2] = 1 + findlcs(str1, str2, i1 + 1, i2 + 1, dp);
            }else {
                int count1 = findlcs(str1, str2, i1 + 1, i2, dp);
                int count2 = findlcs(str1, str2, i1, i2 + 1, dp);
                dp[i1][i2] = Math.max(count1, count2);
            }

        }
        return dp[i1][i2];
    }

    public static void main(String[] args) {
        String s1="abcfhad";
        String s2="abdhad";

        int result =findLongestCommonSubSequence(s1,s2);
        System.out.println(result);
    }
}
