package qaqources.first;

public class Point {
    public double x1,x2;
    public double y1,y2;

    public Point(double x1, double x2, double y1, double y2){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
    }

    public static void main(String[] args) {

        Point point =new Point(2,5,5,9);
        System.out.println("Coordinates first Point " + "=" + point.x1 + "," + point.x2);
        System.out.println("Coordinates second Point " + "=" + point.y1 + "," + point.y2);
        System.out.println("Distance beetween Point1 and Point2 = " + point.distance());

        Point point1 =new Point(3,7,6,11);
        System.out.println("Coordinates first Point " + "=" + point1.x1 + "," + point1.x2);
        System.out.println("Coordinates second Point " + "=" + point1.y1 + "," + point1.y2);
        System.out.println("Distance beetween Point1 and Point2 = " + point1.distance());

    }

        public double distance() {

            double ResultPointP1 = x2 - x1; //5-2=3
            double ResultPointP2 = y2 - y1; //9-5=4

            double ResultPowPointP1 = Math.pow(ResultPointP1, 2);//Math.pow(liczba, b);//3 do potegi 2=9;
            double ResultPowPointP2 = Math.pow(ResultPointP2, 2);//Math.pow(liczba, b); //4 do potegi 2=16;

            double ResultOfAddPow = ResultPowPointP1 + ResultPowPointP2;
            double ResultEnd = Math.sqrt(ResultOfAddPow);
            return ResultEnd;

        }


        }



