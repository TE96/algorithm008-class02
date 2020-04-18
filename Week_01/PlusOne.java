/**
 * 思路：
 * 从最后一位开始逐位+1,
 * 如果不需要进位就可以直接返回，有进位则循环继续
 * 如 999 + 1 = 1000 的特殊情况需要开辟新数组
 * @author fuwuchen
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i --) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
