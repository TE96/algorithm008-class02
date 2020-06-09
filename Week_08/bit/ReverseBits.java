package bit;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits1(int n) {
        int ans = 0, mask = 1;
        for (int i = 0; i < 32; i ++) {
            if ((n & mask) != 0) {
                ans |= 1 << (31 - i);
            }
            mask <<= 1;
        }
        return ans;
    }
    public int reverseBits2(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i ++) {
            ans = (ans << 1) + (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
