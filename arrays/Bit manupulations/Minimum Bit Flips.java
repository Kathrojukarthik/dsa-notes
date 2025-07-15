# 🔁 Minimum Bit Flips to Convert start to goal

🔹 Intuition: Use bitwise AND and right shift to compare each bit of start and goal, counting mismatches.

---

## 🔍 Problem Statement
Given two integers start and goal, return the number of bits that need to be flipped to convert start to goal.

📌 Example:
- Input: start = 10 (1010), goal = 7 (0111)  
  Output: 3  
  Explanation: Bits at positions 0, 1, and 3 are different.

---

## 💡 Logic & Intuition
- To convert one number to another, count how many bits differ between them.
- Loop until both start and goal become 0:
  - At each step, extract the least significant bit (LSB) of both using bitwise AND (& 1).
  - If the LSBs are different, increment the count.
  - Right shift both numbers by 1 to move to the next bit.

---

## ⚙️ Approach
1. Initialize count = 0.
2. While either start or goal > 0:
   - Extract LSBs: start & 1 and goal & 1.
   - If they're different → count++.
   - Right shift start and goal by 1.
3. Return count.

---

## ✅ Code (Java)
```java
public int minBitFlips(int start, int goal) {
    int count = 0;

    while (start > 0 || goal > 0) {
        int startLsb = start & 1;
        int goalLsb = goal & 1;

        if (startLsb != goalLsb) {
            count++;
        }

        start = start >> 1;
        goal = goal >> 1;
    }

    return count;
}
