package Painter.Pen;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * ペン ベースクラス
 */
public abstract class PenBase {
    GraphicsContext graphicsContext;
    int eventCount = 0;

    abstract public void mouseDragged(MouseEvent event);
    abstract public void mousePressed(MouseEvent event);

    public void setCanvas(Canvas canvas) {
        this.graphicsContext = canvas.getGraphicsContext2D();
    }

    public void clearAll(double X, double Y) {
        graphicsContext.clearRect(0, 0, X, Y);
        this.eventCount = 0;
    }
    
    public void updateColor(Color c) {
        graphicsContext.setStroke(c);
    }
}
