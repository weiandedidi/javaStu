package java8;

import java.util.UUID;

/**
 * @author maqidi
 * @date 2022/12/22 12:01 PM
 */
public class TestBinary {
    public static final int ORDER_REDIRECT = 0b0100000;

    public static void main(String[] args) {
        int a = 0b0100001;
        int b = 0b0000001;
        System.out.println(ORDER_REDIRECT & a);
        System.out.println(ORDER_REDIRECT & b);
        int c = (int) (Math.random() * 10000);
        System.out.println(c);

    }
}
