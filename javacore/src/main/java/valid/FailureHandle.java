package valid;

public class FailureHandle {
    /**
     * 主键id
     * table.field : failure_handle.task_id
     */
    private Long taskId;

    /**
     * 仓库id
     * table.field : failure_handle.warehouse_id
     */
    private Long warehouseId;

    /**
     * 设备的主键id
     * table.field : failure_handle.device_id
     */
    private Long deviceId;

    /**
     * 设备类型
     * table.field : failure_handle.device_type
     */
    private Integer deviceType;

    /**
     * 设备类型名称
     * table.field : failure_handle.device_type_name
     */
    private String deviceTypeName;

    /**
     * 错误码
     * table.field : failure_handle.type
     */
    private Integer type;

    /**
     * 1-未处理 2-已处理 3-缺货
     * table.field : failure_handle.status
     */
    private Integer status;

    /**
     * 
     * table.field : failure_handle.ctime
     */
    private Long ctime;

    /**
     * 
     * table.field : failure_handle.utime
     */
    private Long utime;

    /**
     * 反馈信息
     * table.field : failure_handle.feedback
     */
    private String feedback;

    /**
     * 操作人员
     * table.field : failure_handle.op
     */
    private String op;

    /**
     * 硬件编号
     * table.field : failure_handle.rack_id
     */
    private Integer rackId;

    /**
     * 硬件名称
     * table.field : failure_handle.rack_name
     */
    private String rackName;

    /**
     * 错误信息说明
     * table.field : failure_handle.type_msg
     */
    private String typeMsg;

    /**
     * 交接货柜货箱号，使用,连接 如[ 12,13,14]
     * table.field : failure_handle.box_ids
     */
    private String boxIds;

    /**
     * 反馈如果是选择项，存储选项项的序号，英文逗号分隔
     * table.field : failure_handle.choice
     */
    private String choice;

    /**
     * get task_id
     *
     * @return failure_handle.task_id：主键id
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * set task_id
     *
     * @param taskId  主键id
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * get warehouse_id
     *
     * @return failure_handle.warehouse_id：仓库id
     */
    public Long getWarehouseId() {
        return warehouseId;
    }

    /**
     * set warehouse_id
     *
     * @param warehouseId  仓库id
     */
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * get device_id
     *
     * @return failure_handle.device_id：设备的主键id
     */
    public Long getDeviceId() {
        return deviceId;
    }

    /**
     * set device_id
     *
     * @param deviceId  设备的主键id
     */
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * get device_type
     *
     * @return failure_handle.device_type：设备类型
     */
    public Integer getDeviceType() {
        return deviceType;
    }

    /**
     * set device_type
     *
     * @param deviceType  设备类型
     */
    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * get device_type_name
     *
     * @return failure_handle.device_type_name：设备类型名称
     */
    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    /**
     * set device_type_name
     *
     * @param deviceTypeName  设备类型名称
     */
    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName == null ? null : deviceTypeName.trim();
    }

    /**
     * get type
     *
     * @return failure_handle.type：错误码
     */
    public Integer getType() {
        return type;
    }

    /**
     * set type
     *
     * @param type  错误码
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * get status
     *
     * @return failure_handle.status：1-未处理 2-已处理 3-缺货
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set status
     *
     * @param status  1-未处理 2-已处理 3-缺货
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get ctime
     *
     * @return failure_handle.ctime：
     */
    public Long getCtime() {
        return ctime;
    }

    /**
     * set ctime
     *
     * @param ctime  
     */
    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    /**
     * get utime
     *
     * @return failure_handle.utime：
     */
    public Long getUtime() {
        return utime;
    }

    /**
     * set utime
     *
     * @param utime  
     */
    public void setUtime(Long utime) {
        this.utime = utime;
    }

    /**
     * get feedback
     *
     * @return failure_handle.feedback：反馈信息
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * set feedback
     *
     * @param feedback  反馈信息
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback == null ? null : feedback.trim();
    }

    /**
     * get op
     *
     * @return failure_handle.op：操作人员
     */
    public String getOp() {
        return op;
    }

    /**
     * set op
     *
     * @param op  操作人员
     */
    public void setOp(String op) {
        this.op = op == null ? null : op.trim();
    }

    /**
     * get rack_id
     *
     * @return failure_handle.rack_id：硬件编号
     */
    public Integer getRackId() {
        return rackId;
    }

    /**
     * set rack_id
     *
     * @param rackId  硬件编号
     */
    public void setRackId(Integer rackId) {
        this.rackId = rackId;
    }

    /**
     * get rack_name
     *
     * @return failure_handle.rack_name：硬件名称
     */
    public String getRackName() {
        return rackName;
    }

    /**
     * set rack_name
     *
     * @param rackName  硬件名称
     */
    public void setRackName(String rackName) {
        this.rackName = rackName == null ? null : rackName.trim();
    }

    /**
     * get type_msg
     *
     * @return failure_handle.type_msg：错误信息说明
     */
    public String getTypeMsg() {
        return typeMsg;
    }

    /**
     * set type_msg
     *
     * @param typeMsg  错误信息说明
     */
    public void setTypeMsg(String typeMsg) {
        this.typeMsg = typeMsg == null ? null : typeMsg.trim();
    }

    /**
     * get box_ids
     *
     * @return failure_handle.box_ids：交接货柜货箱号，使用,连接 如[ 12,13,14]
     */
    public String getBoxIds() {
        return boxIds;
    }

    /**
     * set box_ids
     *
     * @param boxIds  交接货柜货箱号，使用,连接 如[ 12,13,14]
     */
    public void setBoxIds(String boxIds) {
        this.boxIds = boxIds == null ? null : boxIds.trim();
    }

    /**
     * get choice
     *
     * @return failure_handle.choice：反馈如果是选择项，存储选项项的序号，英文逗号分隔
     */
    public String getChoice() {
        return choice;
    }

    /**
     * set choice
     *
     * @param choice  反馈如果是选择项，存储选项项的序号，英文逗号分隔
     */
    public void setChoice(String choice) {
        this.choice = choice == null ? null : choice.trim();
    }
}