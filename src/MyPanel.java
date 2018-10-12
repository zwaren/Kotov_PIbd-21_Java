import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private ITransport locomotive;

    public void setLocomotive(ITransport locomotive) {
        this.locomotive = locomotive;
    }

    public MyPanel(ITransport locomotive) {
        this.locomotive = locomotive;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (locomotive != null) {
            locomotive.DrawTransport(g);
        }
    }
}

