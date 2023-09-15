import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StrToFile {
    /**
     * 将字符串写入文件。
     *
     * @param filePath 要写入的文件的路径
     * @param content  要写入文件的字符串内容
     * @throws IOException 如果发生IO错误，如文件无法创建或写入失败
     */
    public static void writeStringToFile(String filePath, String content) throws IOException {
        // 使用 try-with-resources 打开文件并创建 BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // 将字符串写入文件
            writer.write(content);
        }
    }
}
