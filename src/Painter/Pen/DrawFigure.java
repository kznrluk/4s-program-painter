package Painter.Pen;

import javafx.scene.input.MouseEvent;

public abstract class DrawFigure extends PenBase {
    // マウスがクリックされた場所が中心になるようにパディングを行う
    final double[] scale = {30, 30};
    final double[] padding = {15, 15};

    public void mousePressed(MouseEvent event) {
        this.mouseDragged(event);
    }

    void setScale(double x, double y) {
        this.scale[0] = x;
        this.scale[1] = y;
        this.padding[0] = x / 2;
        this.padding[1] = y / 2;
    }
}
