import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileToStr {
    /**
     * 从文件中读取内容并将其转换为字符串。
     *
     * @param filePath 要读取的文件的路径
     * @return 文件内容的字符串表示
     * @throws IOException 如果发生IO错误，如文件不存在或读取失败
     */
    public static String readFileToString(String filePath) throws IOException {
        // 创建一个 StringBuilder 用于存储文件内容
        StringBuilder content = new StringBuilder();
        
        // 使用 try-with-resources 打开文件并创建 BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // 逐行读取文件内容并追加到 StringBuilder
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        
        // 将 StringBuilder 中的内容转换为字符串并返回
        return content.toString();
    }
}
