package clazz;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * 面销大屏的绑定返回
 *
 * @author maqidi
 * @date 2020/8/6 下午9:00
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SaleScreenBindInfo {
    /**
     * 服务端给客户颁发的唯一标识
     */
    private String browserId;

    /**
     * 面销屏Id
     */
    private String saleScreenId;

    public static void main(String[] args) {
        SaleScreenBindInfo saleScreenBindInfo = new SaleScreenBindInfo();
        saleScreenBindInfo.setBrowserId(UUID.randomUUID().toString().replace("-", ""));
        saleScreenBindInfo.setSaleScreenId("设备id");
        Gson gson = new Gson();
        System.out.println(gson.toJson(saleScreenBindInfo));
        saleScreenBindInfo.setBrowserId("012345");
        System.out.println(saleScreenBindInfo.getBrowserId().toString());
    }
}
