class Solution {
    public int passThePillow(int n, int time) {
        int person = 1;
        int direction = 1; // 1 means forward, -1 means backward

        for (int seconds = 1; seconds <= time; seconds++) {
            if (person == 1) {
                direction = 1; // Change direction to forward
            } else if (person == n) {
                direction = -1; // Change direction to backward
            }

            person += direction; // Move the pillow
        }

        return person;
    }
}