package Painter.Pen;

import javafx.scene.input.MouseEvent;

/**
 * CircleLineWithScaleChange 線描写毎にサイズを変更する。
 */
public class CircleLineWithScaleChange extends CircleLine {
    @Override
    public void mouseDragged(MouseEvent event) {
        if(this.eventCount % 2 == 0) {
            this.setScale(30, 30);
        } else {
            this.setScale(80,80);
        }

        super.mouseDragged(event);
    }
}
