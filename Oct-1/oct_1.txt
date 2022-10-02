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