package java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 测试list 和 stack转化
 *
 * @author maqidi
 * @date 2022/10/17 4:44 PM
 */
public class ListAndStack {
    public static void main(String[] args) {
        Stack<Aoo> stack = new Stack<>();
        stack.push(new Aoo("a", 1));
        stack.push(new Aoo("b", 2));
        stack.push(new Aoo("c", 3));
        stack.push(new Aoo("d", 4));

        List<Aoo> aooList = new ArrayList<>(stack);
        System.out.println(aooList);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().getName());
        }
        String ab = "{\"status\":4,\"robotId\":\"M1\",\"__isset_bit_vector\":[1]}";
    }

    @Data
    @AllArgsConstructor
    public static class Aoo {
        /**
         * 名称
         */
        private String name;
        /**
         * 年龄
         */
        private Integer age;

    }
}
