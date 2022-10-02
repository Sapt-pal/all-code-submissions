/* Problem Statement:

A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"

To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

    "AAJF" with the grouping (1 1 10 6)
    "KJF" with the grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

 

Constraints:

    1 <= s.length <= 100
    s contains only digits and may contain leading zero(s).



*/

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] Arr = new int[n + 1];
        Arr[0] = 1;
        if (s.charAt(0) == 0) {
            Arr[1] = 0;
        }
        else {
            Arr[1] = 1;
        }
        for (int indx = 2; indx <= n; indx++) {
            int Last = Integer.valueOf(s.substring(indx - 1, indx));
            int second_Last = Integer.valueOf(s.substring(indx - 2, indx));
            if (Last >= 1 && Last <= 9)
               Arr[indx] += Arr[indx - 1];
            if (second_Last >= 10 && second_Last <= 26)
                Arr[indx] += Arr[indx - 2];
        }
        return Arr[n];
    }
}


/* Ultra code version

class Solution{public int numDecodings(String s){if(s==null || s.length()==0)return 0;int n=s.length();int[] L=new int[n + 1];L[0]=1;L[1]=s.charAt(0)=='0'?0:1;for(int i=2;i<=n;i++){int p=Integer.valueOf(s.substring(i-1,i));int s_p=Integer.valueOf(s.substring(i-2,i));if(p>=1 && p<=9)L[i]+=L[i-1];if(s_p>=10 && s_p<=26)L[i]+=L[i-2];}return L[n];}}

*/
