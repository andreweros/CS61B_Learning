package higer;

import javax.swing.text.Document;

public abstract class DeluxeModel implements PaperSHredder {
    public int count = 0;
    public int count() {
        return count;
    }

    public abstract void shredAll(Document[] d);

    public abstract void shred(Document d);

    public abstract void connectToWifi();

}
