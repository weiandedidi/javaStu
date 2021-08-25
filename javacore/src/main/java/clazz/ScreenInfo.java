package clazz;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.assertj.core.util.Lists;

/**
 * @author maqidi
 * @date 2020/8/7 下午3:01
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ScreenInfo {
    /**
     * 租户id
     */
    private Long tenantId;
    /**
     * 仓库id
     */
    private Long warehouseId;
    /**
     * 推送的唯一id
     */
    private String unionId;
    /**
     * 设备名称
     */
    private String name;
    /**
     * 设备编号
     */
    private String code;

    public static void main(String[] args) {
        ScreenInfo screenInfo = new ScreenInfo();
        screenInfo.setTenantId(100010L);
        screenInfo.setWarehouseId(45678L);
        screenInfo.setUnionId("我是唯一id");
        screenInfo.setName("面销屏");
        screenInfo.setCode("x01");

        System.out.println(new Gson().toJson(Lists.newArrayList(screenInfo)));
    }
}
