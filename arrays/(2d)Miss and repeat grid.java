# 📋 Set Mismatch in a Grid (Duplicate & Missing Number)

## 🔍 Problem Statement
You are given a 2D grid of size n × n with values from 1 to n², but:
- One number is duplicated (appears twice),
- One number is missing (appears zero times).

Your task is to return an array:  
res[0] = duplicate,  
res[1] = missing.

📌 Example:
Input:
grid = [
  [1, 2],
  [2, 4]
]

Output: [2, 3]

Explanation:
- 2 appears twice (duplicate),
- 3 is missing.

---

## 💡 Logic & Intuition
- Flatten the grid into a 1D count representation using a frequency array of size n² + 1.
- Traverse the grid and increment frequency for each number.
- Then, scan the frequency array:
  - If freq[i] == 2 → it's the duplicate.
  - If freq[i] == 0 → it's the missing number.

---

## ⚙️ Approach
1. Initialize n = grid.length.
2. Create freq[] of size n² + 1 to track frequency of each number.
3. Loop through every cell in the grid and increment freq[grid[i][j]].
4. Loop through freq from 1 to n²:
   - If freq[i] == 2 → duplicate → res[0] = i.
   - If freq[i] == 0 → missing  → res[1] = i.
5. Return res array.

---

## ✅ Code (Java)
```java
public int[] findDuplicateAndMissing(int[][] grid) {
    int n = grid.length;
    int[] freq = new int[n * n + 1];
    int[] res = new int[2];

    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            freq[grid[i][j]]++;
        }
    }

    for (int i = 1; i < freq.length; i++) {
        if (freq[i] == 2) {
            res[0] = i; // duplicate
        } else if (freq[i] == 0) {
            res[1] = i; // missing
        }
    }

    return res;
}
