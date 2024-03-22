package perkpackege;

public class Point {
    private int curX;
    private int curY;

    private int width;
    private int heigth;

    public  Point(int x, int y) {
        this.curX = x;
        this.curY = y;
        width = 10;
        heigth = 10;
    }

    public int getX() {return curX;}
    public int getY() {return curY;}

    public void setX(int x) {curX = x;}
    public void setY(int y) {curY = y;}

    public boolean isMove (int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < heigth;
    }

    public void moveTo (int dx, int dy) {
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

    public void add (int dx, int dy) {
        curX += dx;
        curY += dy;
    }
}
