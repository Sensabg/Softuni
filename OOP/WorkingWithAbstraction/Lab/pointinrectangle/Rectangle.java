package WorkingWithAbstraction.Lab.pointinrectangle;

class Rectangle {

    Point bottomLeft, topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return point.x >= bottomLeft.x && point.x <= topRight.x &&
                point.y >= bottomLeft.y && point.y <= topRight.y;
    }
}
