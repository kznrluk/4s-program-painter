package Painter.View;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainWindow extends Application {
    final private static int WINDOW_SIZE_X = 610;
    final private static int WINDOW_SIZE_Y = 500;

    public static void start() {
        launch();
    }

    @Override
    public void start(Stage stage) {
        HBox mainPane = new HBox();

        // キャンバス生成
        MainCanvas mainCanvas = new MainCanvas();
        mainCanvas.initEvents();

        // ツールバー生成
        Toolbar tb = new Toolbar();
        tb.setCanvas(mainCanvas);

        mainPane.getChildren().addAll(tb.getPane(), mainCanvas.getPane());

        // シーン生成
        Scene scene = new Scene(mainPane, WINDOW_SIZE_X, WINDOW_SIZE_Y);

        // マウスカーソルの変更
        mainCanvas.getCanvas().addEventHandler(MouseEvent.MOUSE_ENTERED, event -> scene.setCursor(Cursor.CROSSHAIR));
        mainCanvas.getCanvas().addEventHandler(MouseEvent.MOUSE_EXITED, event -> scene.setCursor(Cursor.DEFAULT));

        stage.setTitle("ネットワークプログラム応用演習 レポート課題 - Painter");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}