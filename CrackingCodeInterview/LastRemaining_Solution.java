package CrackingCodeInterview;
//孩子们的游戏
public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1) return -1;
        if(n == 1) return 0;
        return (LastRemaining_Solution(n - 1, m)+m)%n ;
    }

    // TC: O(n) SC: O(1)
    public int LastRemaining_Solution2(int n, int m)
    {
    if(n==0||m==0)return -1;
    int s=0;
    for(int i=2;i<=n;i++)
    {
        s=(s+m)%i;
    }
    return s ;
    }

}
