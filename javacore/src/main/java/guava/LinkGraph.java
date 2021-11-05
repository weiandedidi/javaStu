package guava;

import java.util.List;

/**
 * 设备存储的链路图
 *
 * @author maqidi
 * @date 2021/11/5 10:55 上午
 */
public class LinkGraph {
    /**
     * 链路图所有节点的list
     */
    List<DeviceUnitNode> nodeList;
    /**
     * 所有节点的有向边
     */
    List<Edge> edgeList;
}
