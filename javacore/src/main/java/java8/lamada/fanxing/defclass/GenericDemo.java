package java8.lamada.fanxing.defclass;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 泛型测试方法
 * 类上定义的泛型，规范参数属性类型
 * <p>
 * 方法上定义的泛型具有通用性
 *
 * @author qidi
 * @date 2019-11-25 18:06
 */
public class GenericDemo<T> {
    /**
     * 属性泛型
     */
    T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    //方法中定义的泛型和类上的泛型不一致
    public <T> void printInfo(T t) {
        System.out.println(t);
    }

    public <E> void printList(List<E> list) {
        list.forEach(System.out::print);
    }

    public static void main(String[] args) {
        GenericDemo<String> demo = new GenericDemo<>();
        //方法中的定义的泛型
        demo.printInfo(1);
        demo.printInfo("AAAAA");
        demo.printInfo(8.88f);

        List<Integer> list = Lists.newArrayList(1, 2, 3, 5, 6);
        demo.printList(list);


        GenericDemo<String> demo_1 = new GenericDemo<>();
        demo_1.setBody("q");
        System.out.println(demo_1.getBody());

        GenericDemo<Integer> demo_2 = new GenericDemo<>();
        demo_2.setBody(5);
        System.out.println(demo_2.getBody());

    }
}

