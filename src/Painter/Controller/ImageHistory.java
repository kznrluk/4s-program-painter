package Painter.Controller;

import javafx.scene.image.WritableImage;

import java.util.ArrayDeque;

public class ImageHistory {
    private ArrayDeque<WritableImage> history;
    private ArrayDeque<WritableImage> undid;

    public ImageHistory(){
        this.history = new ArrayDeque<>();
        this.undid = new ArrayDeque<>();
    }

    public void add(WritableImage image) {
        history.addLast(image);
        undid.clear();
        //undid.addLast(image);
    }

    public WritableImage getLast(WritableImage image) {
        undid.addLast(image);
        return history.removeLast();
    }

    public WritableImage redo(WritableImage image) {
        history.addLast(image);
        return undid.removeLast();
    }
}
