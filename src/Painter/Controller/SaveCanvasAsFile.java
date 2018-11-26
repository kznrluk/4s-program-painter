package Painter.Controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;

public class SaveCanvasAsFile {
    final private static int IMAGE_SIZE_X = 500;
    final private static int IMAGE_SIZE_Y = 500;

    public static String output(Canvas canvas, String fileName) throws Exception {
        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String filePath = "./" + fileName + ".png";

        if(classpath != null){
            filePath = classpath + fileName + ".png";
        }

        File fp = new File(filePath);
        WritableImage image = new WritableImage(IMAGE_SIZE_X, IMAGE_SIZE_Y);

        canvas.snapshot(null, image);

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", fp);
        } catch (Exception s) {
            throw new Exception("ファイル書き込みに失敗しました。");
        }

        return filePath;
    }
}
