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

        Kwadrat kwadrat=new Kwadrat(8);
        System.out.println("Powieszchnia kwadratu " +"= "+kwadrat.powieszchniaKwadratu());
        /*System.out.println("Powieszchnia kwadratu " +"= "+powieszchniaKwadratu(kwadrat));

        /*Kwadrat kwadrat=new Kwadrat();
        kwadrat.l=8;
        System.out.println("Powieszchnia kwadratu " +"= "+powieszchniaKwadratu(kwadrat));

        Kwadrat kwadrat1=new Kwadrat();
        kwadrat1.l=10;
        System.out.println("Powieszchnia Kwadratu o boku "+kwadrat1.l+"= "+(powieszchniaKwadratu(kwadrat1)));*/

        Prostokat prostokat=new Prostokat(10,5);
        System.out.println("Powieszchnia prostokata "+ "=" +prostokat.powieszchniaProstokata());//wywolujemy funkcje, a jako jeej parametr podajemy obiekt
        /*/tworzenie obiektów bez konstruktora
        Prostokat prostokat=new Prostokat();
        prostokat.a=10;
        prostokat.b=5;
        System.out.println("Powieszchnia prostokata "+ "=" +powieszchniaProstokata(prostokat));

        Prostokat prostokat1=new Prostokat();
        prostokat1.a=4;
        prostokat1.b=5;
        System.out.println("Powieszchnia prostokata o bokach "+prostokat1.a+" i "+prostokat1.b+" = "+powieszchniaProstokata(prostokat1));
        */

    }

    public static void hello(String somebody) {
        System.out.println("Hello "+ somebody+"!");
    }






}

