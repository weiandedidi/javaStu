package guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author maqidi
 * @date 2021/11/29 8:04 下午
 */
@Builder
@Data
public class MapperTest {
    private String name;
    private int age;

    public static void main(String[] args) {
        MapperTest mapperTest = new MapperTest("name", 16);
        String ext = new Gson().toJson(mapperTest);
        System.out.println(ext);
        MapperTest newTest = new Gson().fromJson(ext, MapperTest.class);
        System.out.println(newTest);

        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 1; i < 10; i++) {
            map.put(i, i);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(v);
            if (k == 5) {
                System.out.println("日你大爷");
                return;
            }
            System.out.println(k + "不日");
        }
    }
}
