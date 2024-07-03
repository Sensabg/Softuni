package WorkingWithAbstraction.Lab.pointinrectangle1;

public class Rectangle {
    private final Point bottomLeft;
    private final Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point p) {
        return p.x() >= bottomLeft.x() && p.x() <= topRight.x()
                && p.y() >= bottomLeft.y() && p.y() <= topRight.y();
    }
}
