package app;
import client.Person;
import goods.Item;
import payment.CreditCard;

import java.util.Random;

public class Controller {
    public static void main(String[] args) throws InterruptedException{
        yourInfoHeader();


        Person john = new Person("John", "Doe", "1100 Brickell Ave", "Apt 102", "Miami", "Florida");

        CreditCard masterCard = new CreditCard(john, "MasterCard", 2500.00);

        CreditCard ax = new CreditCard(john,"American Express", 5000.00);

        john.getCreditCards().add(masterCard);

        john.getCreditCards().add(ax);

        Item cafeMocha = new Item("Food", "Cafe Mocha", 4.77);

        Item gucciSlipper = new Item("Clothing", "Gucci Princetown", 2650.00);

        Item coke = new Item("Food", "Coke", 1.99);

        Item airlinesTicket = new Item("Travel", "MIA-SFO", 823.26);

        ((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);

        ((CreditCard)john.getCreditCards().get(0)).makeCharge(gucciSlipper);

        ((CreditCard)john.getCreditCards().get(1)).makeCharge(gucciSlipper);


        ((CreditCard)john.getCreditCards().get(0)).transactionsReport();

        ((CreditCard)john.getCreditCards().get(1)).transactionsReport();

        Random generator = new Random();

        for(int i=1; i<=7; i++){

            Thread.sleep(generator.nextInt(1001));

            if(i%3==0){
                ((CreditCard)john.getCreditCards().get(1)).makeCharge(cafeMocha);
            }else{
                ((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);
            }

        }//end for

        for(int i=1; i<=5; i++){

            Thread.sleep(generator.nextInt(1001));
            if(i%2==0){
                ((CreditCard)john.getCreditCards().get(0)).makeCharge(airlinesTicket);
            }else{
                ((CreditCard)john.getCreditCards().get(1)).makeCharge(airlinesTicket);
            }

        }//end for

        for(int i=1; i<=10; i++){

            Thread.sleep(generator.nextInt(1001));

            int randomSelectCard = generator.nextInt(2);

            if(randomSelectCard == 0){
                ((CreditCard) john.getCreditCards().get(0)).makeCharge(coke);
                System.out.printf("randomSelectCard: MasterCard\n");
            }else if( randomSelectCard == 1){
                ((CreditCard) john.getCreditCards().get(1)).makeCharge(coke);
                System.out.printf("randomSelectCard: %s\n", ((CreditCard) john.getCreditCards().get(1)).getType());
            }
        }//end for

        ((CreditCard) john.getCreditCards().get(0)).transactionsReport();


        ((CreditCard) john.getCreditCards().get(1)).transactionsReport();


        john.displayInfo();

    }//end main










    public static void yourInfoHeader() {

        System.out.println("=====================================");
        System.out.println("Programmer:  " + "Jean-Elias Mestre");
        System.out.println("Panther ID:  " + "6305045");
        System.out.println();
        System.out.println("CLASS: \t\t COP2210 ");
        System.out.println("SECTION: \t " + "UO1");
        System.out.println("SEMESTER: \t " + "Spring");
        System.out.println("CLASS TIME: \t " + "6:25-9 PM");
        System.out.println();
        System.out.println("Assignment:  " + "Project 2");
        System.out.println("Certification: \nI understand FIU'S academic policies, and I certify");
        System.out.println("that this work is my own and that none of it is the");
        System.out.println("work of any other person.");
        System.out.println("======================================================");
        System.out.println();

    }

}//end class
