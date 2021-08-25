package valid;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * 用来承载FailureHandle关键字段的bo
 * 非嵌套验证
 *
 * @author maqidi
 * @date 2020/11/4 下午4:47
 */
@Builder
@Data
public class FailureHandleBo {


    /**
     * 仓库id
     * table.field : failure_handle.warehouse_id
     */
    @NonNull
    private Long warehouseId;

    /**
     * 设备的主键id
     * table.field : failure_handle.device_id
     */
    @NonNull
    private Long deviceId;

    /**
     * 设备类型
     */
    @NonNull
    private Integer deviceType;

    /**
     * 设备类型名称
     */
    @NotEmpty(message = "deviceTypeName 不能为空")
    private String deviceTypeName;

    /**
     * 错误码
     */
    @NonNull
    private Integer type;

    /**
     * 仓库内，硬件编号
     */
    @NotEmpty(message = "deviceCode 不能为空")
    private String deviceCode;

    /**
     * 硬件名称
     */
    @NotEmpty(message = "deviceName 不能为空")
    private String deviceName;

    /**
     * 1-未处理 2-已处理 3-缺货
     */
    @NonNull
    private Integer status;

    /**
     * 故障的交接货柜的故障柜门id
     */
    private String boxIds;
    /**
     * 错误信息说明
     */
    private String typeMsg;



    public static FailureHandle build(@Valid FailureHandleBo failureHandleBo) {
        FailureHandle failureHandle = new FailureHandle();

        failureHandle.setWarehouseId(failureHandleBo.getWarehouseId());
        failureHandle.setDeviceId(failureHandleBo.getDeviceId());


        failureHandle.setDeviceType(failureHandleBo.getDeviceType());
        failureHandle.setDeviceTypeName(failureHandleBo.getDeviceTypeName());

        failureHandle.setType(failureHandleBo.getType());
        failureHandle.setStatus(failureHandleBo.getStatus());
        failureHandle.setBoxIds(failureHandleBo.getBoxIds());
        failureHandle.setTypeMsg(failureHandleBo.getTypeMsg());

        //failureHandle的taskId是主键id不是 task的id切记！！！
        Integer rackId = Integer.parseInt(failureHandleBo.getDeviceCode());
        failureHandle.setRackId(rackId);
        //硬件名称
        failureHandle.setRackName(failureHandleBo.getDeviceName());

        return failureHandle;
    }

}
