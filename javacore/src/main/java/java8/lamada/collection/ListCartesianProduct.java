package java8.lamada.collection;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 测试list的笛卡尔积
 *
 * @author maqidi
 * @date 2021/12/24 4:37 下午
 */
public class ListCartesianProduct {
    public static void main(String[] args) {
        List<Integer> startList = Lists.newArrayList(1, 2);
        List<Integer> endList = Lists.newArrayList(4, 5, 6);
        System.out.println(Lists.cartesianProduct(startList, endList));

    }
}
