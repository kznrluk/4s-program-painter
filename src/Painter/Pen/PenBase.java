package Painter.Pen;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * ペン ベースクラス
 */
public abstract class PenBase {
    int eventCount = 0;
    abstract public void setCanvas(Canvas canvas);
    abstract public void mouseDragged(MouseEvent event);
    abstract public void mousePressed(MouseEvent event);
    abstract public void clearAll(double X, double Y);
    abstract public void updateColor(Color c);
}
