package wordcheck;

import com.google.gson.Gson;
import com.hankcs.algorithm.AhoCorasickDoubleArrayTrie;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 使用acdat词表进行测试判断，进行词语分类的判断
 *
 * @author maqidi
 * @version 1.0
 * @create 2025-01-15 10:17
 */
public class AcdatCheckDemo {
    @Test
    public void test() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("cat", "政治");
        dictionary.put("dog", "色情");
        dictionary.put("car", "违法");
        dictionary.put("chase", "涉习");
        // 2. 构建AC自动机
        AhoCorasickDoubleArrayTrie<String> acdat = new AhoCorasickDoubleArrayTrie<>();
        acdat.build(dictionary);

        // 3. 待检索的文本
        String text = "The cat chased the dog near the car.";

        // 4. 执行匹配
        List<AhoCorasickDoubleArrayTrie.Hit<String>> hits = acdat.parseText(text);

        // 5. 输出结果
        List<HitInfo> hitInfos = hits.stream().map(hit -> HitInfo.fromAhoCorasickHit(hit, text)).collect(Collectors.toList());
        System.out.println(new Gson().toJson(hitInfos));
    }

    @Data
    @Builder
    public static class HitInfo {
        //分类
        private String category;
        private String word;    //命中的词
        private int start;      // 词的开始位置
        private int end;        // 词的结束位置

        // 用于从 AhoCorasickDoubleArrayTrie.Hit<String> 创建自定义的 Hit 对象
        public static HitInfo fromAhoCorasickHit(AhoCorasickDoubleArrayTrie.Hit<String> ahoHit, String text) {
            if (ahoHit == null) {
                return null;
            }
            return HitInfo.builder()
                    .category(ahoHit.value)
                    .word(text.substring(ahoHit.begin, ahoHit.end))
                    .start(ahoHit.begin)
                    .end(ahoHit.end)
                    .build();
        }
    }
}
