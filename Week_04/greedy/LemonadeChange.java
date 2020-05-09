package greedy;

public class LemonadeChange {

    public boolean lemonadeChangeClean(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five ++;
            else if (i == 10) { five--; ten++; }
            else if (ten > 0) { ten--; five--; }
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) {
                five ++;
            }
            else if (i == 10) {
                if (five == 0) {
                    return false;
                }
                ten ++;
                five --;
            }
            else {
                if (five > 0 && ten > 0) {
                    ten --;
                    five --;
                }
                else if (five > 2) {
                    five -= 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
