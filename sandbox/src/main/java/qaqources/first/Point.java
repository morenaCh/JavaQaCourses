package qaqources.first;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y){
        this.x=x;
        this.y=y;

    }
    public static void main(String[] args) {

        Point p1 =new Point(2,5);
        System.out.println("Coordinates first Point " + "=" + p1.x + "," + p1.y);

        Point p2 =new Point(9,5);
        System.out.println("Coordinates second Point " + "=" + p2.x + "," + p2.y);

        System.out.println("Distance beetween Point1 and Point2 = " + p1.distance(p2));

    }

    public double distance(Point p2) {

        double distanceX = x - p2.x;
        double distanceY = y - p2.y;

        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);

    }


}
