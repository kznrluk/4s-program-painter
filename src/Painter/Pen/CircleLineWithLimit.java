package Painter.Pen;

import javafx.scene.input.MouseEvent;

/**
 * CircleLineWithLimit CircleLine + 100回以下の場合のみ描写する。
 */
public class CircleLineWithLimit extends CircleLine {
    final private static int LIMIT = 100;

    @Override
    public void mouseDragged(MouseEvent event) {
        if(this.eventCount < LIMIT) {
            super.mouseDragged(event);
        }
    }
}
