import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static Person enterName() throws Exception {
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        if (name.length() == 0) {
            throw new Exception("You must enter a valid name!");
        } else {
            Person person = new Person(name, 100);
            return person;
        }
    }

    private static void withdrawFunds(Person person) throws Exception {
        System.out.println("How much would you like to withdraw?");
        Scanner scannerInt = new Scanner(System.in);
        int amount = scannerInt.nextInt();
        if (amount > person.accountBalance) {
            System.out.println("You cannot pull out more than your balance!");
            System.out.println();
        } else {
            person.accountBalance = person.accountBalance - amount;
            System.out.println("You've withdrawn $" + amount + " dollars.");
            System.out.println("Your current balance is: $" + person.accountBalance);
            System.out.println();
        }
    }

    private static Integer checkBalance(Person person) {
        System.out.println("Your current balance is: $" + person.accountBalance);
        System.out.println();
        return person.accountBalance;
    }

    private static Integer addFunds(Person person) {
        System.out.println("Enter an amount to deposit.");
        Scanner intScanner = new Scanner(System.in);
        Integer amount = intScanner.nextInt();
        if (amount > 0) {
            person.accountBalance = person.accountBalance + amount;
            System.out.println("You have deposited " + amount + " dollars.");
            System.out.println();
        } else {
            System.out.println("You have to deposit a positive amount!");
            System.out.println();
        }
        return person.accountBalance;
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Hello, and welcome to the ATM.");
        Person currentPerson = enterName();
        System.out.println();

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("Enter 1 to check your balance.");
            System.out.println("Enter 2 to withdraw funds.");
            System.out.println("Enter 3 to cancel.");
            System.out.println("Enter 4 to see current person logged in.");
            System.out.println("Enter 5 to deposit funds.");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println();
                    System.out.println("Check balance.");
                    checkBalance(currentPerson);
                    break;

                case "2":
                    System.out.println();
                    System.out.println("Withdraw funds.");
                    withdrawFunds(currentPerson);
                    break;

                case "3":
                    System.out.println();
                    System.out.println("Thank you and please come again.");
                    System.exit(1);
                    break;

                case "4":
                    System.out.println();
                    System.out.println("Current customer: " + currentPerson.name);
                    System.out.println();
                    break;

                case "5":
                    System.out.println();
                    addFunds(currentPerson);
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid entry.");
                    continue;
            }
        }
    }
}