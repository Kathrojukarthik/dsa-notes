# 🔠 Frequency Sort (Character Sort by Frequency)

## 🔍 Problem Statement
Given a string s, sort it in decreasing order based on the frequency of characters and return the sorted string.

### 📌 Examples:
- Input: "tree" → Output: "eetr" or "eert"
- Input: "cccaaa" → Output: "cccaaa" or "aaaccc"
- Input: "Aabb" → Output: "bbAa" or "bbaA"

---

## 💡 Intuition
We want to sort characters by how often they appear. We’ll use a HashMap to count frequency, then sort the entries, and build the final string.

---

## ⚙️ Approach
1. Traverse the string and store character frequencies in a HashMap.
2. Convert the map into a list of entries (char, freq).
3. Sort the list by frequency in descending order.
4. Build a new string by repeating each character frequency number of times using StringBuilder.
5. Return the result.

---

## 🧠 Dry Run
For s = "tree":

- Frequency Map: {t=1, r=1, e=2}
- Sorted Entries: [e=2, t=1, r=1]
- Result: "eetr" or "eert"

---

## ⏱ Time & Space Complexity
- Time Complexity: O(n log n) — due to sorting map entries
- Space Complexity: O(n) — for map, list, and result

---

## ✅ Java Code
```java
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Convert map to list and sort by frequency in descending order
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        // Step 3: Build the result string
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
