import java.awt.*;

public class Locomotive {
    private int _startPosX;
    private int _startPosY;

    private int _pictureWidth;
    private int _pictureHeight;

    private final int carWidth = 140;
    private final int carHeight = 100;

    private int MaxSpeed;
    private float Weight;
    private Color MainColor;
    private Color DopColor;

    public int getMaxSpeed() {
        return MaxSpeed;
    }

    public float getWeight() {
        return Weight;
    }

    public Color getMainColor() {
        return MainColor;
    }

    public Color getDopColor() {
        return DopColor;
    }

    public Locomotive(int maxSpeed, float weight, Color mainColor, Color dopColor) {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
    }

    public void SetPosition(int x, int y, int width, int heigth) {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = heigth;
    }

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

    public void DrawLocomotive(Graphics g) {
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
