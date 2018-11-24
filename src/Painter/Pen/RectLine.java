package Painter.Pen;

import javafx.scene.input.MouseEvent;

/**
 * RectLine マウスドラッグ時に四角いブラシで描写する。
 */
public class RectLine extends CircleLine {
    @Override
    public void mouseDragged(MouseEvent event) {
        this.graphicsContext.strokeRect(event.getX() - this.padding[0], event.getY() - this.padding[1], this.scale[0], this.scale[1]);
    }
}
