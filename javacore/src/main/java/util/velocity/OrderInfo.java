package util.velocity;

import lombok.Data;

import java.util.List;

/**
 * 测试velocity的引擎模版
 *
 * @author maqidi
 * @date 2023/12/18 11:28 AM
 */
@Data
public class OrderInfo {

    private String orderId;
    private String userName;
    private String productName;
    private Double price;
    /**
     * 产地
     */
    private List<String> addressList;


    // getters and setters...

    public String formatOrderInfo(String template) {
        return String.format(template, orderId, userName, productName, price);
    }

}
