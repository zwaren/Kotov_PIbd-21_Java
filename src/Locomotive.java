import java.awt.*;

public class Locomotive extends Train{

    private final int carWidth = 140;
    private final int carHeight = 100;

    public int getMaxSpeed() {
        return MaxSpeed;
    }

    public float getWeight() {
        return Weight;
    }

    public Color getMainColor() {
        return MainColor;
    }

    public Locomotive(int maxSpeed, float weight, Color mainColor) {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }

    @Override
    public void MoveTransport(Direction direction) {
        float step = MaxSpeed * 100 / Weight;
        switch (direction) {
            case Left:
                if (_startPosX - step > 0) { _startPosX -= step; }
                break;
            case Right:
                if (_startPosX + step + carWidth < _pictureWidth) { _startPosX += step; }
                break;
            case Up:
                if (_startPosY - step > 0) { _startPosY -= step; }
                break;
            case Down:
                if (_startPosY + step + carHeight < _pictureHeight) { _startPosY += step; }
                break;
        }
    }

    public void DrawTransport(Graphics g) {
        g.setColor(MainColor);
        g.fillRect(_startPosX, _startPosY + 10, 100, 30);

        g.setColor(Color.BLACK);
        g.fillRect(_startPosX - 5, _startPosY + 36, 110, 5);
        g.drawRect(_startPosX, _startPosY + 10, 15, 30);

        g.fillOval(_startPosX + 10, _startPosY + 35, 10, 10);
        g.fillOval(_startPosX + 20, _startPosY + 35, 10, 10);
        g.fillOval(_startPosX + 30, _startPosY + 35, 10, 10);

        g.fillOval(_startPosX + 60, _startPosY + 35, 10, 10);
        g.fillOval(_startPosX + 70, _startPosY + 35, 10, 10);
        g.fillOval(_startPosX + 80, _startPosY + 35, 10, 10);

        g.setColor(Color.GRAY);
        g.fillOval(_startPosX, _startPosY + 5, 100, 10);
    }
}
