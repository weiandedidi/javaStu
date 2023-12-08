package util;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 使用jar包的加载顺序，然后通过diff软件分析  打包后的jar包的文件顺序大小
 * diff软件 有Beyond Compare
 * 分析jar包的加载顺序
 *
 * @author maqidi
 * @date 2023/12/5 5:55 PM
 */
public class AnalysisJarUrl {


    public static void main(String[] args) throws IOException {
        //prod
//        URL rootDirURL = new URL("jar:file:/Users/qidi/Downloads/3d9db0e9ac1c104f0da0b302d82d9913366c4934069ddc295a8db5f402160df0_layer/target/uwmsscheduler-server-3.6.3.1.jar!/BOOT-INF/classes");
        //st
//        URL rootDirURL = new URL("jar:file:/Users/qidi/Downloads/a042b5b9f8cc51968e94147f0fea19d8eb9f1a87fe6cb8df856974b4e335585d_layer/target/uwmsscheduler-server-3.6.3.1.jar!/BOOT-INF/classes");
        //高兹包
//        URL rootDirURL = new URL("jar:file:/Users/qidi/Downloads/8fc4a62b3f56e911b590e0e321b336b58015a2d4f00dd4c36161ca1bcd81255c_layer/target/uwmsscheduler-server-3.6.3.1.jar!/BOOT-INF/classes");
        //修改后的新包
        URL rootDirURL = new URL("jar:file:/Users/qidi/Downloads/fdcfb2566a5fc5af3c59817ae1c1f0912ed52c57ae317f0c9c06eb4eaf41ae18_layer/target/uwmsscheduler-server-3.6.3.1.jar!/BOOT-INF/classes");
        URLConnection con = rootDirURL.openConnection();
        JarURLConnection jarCon = (JarURLConnection) con;
        JarFile jarFile = jarCon.getJarFile();

        for (Enumeration<JarEntry> entries = jarFile.entries(); entries.hasMoreElements(); ) {
            JarEntry entry = entries.nextElement();
            String entryPath = entry.getName();
            System.out.println(entryPath);
        }
    }
}
