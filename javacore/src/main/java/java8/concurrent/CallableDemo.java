package java8.concurrent;

import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.util.Optional;
import java.util.concurrent.Callable;

/**
 * callable的方法
 *
 * @author qidi
 * @date 2019-07-09 17:13
 */
public class CallableDemo {


    public static void main(String[] args) {
        Aoo aoo = new Aoo("aoo", 12);
        //做一些校验工作。
        int id = invoke(() -> getId(aoo));
        System.out.println("id 是" + id);
        System.out.println("asfads");
    }

    /**
     * 正常方法调用，返回线程的返回
     *
     * @param function
     * @param <T>
     * @return
     */
    public static <T> T invoke(Callable<T> function) {
        T t = null;
        try {
            t = function.call();
        } catch (IllegalArgumentException e) {
            System.out.println("打印参数不合理异常");
        } catch (Exception e) {
            System.out.println("我是特别大的异常");
        }
        return t;
    }

    public static Integer getId(Aoo aoo) {
        Preconditions.checkArgument(null != aoo.getId(), "id不能为空");
        return aoo.getId();
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Aoo {
        private String name;
        private Integer id;
    }
    //写一下md5的加密算法

}
