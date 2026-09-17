"""LeetCode 93. Restore IP Addresses
https://leetcode.cn/problems/restore-ip-addresses/
"""

from typing import List


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        pass


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
