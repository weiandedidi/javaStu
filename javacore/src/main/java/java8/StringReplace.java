package java8;

import java.util.UUID;

/**
 * @author maqidi
 * @date 2022/12/21 10:17 AM
 */
public class StringReplace {
    public static void main(String[] args) {
        String wmOrderId = UUID.randomUUID().toString().substring(20);

        System.out.println(wmOrderId);
        System.out.println(wmOrderId.replaceAll("-", "_"));

    }
}
