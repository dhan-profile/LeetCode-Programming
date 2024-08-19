class Solution {
public int minSteps(int n) {
    int res = 0;
    for(int i=2;i<=n;i++){
        while(n%i == 0){
            res+= i;
            n=n/i;
        }
    }
    return res;
}
}