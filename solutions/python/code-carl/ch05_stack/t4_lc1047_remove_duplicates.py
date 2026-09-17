"""LeetCode 1047. Remove All Adjacent Duplicates In String
https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
"""


class Solution:
    def removeDuplicates(self, s: str) -> str:
        chars = list(s)
        slow = 0
        for fast in range(len(chars)):
            if slow > 0 and chars[fast] == chars[slow - 1]:
                slow -= 1
            else:
                chars[slow] = chars[fast]
                slow += 1
        return "".join(chars[0:slow])


if __name__ == "__main__":
    solution = Solution()
    assert solution.removeDuplicates("abbaca") == "ca"
    assert solution.removeDuplicates("azxxzy") == "ay"
    print("All tests passed.")
