package guava.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author maqidi
 * @date 2021/11/5 10:51 上午
 */
@Data
@AllArgsConstructor
public class Edge {
    /**
     * 边的初始点id
     */
    private Long start;
    /**
     * 边的截止点id
     */
    private Long end;
}
