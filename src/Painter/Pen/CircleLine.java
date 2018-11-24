package Painter.Pen;

import javafx.scene.input.MouseEvent;

/**
 * CircleLine マウスドラッグ時に円形のブラシで描写する。
 */
public class CircleLine extends DrawFigure {
    @Override
    public void mouseDragged(MouseEvent event) {
        graphicsContext.strokeOval(event.getX() - this.padding[0], event.getY() - this.padding[1], this.scale[0], this.scale[1]);
        this.eventCount++;

        // 課題1
        System.out.println(this.eventCount);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        this.mouseDragged(event);
    }
}
