import com.google.common.collect.Lists;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author qidi
 * @date 2019-04-24 11:59
 */
public class MapTest {

    public static void main(String[] args) {
        Aoo aoo = new Aoo(new HashMap<Integer, String>() {
            {
                put(1, "1");
                put(2, "2");
                put(3, "3");
            }
        });

        Map<Integer, String> map = aoo.getMap();
        map.remove(2);
        map.put(4, "4");

        System.out.println(aoo.getMap().get(4));

        List<Boo> booList = Lists.newArrayList();
        Map<Integer, String> boxId2ErrorCode = booList.stream().filter(boo -> null != boo.getAge()).collect(Collectors.toMap(Boo::getAge, Boo::getName, (k1, k2) -> k1));

        List<Integer> list = Lists.newArrayList(1, 2, 3);
        System.out.println(new Gson().toJson(list));

    }

    @Data
    @AllArgsConstructor
    public static class Aoo {
        private Map<Integer, String> map;
    }

    @Data
    public static class Boo {
        Integer age;
        String name;
    }

}
