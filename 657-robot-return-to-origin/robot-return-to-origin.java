class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') y++;
            if (move == 'D') y--;
            if (move == 'L') x--;
            if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}