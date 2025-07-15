# 🔄 Rotate Image (90 Degrees Clockwise)

## 🔍 Problem Statement
You are given an n x n 2D matrix representing an image. Rotate the image in-place by 90 degrees clockwise.

📌 Example:
Input:
matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]

Output:
[
  [7, 4, 1],
  [8, 5, 2],
  [9, 6, 3]
]

---

## 💡 Logic & Intuition

To rotate a square matrix 90 degrees clockwise in-place:

1. First Transpose the matrix:
   - Transpose swaps rows with columns (matrix[i][j] ↔ matrix[j][i]).

2. Then Reverse each row:
   - This shifts all elements in a row from left to right.

This transforms the matrix into its rotated version.

---

## ⚙️ Approach

- Step 1: Transpose the matrix
  - Swap matrix[i][j] with matrix[j][i] for all i < j.
- Step 2: Reverse each row
  - For each row, swap start and end elements toward the center.

---

## ✅ Code (Java)
```java
public void rotate(int[][] matrix) {
    int len = matrix.length;

    // Step 1: Transpose
    for (int i = 0; i < len; i++) {
        for (int j = i + 1; j < len; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    // Step 2: Reverse each row
    for (int i = 0; i < len; i++) {
        for (int j = 0; j < len / 2; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][len - 1 - j];
            matrix[i][len - 1 - j] = temp;
        }
    }
}
