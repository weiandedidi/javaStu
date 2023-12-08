import com.google.common.collect.Lists;
import org.apache.commons.lang.ObjectUtils;
import org.junit.Test;

import java.util.List;

/**
 * @author maqidi
 * @date 2021/3/26 下午2:37
 */
public class ListTesst {

    @Test
    public void testList() {
        List<Long> idList = Lists.newArrayList(1L, 2L, 3L);
        List<Long> idListV2 = Lists.newArrayList(3L, 2L, 3L);
//        idList.removeAll(idListV2);
        idListV2.removeAll(idList);

//        System.out.println(idList);
        System.out.println(idListV2);
    }

    @Test
    public void testListV2() {
        String[] strList = new String[]{"1", "5", "9"};
        List<String> idList = Lists.newArrayList(strList);
        System.out.println(idList);
    }

    @Test
    public void testEquals() {
        int one = 1;
        Integer no1 = new Integer(1);
        System.out.println(ObjectUtils.equals(one, no1));
        System.out.println(ObjectUtils.equals(null, no1));
    }

    @Test
    public void testAll() {
        List<Long> idList = Lists.newArrayList(1L, 2L, 3L);
        List<Long> idListV2 = Lists.newArrayList(3L, 2L, 3L);
        idList.addAll(Lists.newArrayList());
        System.out.println(idList);
    }

}
