import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private Locomotive locomotive;

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public MyPanel(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (locomotive != null) {
            locomotive.DrawLocomotive(g);
        }
    }
}

