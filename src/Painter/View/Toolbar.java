package Painter.View;

import Painter.Controller.PenSelector;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

class Toolbar {
    final private static int BUTTON_WIDTH = 120;
    final private static int VERTICAL_SPACING = 5;
    final private static int DEFAULT_PEN_ID = 0;
    final private static Color DEFAULT_PEN_COLOR = Color.GRAY;

    private MainCanvas cv;
    private Button reset;
    private ChoiceBox modeSelector;
    private ColorPicker currentColor;

    /**
     * キャンバスを登録し、各種機能の初期化を行う。
     *
     * @param cv MainCanvas インスタンス
     */
    void setCanvas(MainCanvas cv) {
        this.cv = cv;

        this.reset = new Button("Reset");
        this.reset.setMinWidth(BUTTON_WIDTH);

        this.currentColor = new ColorPicker(DEFAULT_PEN_COLOR);
        this.currentColor.setMaxWidth(BUTTON_WIDTH);

        this.modeSelector = new ChoiceBox();
        //noinspection unchecked
        this.modeSelector.setItems(FXCollections.observableArrayList(
                "NormalLine", "CircleLine", "課題2", "課題3", "課題5", "課題6"
        ));
        this.modeSelector.setMinWidth(BUTTON_WIDTH);

        // this.countInfo = new Text(10, 50, "This is a test");

        initEvent();
    }

    /**
     * ウィンドウ用Paneを取得する。
     *
     * @return ツールバー VBox
     */
    VBox getPane() {
        VBox pane = new VBox();
        pane.setSpacing(VERTICAL_SPACING);
        pane.getChildren().addAll(this.reset, this.modeSelector, currentColor);

        return pane;
    }

    /**
     * イベントの監視を開始する。
     */
    private void initEvent() {
        this.modeSelector.getSelectionModel().selectFirst();
        this.cv.setPen(PenSelector.getPen(DEFAULT_PEN_ID));
        cv.setColor(this.currentColor.getValue());

        this.modeSelector.getSelectionModel().selectedIndexProperty().addListener((obv, number, selected) -> cv.setPen(PenSelector.getPen((int)selected)));

        this.reset.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> cv.reset());

        this.currentColor.setOnAction((ActionEvent t) -> cv.setColor(this.currentColor.getValue()));
    }
}