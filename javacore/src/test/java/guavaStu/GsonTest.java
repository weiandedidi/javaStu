package guavaStu;

import com.google.gson.Gson;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * @author maqidi
 * @version 1.0
 * @create 2024-07-01 19:29
 */
public class GsonTest {
    @Test
    public void testGson() {
        Gson gson = new Gson();
        Object object = null;
        System.out.println(gson.toJson(object));

    }
}
