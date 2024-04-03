package perkpackege;

public class Point {
    private double curX;
    private double curY;

    private double width;
    private double heigth;

    public  Point(double x, double y) {
        this.curX = x;
        this.curY = y;
        width = 10;
        heigth = 10;
    }

    public double getX() {return curX;}
    public double getY() {return curY;}

    public void setX(double x) {curX = x;}
    public void setY(double y) {curY = y;}

    public boolean isMove (double x, double y) {
        return x >= 0 && x < width && y >= 0 && y < heigth;
    }

    public void moveTo (double dx, double dy) {
        if(isMove(curX + dx, curY + dy)) {
            curX += dx;
            curY += dy;
        }
    }

    public String toString () {
        return curX + ":" + curY;
    }

    public Point getDelta (Point target) {
        return new Point(target.getX() - getX(), target.getY() - getY());
    }

    public boolean check (Point fcor) {
        return curX == fcor.curX && curY == fcor.curY;
    }

    public void add (double dx, double dy) {
        curX += dx;
        curY += dy;
    }
}
