package guava.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author maqidi
 * @date 2021/11/5 10:33 上午
 */
@Data
@AllArgsConstructor
public class DeviceUnitNode {
    /**
     * 设备存储的是逻辑设备id
     */
    private Long logicId;
    /**
     * baseInfoId   目的吐给前端，适用baseInfoId作为大线框的聚合
     */
    private Long baseInfoId;
    /**
     * 是否起始点
     */
    private boolean isFirst;
}
