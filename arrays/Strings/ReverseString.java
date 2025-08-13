# 📌 LeetCode — Reverse String II (Problem 541)

## 🔹 Quick Revision Notes (Intuition + Steps)
- **Goal:** Reverse the first `k` characters for every `2k` characters in the string.
- **Approach:**  
  1. Convert string → `char[]` for in-place modifications.  
  2. Loop with step size `2k`.  
  3. Reverse from `i` to `min(i+k-1, length-1)`.  
  4. Use helper `reverse()` method with two-pointer swap logic.  
  5. Convert `char[]` back to string and return.
- **Time Complexity:** `O(n)` → Each char visited once.  
- **Space Complexity:** `O(n)` (char array).

---

## 💡 Detailed Explanation
**1. Problem Understanding:**  
We are given a string `s` and integer `k`. For every block of `2k` characters:
- Reverse the first `k` characters.
- Leave the next `k` characters as they are.
- Continue this for the entire string.

**2. Why `Math.min(i + k - 1, arr.length - 1)`?**  
To ensure we **don’t go out of bounds** when `k` goes beyond the last part of the string.

**3. Logic Flow:**
1. Convert the string to a `char[]` for easier swaps.
2. Iterate `i` in increments of `2k`.
3. For each chunk, reverse from index `i` to `min(i+k-1, lastIndex)`.
4. After processing all chunks, return the modified string.

**4. Dry Run Example:**  
`s = "abcdefg"`, `k = 2`  

| Iteration | Start Index | End Index  | Reversed Part | Result     |
|-----------|------------|------------|--------------|------------|
| i=0       | 0          | 1          | "ba"         | "bacdefg"  |
| i=4       | 4          | 5          | "fe"         | "bacdfe g" |
| Done      |            |            |              | "bacdfe g" |

---

## 📝 Code Implementation

```java
class Solution {
    public String reverseStr(String s, int k) {
        // Convert to char array for in-place changes
        char[] arr = s.toCharArray();

        // Loop in chunks of 2k
        for (int i = 0; i < arr.length; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, arr.length - 1); // Prevent overflow
            reverse(arr, start, end);
        }

        // Convert char array back to string
        return new String(arr);
    }

    // Helper method to reverse char array portion
    public void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
