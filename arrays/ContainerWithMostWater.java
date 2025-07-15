# 🧊 Container With Most Water

## 🔍 Problem Statement
You are given an integer array height of length n. There are n vertical lines drawn at positions (i, height[i]). Find two lines that together with the x-axis form a container, such that the container holds the most water.

📌 Example:
Input: height = [1,8,6,2,5,4,8,3,7]  
Output: 49  
Explanation: Max area is between lines at index 1 and 8: min(8,7) × (8−1) = 7 × 7 = 49.

---

## 💡 Logic & Intuition
- The area between two lines = min(height[l], height[r]) × (r - l).
- Use two pointers: one at the beginning (l) and one at the end (r).
- Move the pointer pointing to the shorter line inward because the area is limited by the shorter height.
- Repeat this process until the two pointers meet.

---

## ⚙️ Approach
1. Initialize two pointers: l = 0, r = height.length - 1.
2. While l < r:
   - Calculate area: min(height[l], height[r]) × (r - l)
   - Update maxArea if current area is greater.
   - Move the pointer with the smaller height inward.
3. Return maxArea.

---

## ✅ Code (Java)
```java
public int maxArea(int[] height) {
    int maxArea = Integer.MIN_VALUE;
    int l = 0, r = height.length - 1;

    while (l < r) {
        int currArea = Math.min(height[l], height[r]) * (r - l);
        maxArea = Math.max(currArea, maxArea);

        if (height[l] < height[r]) {
            l++;
        } else {
            r--;
        }
    }

    return maxArea;
}
