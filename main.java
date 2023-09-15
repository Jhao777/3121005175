import java.io.*;

public class main {
        public static void main(String[] args) {
            //检查命令行参数数量是否正确
        if (args.length != 3) {
            System.err.println("Usage: java -jar main.jar <原文文件> <抄袭版论文文件> <答案文件>");
            System.exit(1);
        }

        // 从命令行参数获取文件路径
        String origFilePath = args[0];
        String plagiarizedFilePath = args[1];
        String answerFilePath = args[2];

        try {
            // 读取原文和抄袭版论文的内容
            String origContent = FileToStr.readFileToString(origFilePath);
            String plagiarizedContent = FileToStr.readFileToString(plagiarizedFilePath);

            // 计算相似度
            double similarity = Distance.calculateLevenshteinDistance(origContent, plagiarizedContent);

            // 将相似度写入答案文件
            StrToFile.writeStringToFile(answerFilePath, String.format("%.2f", similarity));
        } catch (IOException e) {
            // 捕捉并处理IO错误
            System.err.println("发生IO错误: " + e.getMessage());
            System.exit(1);
        }
    }
}
