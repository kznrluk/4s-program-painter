package Painter.Pen;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * NormalLine 右クリック・ドラッグ時に線を描写する。
 */
public class NormalLine extends PenBase {
    GraphicsContext graphicsContext;

    public void setCanvas(Canvas canvas) {
        this.graphicsContext = canvas.getGraphicsContext2D();
    }

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

    public void clearAll(double X, double Y) {
        graphicsContext.clearRect(0, 0, X, Y);
        this.eventCount = 0;
    }
    public void updateColor(Color c) {
        graphicsContext.setStroke(c);
    }
}