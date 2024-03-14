package lombok;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author maqidi
 * @date 2024/2/29 3:44 PM
 */
public class SneakyThrowsDto {

    @SneakyThrows()
    public void readFile(String path) {
        // 无需显式处理 FileNotFoundException
        FileInputStream fileInputStream = new FileInputStream(path);
        // do something
    }
}
