"""LeetCode 93. Restore IP Addresses
https://leetcode.cn/problems/restore-ip-addresses/
"""

from typing import List


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        path: List[str] = []
        ans: List[str] = []

        def backtracking(s: str, start_idx: int) -> None:
            if len(path) == 4:
                if start_idx == len(s):
                    ans.append(".".join(path))
                return

            for i in range(start_idx, min(start_idx + 3, len(s))):
                if not is_valid(s[start_idx: i + 1]):
                    break
                path.append(s[start_idx: i + 1])
                backtracking(s, i + 1)
                path.pop()

        def is_valid(next_num: str) -> bool:
            if int(next_num) > 255 or next_num[0] == "0" and len(next_num) > 1:
                return False
            return True

        if 4 <= len(s) <= 12:
            backtracking(s, 0)
        return ans


if __name__ == "__main__":
    solution = Solution()
    result = sorted(solution.restoreIpAddresses("25525511135"))
    expected = sorted(["255.255.11.135", "255.255.111.35"])
    assert result == expected

    solution = Solution()
    assert solution.restoreIpAddresses("0000") == ["0.0.0.0"]

    solution = Solution()
    result = sorted(solution.restoreIpAddresses("101023"))
    expected = sorted(["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"])
    assert result == expected

    print("All tests passed.")
