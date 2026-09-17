import heapq
from functools import cmp_to_key
from symtable import Class
from typing import List


def solution1(n1: str, n2: str) -> str:
    n1_str: str = n1[::-1]
    n2_str: str = n2[::-1]

    l1 = len(n1_str)
    l2 = len(n2_str)
    if l2 > l1:
        l1, l2 = l2, l1
        n1_str, n2_str = n2_str, n1_str

    ans: List[int] = []
    plus, curr = 0, 0
    for i in range(len(n1_str)):
        if i < len(n2_str):
            s = ord(n1_str[i]) - ord('0') + ord(n2_str[i]) - ord('0') + plus
        else:
            s = ord(n1_str[i]) - ord('0') + plus
        plus = s // 10
        curr = s % 10
        ans.append(curr)
    if plus != 0:
        ans.append(plus)

    return "".join([str(i) for i in ans])[::-1]


def solution2(n1: str, n2: str) -> str:
    if len(n2) > len(n1):
        n1, n2 = n2, n1
    n1_list: List[int] = [int(n) for n in list(n1[::-1])]
    n2_list: List[int] = [int(n) for n in list(n2[::-1])]

    plus = 0
    for i in range(len(n1_list)):
        total = n1_list[i] + plus + (n2_list[i] if i < len(n2_list) else 0)
        plus = total // 10
        n1_list[i] = total % 10

    if plus:
        n1_list.append(plus)

    return "".join([str(n) for n in n1_list[::-1]])


# n1 = input()
# n2 = input()
# print(solution2(n1, n2))

for i in "asdf":
    print(i)


class Person:
    def __init__(self, age: int, name: str):
        self.age = age
        self.name = name


p1 = Person(3, "d")
p2 = Person(3, "a")
p3 = Person(1, "b")
p4 = Person(2, "c")
p5 = Person(2, "e")
p_list: List[Person] = [p1, p2, p3, p4, p5]

sort_p_list = sorted(p_list, key=lambda p: (p.age, p.name))
for p in sort_p_list:
    print(f"age:{p.age}, name:{p.name}")

print("=" * 30)


def my_compare(p1: Person, p2: Person) -> int:
    if p1.age != p2.age:
        return p1.age - p2.age
    if p1.name > p2.name:
        return -1
    elif p1.name < p2.name:
        return 1
    else:
        return 0


sort_p_list_2 = sorted(p_list, key=cmp_to_key(my_compare))
for p in sort_p_list_2:
    print(f"age:{p.age}, name:{p.name}")

print("=" * 30)

heap = []
top_k = 3
for p in p_list:
    if len(heap) < top_k:
        heapq.heappush(heap, (p.age, p.name, p))
    else:
        heapq.heapreplace(heap, (p.age, p.name, p))

top_k_p: List[Person] = []
while heap:
    _, _, p = heapq.heappop(heap)
    top_k_p.append(p)

for p in top_k_p[::-1]:
    print(f"age:{p.age}, name:{p.name}")
