from typing import List


class Solution:
    def maxValue_twoDimensions(
            self, bagWeight: int, weight: List[int], value: List[int]
    ) -> int:
        dp: List[List[int]] = [[0] * (bagWeight + 1) for _ in weight]
        for j in range(weight[0], bagWeight + 1):
            dp[0][j] = value[0]
        for i in range(1, len(weight)):
            for j in range(weight[i], bagWeight + 1):
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])

        return dp[-1][-1]

    def maxValue_oneDimensions(
            self, bagWeight: int, weight: List[int], value: List[int]
    ) -> int:
        dp: List[int] = [0] * (bagWeight + 1)
        for w, v in zip(weight, value):
            for j in range(bagWeight, w - 1, -1):
                dp[j] = max(dp[j], dp[j - w] + v)

        return dp[-1]


if __name__ == "__main__":
    solution = Solution()
    assert solution.maxValue_twoDimensions(4, [1, 3, 4], [15, 20, 30]) == 35
    assert solution.maxValue_oneDimensions(4, [1, 3, 4], [15, 20, 30]) == 35
    print("All tests passed.")
