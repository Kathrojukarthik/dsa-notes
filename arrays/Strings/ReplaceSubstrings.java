You're given a string s consisting only of 'Q', 'W', 'E', and 'R'. A balanced string is one where each character appears exactly n/4 times.

Your task:
Find the minimum length of a substring that can be replaced with any other string of the same length to make the whole string balanced.

Examples:
Input: s = "QWER" → Output: 0

Input: s = "QQWE" → Output: 1

Input: s = "QQQW" → Output: 2

Input: s = "QQQQ" → Output: 3

💡 Logic & Intuition
Step 1: Count how many times each character appears.

Step 2: If all characters are already ≤ n/4 → return 0.

Step 3: Use two pointers (l, r) and a sliding window:

Shrink from left while the characters outside the window are balanced.

Track the minimum length of such window.

⚙️ Approach
Count the frequency of all characters in s.

Calculate target = s.length() / 4.

If all characters ≤ target → already balanced → return 0.

Initialize minlen = s.length().

Use two pointers (l and r) for sliding window:

For each r, reduce frequency from total.

While window is valid (outside characters ≤ target), update minlen and move l.

Restore the frequency as you slide l.

✅ Java Code
java
Copy
Edit
class Solution {
    public int balancedString(String s) {
        int target = s.length() / 4;
        int minlen = s.length();
        Map<Character, Integer> tot = new HashMap<>();

        // Count frequencies
        for (char c : s.toCharArray()) {
            tot.put(c, tot.getOrDefault(c, 0) + 1);
        }

        // If already balanced
        boolean isBal = true;
        for (char c : "QWER".toCharArray()) {
            if (tot.getOrDefault(c, 0) > target) {
                isBal = false;
            }
        }
        if (isBal) return 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            tot.put(c, tot.get(c) - 1);

            // Shrink window if valid
            while (l < s.length() && isBalanced(tot, target)) {
                minlen = Math.min(minlen, r - l + 1);
                char lc = s.charAt(l);
                tot.put(lc, tot.get(lc) + 1);
                l++;
            }
        }

        return minlen;
    }

    private boolean isBalanced(Map<Character, Integer> tot, int target) {
        for (char c : "QWER".toCharArray()) {
            if (tot.getOrDefault(c, 0) > target) {
                return false;
            }
        }
        return true;
    }
}
