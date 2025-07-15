# 🧵 Longest Common Prefix

## 🔍 Problem Statement
Write a function to find the longest common prefix string amongst an array of strings.

📌 Example:
- Input: strs = ["flower","flow","flight"]
- Output: "fl"

- Input: strs = ["dog","racecar","car"]
- Output: ""  
Explanation: There is no common prefix among the input strings.

---

## 💡 Logic & Intuition
- Start with the first string as the initial prefix.
- For every other string, check character by character whether it matches the current prefix.
- Build a temporary prefix based on matching characters.
- If at any point the prefix becomes empty, return "" immediately.

---

## ⚙️ Approach
1. If array is empty → return "".
2. If array has only one string → return that string.
3. Set prefix = strs[0].
4. For each string from index 1 to end:
   - Compare it with current prefix character by character.
   - Build a new prefix with matching characters only.
   - Update prefix.
   - If prefix becomes empty, break early.
5. Return the prefix.

---

## ✅ Code (Java)
```java
public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    if (strs.length == 1) return strs[0];

    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
        StringBuilder tempPre = new StringBuilder();
        String curr = strs[i];

        for (int j = 0; j < Math.min(prefix.length(), curr.length()); j++) {
            if (prefix.charAt(j) == curr.charAt(j)) {
                tempPre.append(prefix.charAt(j));
            } else {
                break;
            }
        }

        prefix = tempPre.toString();
        if (prefix.isEmpty()) return "";
    }

    return prefix;
}
