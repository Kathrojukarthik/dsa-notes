# 🧹 Remove Duplicates from Sorted Array

## 🔍 Problem Statement
Given a sorted array nums, remove the duplicates in-place such that each unique element appears only once and return the new length.

📌 Example:
Input: nums = [1,1,2]  
Output: 2, with nums modified to [1,2,_]

Input: nums = [0,0,1,1,1,2,2,3,3,4]  
Output: 5, with nums modified to [0,1,2,3,4,_...]

---

## 💡 Logic & Intuition
- Since the array is sorted, duplicates will be next to each other.
- We can use a "slow" pointer (uni) to track the position of the last unique element.
- As we iterate with a "fast" pointer (i), whenever a new unique element is found, move it to the next position after uni.

---

## ⚙️ Approach
1. Initialize uni = 0 (the index of last unique element).
2. Start iterating from index i = 1.
3. If nums[uni] != nums[i], it means a new unique element is found.
4. Increment uni and copy nums[i] to nums[uni].
5. Finally, return uni + 1 → which is the count of unique elements.

---

## ✅ Code (Java)
```java
public int removeDuplicates(int[] nums) {
    int uni = 0;

    for (int i = 1; i < nums.length; i++) {
        if (nums[uni] != nums[i]) {
            uni++;
            nums[uni] = nums[i];
        }
    }

    return uni + 1;
}
