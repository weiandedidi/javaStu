package java8;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * 测试gson
 *
 * @author maqidi
 * @date 2023/1/6 8:06 PM
 */
public class GsonTest {

    public static void main(String[] args) {
        MessageDto rack = new MessageDto(new ModelDto(1, Lists.newArrayList(new StatusDto("picker01", 1, 1), new StatusDto("picker02", 1, 2))), null);
        MessageDto agv = new MessageDto(new ModelDto(2, Lists.newArrayList(new StatusDto("agv01", 1, 1), new StatusDto("agv02", 1, 2))), null);
        //我要改 agv01的状态 为2


    }

    @Data
    @AllArgsConstructor
    public static class StatusDto {
        private String id;
        private Integer type;
        private Integer status;
    }

    @Data
    @AllArgsConstructor
    public static class MessageDto {
        private ModelDto current;
        private ModelDto report;
    }

    @Data
    @AllArgsConstructor
    public static class ModelDto {
        int deviceType;
        List<StatusDto> StatusDtoList;
    }
}
