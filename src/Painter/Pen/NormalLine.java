package Painter.Pen;

import javafx.scene.input.MouseEvent;

/**
 * NormalLine 右クリック・ドラッグ時に線を描写する。
 */
public class NormalLine extends PenBase {
    public void mousePressed(MouseEvent event) {
        graphicsContext.beginPath();
        graphicsContext.moveTo(event.getX(), event.getY());
        graphicsContext.stroke();
        this.eventCount++;
    }

    public void mouseDragged(MouseEvent event) {
        graphicsContext.lineTo(event.getX(), event.getY());
        graphicsContext.stroke();
        this.eventCount++;
    }
}