package higer;

import javax.swing.text.Document;

public interface PaperSHredder {
    void shred(Document d);
    void shredAll(Document[] d);
}
