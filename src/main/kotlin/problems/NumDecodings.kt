package problems

/**
 * https://leetcode.com/problems/decode-ways/
 */
fun numDecodings(s: String): Int {
    if (s.isNullOrEmpty()) return 0
    val dp = IntArray(s.length+1)
    dp[0] = 1
    dp[1] = if (s[0] != '0') 1 else 0
    for (i in 2..s.length) {
        val first = s.substring(i-1 until i).toInt()
        val second = s.substring(i-2 until i).toInt()
        if (first in 1..9) dp[i] += dp[i-1]
        if (second in 10..26)  dp[i] += dp[i-2]
    }
    return dp[s.length]
}