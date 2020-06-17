package string;

public class StringToIntegerAtoI {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        // 去掉空格
        while (str.charAt(index) == ' ' && index < str.length()) {
            index ++;
            if (index == str.length()) {
                return 0;
            }
        }
        // 判断正负号
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index ++;
        }
        // 处理剩余字符
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            // 不是数字
            if (digit < 0 || digit > 9) {
                break;
            }
            // 是否溢出
            if (Integer.MAX_VALUE / 10 < total ||
                    Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
}
