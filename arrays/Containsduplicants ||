# ✅ Contains Duplicate II

🔹 Intuition: Use a sliding window + set to check if any duplicate exists within the last k indices.

---

## 🔍 Problem Statement
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that:
- nums[i] == nums[j]
- abs(i - j) ≤ k

📌 Example:
- Input: nums = [1,2,3,1], k = 3  
  Output: true

- Input: nums = [1,0,1,1], k = 1  
  Output: true

- Input: nums = [1,2,3,1,2,3], k = 2  
  Output: false

---

## 💡 Logic & Intuition
- Maintain a sliding window of size k using a HashSet.
- As we iterate:
  - If current element is already in the set → found duplicate → return true.
  - Else, add the current number to the set.
  - If the window size exceeds k, remove the oldest element (nums[l]) from the set.
- Return false if no duplicates found within k range.

---

## ⚙️ Approach
1. Initialize two pointers: l (left) and r (right).
2. Iterate r from 0 to end of array:
   - If nums[r] already in set → return true.
   - Else add nums[r] to set.
   - If window size > k → remove nums[l] and increment l.
3. If no match found, return false.

---

## ✅ Code (Java)
```java
public boolean containsNearbyDuplicate(int[] nums, int k) {
    int l = 0;
    Set<Integer> set = new HashSet<>();

    for (int r = 0; r < nums.length; r++) {
        if (set.contains(nums[r])) return true;

        set.add(nums[r]);

        if ((r - l + 1) > k) {
            set.remove(nums[l]);
            l++;
        }
    }

    return false;
}
