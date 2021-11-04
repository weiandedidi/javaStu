import org.apache.commons.lang.StringUtils;

import java.io.File;

/**
 * @author maqidi
 * @date 2021/9/23 2:50 下午
 */
public class TrueLove {
    /**
     * 一段找到真爱的代码
     *
     * @param file
     * @return
     */
    public String fineTrueLove(File file) {

        String trueLove = null;
        //真爱
        if (file.getName().endsWith("简历")) {
            trueLove = "简历邮箱：maqidi@meituan.com";
        } else {
            System.out.println("java ：找不到当前对象");
            trueLove = "世纪佳缘网";
        }
        return trueLove;
    }
}
