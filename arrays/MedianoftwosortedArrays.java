# 🧮 Median of Two Sorted Arrays (Merge Approach)

## 🔍 Problem Statement
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

📌 Example:
- Input: nums1 = [1, 3], nums2 = [2] → Output: 2.0  
- Input: nums1 = [1, 2], nums2 = [3, 4] → Output: 2.5

---

## 💡 Logic & Intuition
- Merge the two sorted arrays into one sorted list using two-pointer technique (like in merge sort).
- If total number of elements is odd, return the middle one.
- If even, return the average of the two middle elements.

---

## ⚙️ Approach
1. Initialize two pointers i and j at 0 for nums1 and nums2.
2. Traverse both arrays and compare elements.
3. Add the smaller element to a merged list (arr3).
4. After merging, find the median:
   - If length is odd: return middle element.
   - If length is even: return average of two middle elements.

| i | nums1\[i] | j | nums2\[j] | Compare    | Add → arr3    |
| - | --------- | - | --------- | ---------- | ------------- |
| 0 | 1         | 0 | 2         | 1 < 2      | \[1]          |
| 1 | 3         | 0 | 2         | 3 > 2      | \[1, 2]       |
| 1 | 3         | 1 | 4         | 3 < 4      | \[1, 2, 3]    |
| 2 | —         | 1 | 4         | nums1 done | \[1, 2, 3, 4] |

---

## ✅ Code (Java)
```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    List<Integer> arr3 = new ArrayList<>();
    int i = 0, j = 0;

    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
            arr3.add(nums1[i++]);
        } else {
            arr3.add(nums2[j++]);
        }
    }

    while (i < nums1.length) {
        arr3.add(nums1[i++]);
    }

    while (j < nums2.length) {
        arr3.add(nums2[j++]);
    }

    int n = arr3.size();
    if (n % 2 == 1) {
        return (double) arr3.get(n / 2);
    } else {
        return ((double) arr3.get(n / 2) + (double) arr3.get((n / 2) - 1)) / 2.0;
    }
}
