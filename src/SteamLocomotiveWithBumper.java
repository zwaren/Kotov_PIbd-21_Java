import java.awt.*;

public class SteamLocomotiveWithBumper extends Locomotive {

    private boolean haveBumper;
    private boolean haveSteamEngine;
    private Color extraColor;

    public SteamLocomotiveWithBumper(
            int maxSpeed,
            float weight,
            Color mainColor,
            Color extraColor,
            boolean haveBumper,
            boolean haveSteamEngine
    ) {
        super(maxSpeed, weight, mainColor);

        this.extraColor = extraColor;
        this.haveBumper = haveBumper;
        this.haveSteamEngine = haveSteamEngine;
    }

    @Override
    public void DrawTransport(Graphics g)
    {
        super.DrawTransport(g);

        g.setColor(extraColor);
        if (haveBumper) {
            g.fillRect(_startPosX + 100, _startPosY + 30, 7, 17);
        }
        if (haveSteamEngine) {
            g.fillRect(_startPosX + 70, _startPosY - 10, 7, 17);
        }
    }
}
