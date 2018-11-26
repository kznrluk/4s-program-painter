package Painter.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class SaveAsPopup {
    final private static int WINDOW_SIZE_X = 300;
    final private static int WINDOW_SIZE_Y = 100;

    private Stage popUp;
    private TextField fileNameInput;
    private Boolean result = false;

    Boolean open() {
        popUp = new Stage();

        // ファイル名入力
        Text dirInfo = new Text("ファイルはPainterパッケージのある場所に保存されます。");
        fileNameInput = new TextField("myphoto");
        Text extInfo = new Text(".png");

        HBox inputFileNamePane = new HBox(fileNameInput, extInfo);

        // OK, キャンセルボタン
        Button ok = new Button("OK");
        Button reject = new Button("キャンセル");
        HBox buttons = new HBox(ok, reject);

        initButtonEvent(ok, reject);

        VBox mainPane = new VBox(new VBox(dirInfo, inputFileNamePane), buttons);

        // シーン生成
        Scene scene = new Scene(mainPane, WINDOW_SIZE_X, WINDOW_SIZE_Y);

        popUp.setTitle("名前をつけて保存");
        popUp.setResizable(false);
        popUp.setScene(scene);

        popUp.showAndWait();

        return this.result;
    }

    String getFileName() {
        return this.fileNameInput.getText();
    }

    private void initButtonEvent(Button ok, Button reject) {
        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            this.result = true;
            popUp.close();
        });

        reject.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> popUp.close());
    }
}
