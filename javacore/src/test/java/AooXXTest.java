import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @author maqidi
 * @date 2021/12/7 5:56 下午
 */
public class AooXXTest {

    @Test
    public void testAoo() {
        Boo boo = null;
        Aoo aoo = new Aoo(boo);
        System.out.println(aoo);
    }


    @Data
    @NoArgsConstructor
    public class Aoo {
        private String name;
        private int age;

        public Aoo(Boo boo) {
            if (null == boo) {
                return;
            }
            this.name = boo.getName();
            this.age = boo.getAge();
        }
    }

    @Data
    @AllArgsConstructor
    public class Boo {
        private String name;
        private int age;
    }

}
