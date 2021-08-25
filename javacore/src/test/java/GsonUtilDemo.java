import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.assertj.core.util.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maqidi
 * @date 2020/11/4 下午9:35
 */
public class GsonUtilDemo {
    public static void main(String[] args) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", 4);
        resultMap.put("name", "异常处理");
        resultMap.put("count", 10);

//        System.out.println(new Gson().toJson(resultMap));

        FailureHandleCountVo vo = new FailureHandleCountVo(4, "异常处理", 10);
//        System.out.println(new Gson().toJson(vo));

        List<FailureHandleCountVo> todoList = Lists.newArrayList(new FailureHandleCountVo(4, "异常处理", 10), new FailureHandleCountVo(5, "xxx", 10));
        List<FailureHandleCountVo> finishList = Lists.newArrayList(new FailureHandleCountVo(4, "异常处理", 10), new FailureHandleCountVo(5, "xxx", 10));
        FailureHandleListVo listVo = FailureHandleListVo.builder()
                .todoList(todoList)
                .finishList(finishList).build();
        System.out.println(new Gson().toJson(listVo));

        Map<String, Object> listMap = new HashMap<>();
        listMap.put("todoList", todoList);
        listMap.put("finishList", finishList);
        System.out.println(new Gson().toJson(listMap));


    }

    @Data
    @AllArgsConstructor
    public static class FailureHandleCountVo {
        /**
         * umwsapi 服务中ModelTypeEnum种的类型显示，异常处理 type是4
         */
        private int type;
        /**
         * 异常处理
         */
        private String name;
        /**
         * 异常条数
         */
        private int count;
    }

    @Builder
    @Data
    public static class FailureHandleListVo {
        /**
         * 未完成的异常列表
         */
        private List<FailureHandleCountVo> todoList;
        /**
         * 已处理的异常列表
         */
        private List<FailureHandleCountVo> finishList;
    }
}
