import javax.swing.*;
import java.awt.*;

public class PanelLocomotive extends JPanel {
    private ITransport transport;

    public void setTransport(ITransport transport) {
        this.transport = transport;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if (transport != null) {
            transport.DrawTransport(g);
        }
    }
}
