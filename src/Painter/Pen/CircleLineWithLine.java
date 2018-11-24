package Painter.Pen;

import javafx.scene.input.MouseEvent;

/**
 * CircleLineWithLine CircleLine + 円描写時に直前に生成された円との間に線を生成する。
 */
public class CircleLineWithLine extends CircleLine {
    private final double[] previousCoord = {0, 0};

    @Override
    public void mouseDragged(MouseEvent event) {
        super.mouseDragged(event);

        // 座標が変化している => すでに円が生成されている場合に線を描写
        if(this.previousCoord[0] != 0){
            this.graphicsContext.strokeLine(event.getX(), event.getY(), this.previousCoord[0], this.previousCoord[1]);
        }

        this.previousCoord[0] = event.getX();
        this.previousCoord[1] = event.getY();
    }

    @Override
    public void clearAll(double x, double y) {
        super.clearAll(x,y);
        this.previousCoord[0] = 0;
        this.previousCoord[1] = 0;
    }
}
