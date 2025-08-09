
---

## 💡 Logic & Intuition
- Eating speed is inversely related to total hours needed.  
- Lower speed → more hours; higher speed → fewer hours.  
- This pattern allows **binary search** on possible speeds.  
- Lower bound = `1` (slowest possible).  
- Upper bound = `max(piles)` (fastest needed).  
- Test each mid-speed, calculate total hours:
  - If it exceeds `h`, need faster speed.
  - Else, can try slower to minimize k.

---

## ⚙️ Approach
1. **Set bounds:** `low = 1`, `high = max(piles)`.  
2. **Binary search:**
   - `mid = (low + high) / 2`
   - Compute `hours` = sum over piles: `(pile + mid - 1) / mid` (integer ceil).  
   - If `hours > h` → too slow → `low = mid + 1`.  
   - Else → possible answer → `high = mid`.  
3. Return `low` after loop ends.

---

## ⏱ Complexity
- **Time:** `O(n log maxPile)` — binary search times hour calculation.  
- **Space:** `O(1)` — no extra space apart from variables.  

---

## 🖥 Java Code
```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        
        // Find the maximum pile size
        for (int num : piles) {
            max = Math.max(max, num);
        }
        
        return binarySearch(piles, h, min, max);
    }
    
    static int binarySearch(int[] piles, int h, int start, int end) {
        while (start < end) {
            int hours = 0;
            int mid = start + (end - start) / 2;
            
            // Calculate total hours needed at speed mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // ceil(pile / mid)
            }
            
            if (hours > h) {
                start = mid + 1; // Need faster speed
            } else {
                end = mid; // Try slower speed
            }
        }
        return end;
    }
}
