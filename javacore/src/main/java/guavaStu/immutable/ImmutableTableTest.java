package guavaStu.immutable;

import com.google.common.collect.ImmutableTable;

/**
 * @author maqidi
 * @date 2021/12/29 4:55 下午
 */
public class ImmutableTableTest {
    public static void main(String[] args) {
        ImmutableTable<Integer, Integer, String> table = ImmutableTable.<Integer, Integer, String>builder()
                .put(1, 1, "3")
                .put(1, 2, "4")
                .put(100, 1, "5").build();
    }
}