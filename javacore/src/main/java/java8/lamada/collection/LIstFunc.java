package java8.lamada.collection;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author maqidi
 * @date 2022/1/21 11:08 上午
 */
public class LIstFunc {
    public static void main(String[] args) {
        //测试集合移除
        List<Integer> list = Lists.newArrayList(1, 3, 5, 7, 9);
        list.removeIf(o -> o > 5);
        System.out.println(list);
    }
}
