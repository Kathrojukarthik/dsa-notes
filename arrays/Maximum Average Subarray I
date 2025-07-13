# 📊 Maximum Average Subarray I

🔹 Intuition: Use a sliding window of size k to maintain the sum and track the maximum average efficiently.

---

## 🔍 Problem Statement
Given an integer array nums consisting of n elements and an integer k, find the contiguous subarray of length k that has the maximum average value and return this value. Answers within 10⁻⁵ of the actual answer will be accepted.

📌 Example:
- Input: nums = [1,12,-5,-6,50,3], k = 4  
  Output: 12.75  
  Explanation: Maximum average is (12 - 5 - 6 + 50)/4 = 51/4 = 12.75

- Input: nums = [5], k = 1  
  Output: 5.0

---

## 💡 Logic & Intuition
- Start by computing the sum of the first k elements.
- Slide the window by removing the first element of the previous window and adding the next element in the array.
- At each step, calculate the sum and update the maximum.
- Return the maximum sum divided by k to get the average.

---

## ⚙️ Approach
1. Initialize sum = sum of first k elements.
2. Set max = sum.
3. For each r = k to n-1:
   - Slide the window: sum += nums[r] - nums[r-k]
   - Update max if current sum is greater.
4. Return max / k.

---

## ✅ Code (Java)
```java
public double findMaxAverage(int[] nums, int k) {
    double sum = 0, maxlen = 0;

    for (int i = 0; i < k; i++) {
        sum += nums[i];
    }

    maxlen = sum;

    for (int r = k; r < nums.length; r++) {
        sum += nums[r] - nums[r - k];
        maxlen = Math.max(maxlen, sum);
    }

    return maxlen / k;
}
