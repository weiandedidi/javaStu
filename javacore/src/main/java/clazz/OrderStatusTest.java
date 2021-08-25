package clazz;

/**
 * @author maqidi
 * @date 2020/8/3 下午9:13
 */
public class OrderStatusTest {
    public static void main(String[] args) {
        int normalType = 2;
        OrderStatus orderStatus = OrderStatus.getTypeByValue(normalType);
        System.out.println(orderStatus.message);
        System.out.println("\"meituan\" = " + "meituan");
    }
}
