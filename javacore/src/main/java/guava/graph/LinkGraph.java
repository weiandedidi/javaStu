package guava.graph;

import com.google.common.collect.Lists;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 设备存储的链路图
 *
 * @author maqidi
 * @date 2021/11/5 10:55 上午
 */
@Data
@AllArgsConstructor
public class LinkGraph {
    /**
     * 链路图所有节点的list
     */
    List<DeviceUnitNode> nodeList;
    /**
     * 所有节点的有向边
     */
    List<Edge> edgeList;

    public static void main(String[] args) {
        //有向图，按插入顺序 不允许闭环
        MutableGraph<Long> graph = GraphBuilder.directed()
                .nodeOrder(ElementOrder.insertion())
                .allowsSelfLoops(true)
                .build();
        DeviceUnitNode node1 = new DeviceUnitNode(1L, 1L, true);
        DeviceUnitNode node2 = new DeviceUnitNode(2L, 2L, false);
        DeviceUnitNode node3 = new DeviceUnitNode(3L, 3L, false);
        DeviceUnitNode node4 = new DeviceUnitNode(4L, 4L, false);
        DeviceUnitNode node5 = new DeviceUnitNode(5L, 5L, false);
        List<DeviceUnitNode> nodeList = Lists.newArrayList(node1, node2, node3, node4, node5);
        nodeList.forEach(node -> {
            graph.addNode(node.getLogicId());
        });


        Edge edge1 = new Edge(node1.getLogicId(), node2.getLogicId());
        Edge edge2 = new Edge(node1.getLogicId(), node3.getLogicId());
        Edge edge3 = new Edge(node2.getLogicId(), node4.getLogicId());
        Edge edge4 = new Edge(node3.getLogicId(), node4.getLogicId());
        Edge edge5 = new Edge(node4.getLogicId(), node5.getLogicId());
        Edge edge6 = new Edge(node5.getLogicId(), node4.getLogicId());
        List<Edge> edgeList = Lists.newArrayList(edge1, edge2, edge3, edge4, edge5, edge6);
        for (Edge edge : edgeList) {
            graph.putEdge(edge.getStart(), edge.getEnd());
        }

        System.out.println(graph.predecessors(node4.getLogicId()));
        System.out.println(graph.successors(node5.getLogicId()));
        System.out.println(graph.edges());
        LinkGraph linkGraph = new LinkGraph(nodeList, edgeList);
        System.out.println(new Gson().toJson(linkGraph));

    }
}
