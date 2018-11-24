package Painter.Controller;

import Painter.Pen.*;

/**
 * ペン インスタンスファクトリ
 */
public class PenSelector {
    public static PenBase getPen(int id) {
        // TODO より良い選択方法を
        if(id == 0){
            return new NormalLine();
        } else if (id == 1) {
            return new CircleLine();
        } else if(id == 2) {
            return new CircleLineWithLimit();
        } else if(id == 3) {
            return new CircleLineWithScaleChange();
        } else if(id == 4) {
            return new CircleLineWithLine();
        } else if(id == 5) {
            return new RectLine();
        }

        return new NormalLine();
    }
}
