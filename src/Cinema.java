import java.util.Scanner;

public class Cinema {
    private static Scanner scanner;
    private static int currentIncome = 0;
    private static int totalIncome =0;
    private static String[][] someArray;
    private static int count = 0;
    private static int seats=0;
    private static int rows = 0;



    public static void print() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }


    public static void showTheFreeSeats(String[][] someArray) {
        System.out.println("Cinema: ");
        for (int i = 0; i < someArray.length; i++) {
            for (int j = 0; j < someArray[i].length; j++) {
                System.out.print(someArray[i][j]);
            }
            System.out.println();
        }
    }

    public static int countPrice(int row, int rows, int seats) {
        int totalIncome = rows * seats * 10;
        int ticketPrice = 0;

        if (rows * seats <= 60) {
            ticketPrice = 10;

        } else if (rows * seats > 60 && rows % 2 == 0) {
            if (row <= rows / 2) {
                ticketPrice = 10;

            } else {
                ticketPrice = 8;

            }

        } else if (rows * seats > 60 && rows % 2 != 0) {
            if (row <= rows / 2) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;

            }

        }
        return  ticketPrice;

    }


    public static void creatArray(String[][] someArray, int rows, int seats) {

        for (int i = 1; i < seats + 1; i++) {
            for (int j = 1; j < rows + 1; j++) {
                someArray[j][i] = "S" + " ";
            }
        }

        for (int i = 1; i < seats + 1; i++) {
            someArray[0][i] = i + " ";
        }

        for (int i = 1; i < rows + 1; i++) {
            someArray[i][0] = i + " ";
        }

        someArray[0][0] = " ";
    }

    public static void calculateTotalPrice(int rows, int seats){
        for (int i = 1; i <=rows ; i++) {
            totalIncome += countPrice(i,rows,seats)*seats;
        }
    }

    public static void numberTwo(){
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();

        if (someArray.length <= row || someArray[0].length <= seat) {
            System.out.println("Wrong input!");
            numberTwo();
            return;
        }

        if (!someArray[row][seat].equals("B ")) {
            someArray[row][seat] = "B ";
            int ticketPrice =countPrice(row, rows, seats);
            currentIncome+=ticketPrice;
            count++;
            System.out.println("Ticket price: " + "$" + ticketPrice);

        } else {
            System.out.println("That ticket has already been purchased!");
            numberTwo();
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
         rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();
        someArray = new String[rows + 1][seats + 1];

        calculateTotalPrice(rows,seats);

        creatArray(someArray, rows, seats);


        while (true) {
            print();
            int number = scanner.nextInt();
            if (number == 1) {
                showTheFreeSeats(someArray);
            } else if (number == 2) {
                numberTwo();

            } else if (number == 3) {
                System.out.println("Number of purchased tickets: " + count);
                double percentage = (100.0 * count) / (rows * seats);
                System.out.println("Percentage: " + String.format("%.2f",percentage) + "%");
                System.out.println("Current income: " + "$" + currentIncome);
                System.out.println("Total income: $" + totalIncome);


            } else if (number == 0) {
                break;
            }
        }

    }
}
