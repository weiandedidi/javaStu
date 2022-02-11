package guava.graph;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 该用例是描述图像的存储，使用guava的graph工具
 * 详见：https://blog.csdn.net/hxyascx/article/details/99550530
 *
 * @author maqidi
 * @date 2021/11/4 8:23 下午
 */
public class GraphDataTest {

    public static void main(String[] args) {

        //有向图，按插入顺序 不允许闭环
        MutableGraph<Node> graph = GraphBuilder.directed()
                .nodeOrder(ElementOrder.insertion())
                .allowsSelfLoops(false)
                .build();
        Node node1 = new Node(1L, 1, true);
        Node node2 = new Node(2L, 2, false);
        Node node3 = new Node(3L, 3, false);
        Node node4 = new Node(4L, 4, false);
        Node node5 = new Node(5L, 5, false);
        Node node6 = new Node(6L, 6, false);
        Node node7 = new Node(7L, 7, false);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addNode(node5);
        graph.addNode(node6);
        graph.addNode(node7);


        graph.putEdge(node1, node2);
        graph.putEdge(node1, node3);
        graph.putEdge(node2, node4);
        graph.putEdge(node3, node4);
        graph.putEdge(node4, node5);

        System.out.println(graph.nodes());
//        System.out.println(graph.edges());

//        System.out.println(graph.edges());

//        System.out.println(graph.predecessors(node1));
//        System.out.println(graph.predecessors(node2));
//        System.out.println(graph.predecessors(node3));
//        System.out.println(graph.predecessors(node4));
        System.out.println(graph.successors(node6));
    }

    /**
     * 硬件节点Node
     */
    @Data
    @AllArgsConstructor
    private static class Node {
        Long id;
        int value;
        boolean isFirst;
    }

    /**
     * 边的数据结构
     */
    @Data
    @AllArgsConstructor
    public static class Edge {
        Long start;
        Long end;
    }
}


