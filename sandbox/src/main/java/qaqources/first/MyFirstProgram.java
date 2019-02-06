package qaqources.first;

public class MyFirstProgram {
    public static void main(String[] args) {
        //alt+enter - pomoc
        //cntr+spacja - dalszy ciag tekstu

        hello("world");
        hello("Bożena");
        hello("Pawełek");
        hello("Piotrek");
        System.out.println("2+2=" + 2 + 2);
        System.out.println("2+2=" + (2 + 2));

        Square kwadrat=new Square(8);
        System.out.println("Powieszchnia kwadratu " +"= "+kwadrat.powieszchniaKwadratu());
        /*System.out.println("Powieszchnia kwadratu " +"= "+powieszchniaKwadratu(kwadrat));

        /*Square kwadrat=new Square();
        kwadrat.l=8;
        System.out.println("Powieszchnia kwadratu " +"= "+powieszchniaKwadratu(kwadrat));

        Square kwadrat1=new Square();
        kwadrat1.l=10;
        System.out.println("Powieszchnia Kwadratu o boku "+kwadrat1.l+"= "+(powieszchniaKwadratu(kwadrat1)));*/

        Rectangle prostokat=new Rectangle(10,5);
        System.out.println("Powieszchnia prostokata "+ "=" +prostokat.powieszchniaProstokata());//wywolujemy funkcje, a jako jeej parametr podajemy obiekt
        /*/tworzenie obiektów bez konstruktora
        Rectangle prostokat=new Rectangle();
        prostokat.a=10;
        prostokat.b=5;
        System.out.println("Powieszchnia prostokata "+ "=" +powieszchniaProstokata(prostokat));

        Rectangle prostokat1=new Rectangle();
        prostokat1.a=4;
        prostokat1.b=5;
        System.out.println("Powieszchnia prostokata o bokach "+prostokat1.a+" i "+prostokat1.b+" = "+powieszchniaProstokata(prostokat1));
        */

    }

    public static void hello(String somebody) {
        System.out.println("Hello "+ somebody+"!");
    }






}

