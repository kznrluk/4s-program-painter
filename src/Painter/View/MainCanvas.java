package Painter.View;

import Painter.Pen.PenBase;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

class MainCanvas {
    final private static int CANVAS_SIZE_X = 500;
    final private static int CANVAS_SIZE_Y = 500;

    private final Canvas canvas;
    private PenBase currentPen;
    private final StackPane area;
    private Color currentColor;

    MainCanvas() {
        this.area = new StackPane();
        this.canvas = new Canvas(CANVAS_SIZE_X, CANVAS_SIZE_Y);
        this.area.getChildren().add(this.canvas);
        this.area.setStyle("-fx-background-color: white");
    }

    /**
     * ペンを設定する。
     * @param pen 利用するペン
     */
    void setPen(PenBase pen){
        this.currentPen = pen;
        this.currentPen.setCanvas(this.canvas);
        this.currentPen.updateColor(this.currentColor);
    }

    /**
     * リセットボタンが押されたときの動作。
     */
    void reset() {
        this.currentPen.clearAll(this.canvas.getWidth(), this.canvas.getHeight());
    }

    /**
     * ペン色を設定する。
     * @param c 指定する色
     */
    void setColor(Color c) {
        this.currentColor = c;
        this.currentPen.updateColor(c);
    }

    /**
     * キャンバス上で行われるイベントをGraphics Contextに橋渡しする。
     */
    void initEvents() {
        this.canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> currentPen.mousePressed(event));

        this.canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> currentPen.mouseDragged(event));
    }

    StackPane getPane() {
        return this.area;
    }

    Canvas getCanvas() {
        return this.canvas;
    }

}