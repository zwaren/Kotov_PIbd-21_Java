import javax.swing.*;
import java.awt.*;

public class PanelDepo extends JPanel {
    private Depo<ITransport> depo;

    public void setDepo(Depo<ITransport> depo) {
        this.depo = depo;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if (depo != null) {
            depo.Draw(g);
        }
    }
}
