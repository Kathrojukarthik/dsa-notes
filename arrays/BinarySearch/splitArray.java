# 📦 Problem 1: Split Array Largest Sum

LeetCode Problem: [410. Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/)

---

## 🔍 Quick Revision Notes
- **Goal:** Split `nums` into `k` subarrays → minimize the largest subarray sum.  
- **Bounds:**
  - Lower bound (`low`) = `max(nums)` (largest single element).  
  - Upper bound (`high`) = `sum(nums)` (one subarray with all elements).  
- **Binary Search:**  
  - `mid` = possible largest sum.  
  - Greedily form subarrays without exceeding `mid`.  
  - If more than `k` subarrays → need larger `mid` (`low = mid + 1`).  
  - Else → try smaller `mid` (`high = mid`).  
- **Time Complexity:** `O(n log sum(nums))`  
- **Space Complexity:** `O(1)`

---

## 💡 Problem Statement
Given an array `nums` and an integer `k`, split `nums` into `k` or fewer non-empty subarrays such that the **largest sum** among these subarrays is minimized.  
Return the minimized largest sum.

---

## ✅ Example
**Input:**  
nums = [7,2,5,10,8], k = 2  

**Output:**  
18  

**Explanation:**  
Split into `[7,2,5]` and `[10,8]`, largest sum = 18.

---

## 💡 Logic & Intuition
- The answer must be at least the **max element** and at most the **sum of all elements**.  
- We can **binary search** the possible largest sum.  
- For each `mid`, we simulate splitting:
  - Add numbers to current subarray sum.  
  - If adding exceeds `mid`, start new subarray and increase `pieces`.  
- If `pieces > k`, `mid` is too small → increase lower bound.  
- Else, `mid` is valid → try smaller value to minimize answer.

---

## ⚙️ Approach
1. **Find bounds:**
   - `min = max(nums)`
   - `max = sum(nums)`
2. **Binary search:**
   - `mid = (start + end) / 2`
   - Count how many subarrays needed if largest sum ≤ `mid`.
3. **Adjust bounds:**
   - If `pieces > k`, `start = mid + 1`
   - Else, `end = mid`
4. **Return** `start` when loop ends.

---

## ⏱ Complexity
- **Time:** `O(n log sum(nums))`  
- **Space:** `O(1)`

---

## 🖥 Java Code
```java
class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0, min = 0;
        
        // Determine lower and upper bounds
        for (int num : nums) {
            max += num;
            min = Math.max(min, num);
        }
        
        return binarySearch(nums, k, min, max);
    }
    
    static int binarySearch(int[] nums, int k, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pieces = 1;
            
            for (int num : nums) {
                if (sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            
            if (pieces > k) {
                start = mid + 1; // Too small, increase
            } else {
                end = mid; // Try smaller max sum
            }
        }
        return end;
    }
}
