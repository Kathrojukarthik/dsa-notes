🧮 Problem: Number of Steps to Reduce a Number to Zero

Leetcode Problem: [1342. Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/)

## 💡 Problem Statement

Given an integer num, return the number of steps to reduce it to zero.

- If the current number is even, divide it by 2.
- If the current number is odd, subtract 1 from it.

Repeat this process until the number becomes 0.

---

## ✅ Example

Input: 14
Explanation:
- 14 is even → 14 / 2 = 7
- 7 is odd → 7 - 1 = 6
- 6 is even → 6 / 2 = 3
- 3 is odd → 3 - 1 = 2
- 2 is even → 2 / 2 = 1
- 1 is odd → 1 - 1 = 0 → Total steps = 6

---

## 🧠 Intuition

We apply recursion here:  
If the number is 0, return the count.  
If even, divide and count a step.  
If odd, subtract 1 and count a step.

This is a classic recursion decision tree:  
At each level, we reduce the problem size until we reach the base case.

---

## 🔁 Recursive Call Flow (for num = 14)

Call Stack:

helper(14, 0)  
→ helper(7, 1)  
→ helper(6, 2)  
→ helper(3, 3)  
→ helper(2, 4)  
→ helper(1, 5)  
→ helper(0, 6) → return 6

---

## 🔎 Time and Space Complexity

- Time Complexity: O(log n) — because we're dividing the number by 2 at every step (or subtracting 1 in odd case).
- Space Complexity: O(log n) due to recursive stack.

---

## 🧑‍💻 Java Code

```java
class Solution {
    public int numberOfSteps(int num) {
        return helper(num, 0);    
    }

    static int helper(int num, int c) {
        if (num == 0) {
            return c;
        }
        if (num % 2 == 0) {
            return helper(num / 2, c + 1);
        } else {
            return helper(num - 1, c + 1);
        }
    }
}
