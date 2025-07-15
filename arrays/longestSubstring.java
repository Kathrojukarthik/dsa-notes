Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

ans:

Approach: Sliding Window using a Set to track unique characters.
 ->Time Complexity: O(n)

⚠-> Tricky: Correctly moving the left pointer when duplicates appear.

->Use Case: String pattern matching, windowed data analysis.
| r | s\[r] | Set     | Action                                     | l | Window | max |
| - | ----- | ------- | ------------------------------------------ | - | ------ | --- |
| 0 | 'a'   | {}      | Add 'a'                                    | 0 | \[a]   | 1   |
| 1 | 'b'   | {a}     | Add 'b'                                    | 0 | \[ab]  | 2   |
| 2 | 'c'   | {a,b}   | Add 'c'                                    | 0 | \[abc] | 3   |
| 3 | 'a'   | {a,b,c} | 'a' duplicate → remove s\[0]='a', l++      | 1 | \[bca] | 3   |
| 4 | 'b'   | {b,c,a} | 'b' duplicate → remove s\[1]='b', l++      | 2 | \[cab] | 3   |
| 5 | 'c'   | {c,a,b} | 'c' duplicate → remove s\[2]='c', l++      | 3 | \[abc] | 3   |
| 6 | 'b'   | {a,b,c} | 'b' duplicate → remove s\[3]='a', l++      | 4 | \[cb]  | 3   |
| 7 | 'b'   | {c,b}   | 'b' duplicate → remove s\[4]='c','b' → l++ | 6 | \[b]   | 3   |

Set<Character> set = new HashSet<>();
int l = 0, max = 0;

for (int r = 0; r < s.length(); r++) {
    char curr = s.charAt(r);

    // If current character is already in set, shrink the window from the left
    while (set.contains(curr)) {
        set.remove(s.charAt(l));
        l++;
    }

    // Add current character and calculate max window size
    set.add(curr);
    max = Math.max(max, r - l + 1);
}
return max;

