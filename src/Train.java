import java.awt.*;

public abstract class Train implements ITransport {

    protected int _startPosX;
    protected int _startPosY;
    protected int _pictureWidth;
    protected int _pictureHeight;

    protected int MaxSpeed;
    protected float Weight;
    protected Color MainColor;

    public int getMaxSpeed() {
        return MaxSpeed;
    }

    protected void setMaxSpeed(int maxSpeed) {
        MaxSpeed = maxSpeed;
    }

    public float getWeight() {
        return Weight;
    }

    protected void setWeight(float weight) {
        Weight = weight;
    }

    public Color getMainColor() {
        return MainColor;
    }

    protected void setMainColor(Color mainColor) {
        MainColor = mainColor;
    }

    @Override
    public void SetPosition(int x, int y, int width, int height) {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    @Override
    public abstract void MoveTransport(Direction direction);

    @Override
    public abstract void DrawTransport(Graphics g);
}
