package Assignment1;

//...............................................................
//Assignment 1
//© Rutwikkumar Sunilkumar Patel
//Written By: Rutwikkumar Sunilkumar Patel, Student Id: 40160646
//...............................................................

import java.util.Scanner;

/**
 * ----------Program Description----------
 * The class Staff contains all important methods and the main method that runs the program.
 * Here there is the main method which runs the main program, starting with an input value of inventory array from the user.
 * Then going forward five options are being provided to user where the option of adding, editing, viewing options
 * being given to users. All this functionalities are being implemented thereafter.
 * Incorrect password is also handled properly as per given constraint. Password is mandatory when it comes to adding
 * and editing the vaccine information.
 */

public class Staff {
    //password to get into the application.
    public static final String password = "password";
    //static variable to keep note of wrong passwords for case 1.
    public static int wrongPasswordCount = 0;

    /**
     * Method will perform password check, and return an integer value when password is validated otherwise it sends
     * wrong password count.
     *
     * @param userPassword            This is the input from user for password.
     * @param localWrongPasswordCount This is local count for wrong password.
     * @param caseType                This is to see from which case (option) the method is being called.
     * @return an integer value after comparing the password from user and the original password.
     */
    public static int checkPassword(String userPassword, int localWrongPasswordCount, int caseType) {
        //The user inputted password is being checked with stored password. If correct user will log in into the system.
        //Otherwise it will check the type of the case. If the case is 1 then wrongPasswordCount and localWrongPassord
        //is incremented.
        //If case 2 then just localWrongPassword count is incremented.
        //once the user has submitted wrong password 12 times then the system with exited from the system telling user
        //has inputted wrong password 12 times successively.
        if (password.equals(userPassword)) {
            System.out.println("Logged In.");
            return -1;
        } else {
            if (caseType == 1) {
                wrongPasswordCount++;
            }
            localWrongPasswordCount++;
            System.out.println("Wrong Password, " + (3 - localWrongPasswordCount) + " chances left.");
            if (wrongPasswordCount == 12) {
                System.out.println("Program detected suspicious activities and will terminate immediately!");
                System.exit(0);
            }
            return localWrongPasswordCount;
        }
    }

    /**
     * This method will the add the vaccine and stores the vaccine objects in an inventory array.
     *
     * @param inventory        inventory array which stores all the vaccines object.
     * @param numberOfVaccines this is the number of vaccine from inventory array that user want to get information of.
     * @param scanner          Scanner class object to read input from user.
     */
    public static void addVaccine(Vaccine[] inventory, int numberOfVaccines, Scanner scanner) {
        scanner.nextLine();
        while (numberOfVaccines > 0) {
            System.out.println("Enter the Brand Name: ");
            String brandName = scanner.nextLine();
            VaccineBrand brand = VaccineBrand.CoVaxin;
            try {
                brand = VaccineBrand.valueOf(brandName);
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a designated brand of vaccine.");
                break;
            }


            System.out.println("Enter the Expiry Date: ");
            String expiryDate = scanner.nextLine();

            System.out.println("Enter the Vaccine Id: ");
            long vaccineId = (long) scanner.nextLong();

            System.out.println("Enter the Vaccine Dose: ");
            double dose = scanner.nextDouble();

            System.out.println("Enter the Vaccine Price: ");
            double price = scanner.nextDouble();

            Vaccine vaccine = new Vaccine(dose, expiryDate, vaccineId, price, brand);

            // Storing the Vaccine object into the count of object.
            inventory[Vaccine.count - 1] = vaccine;
            numberOfVaccines--;
            scanner.nextLine();
            System.out.println("Hurray!! Data Inserted Successfully.");
        }

    }

    /**
     * The method will display all the information of particular vaccine.
     *
     * @param inventory     inventory array which stores vaccine objects.
     * @param vaccineNumber this is the number of vaccine from inventory array that user want to get information of.
     */
    public static void showDetails(Vaccine inventory[], int vaccineNumber) {
        System.out.println("Vaccine: " + vaccineNumber);
        System.out.println(inventory[vaccineNumber - 1].toString());
    }

    /**
     * The method will show the update options that the user gets and then describing each option scenarios.
     *
     * @param vaccineNumber this is the number of vaccine from inventory array that user want to get information of.
     * @param scanner       Scanner class object to take input of user.
     * @param inventory     inventory array which stores vaccine objects.
     * @param subCaseNumber it is just the number of options available to user.
     */
    public static void updateChanges(int vaccineNumber, Scanner scanner, Vaccine[] inventory, int subCaseNumber) {
        while (subCaseNumber >= 1) {
            System.out.println("What information would you like to change?");
            System.out.println("\t" + "1. Brand");
            System.out.println("\t" + "2. Dose");
            System.out.println("\t" + "3. Expiry");
            System.out.println("\t" + "4. Price");
            System.out.println("\t" + "5. Quit");
            System.out.println("Please enter your choice >");
            subCaseNumber = scanner.nextInt();
            scanner.nextLine();
            switch (subCaseNumber) {
                case 1:
                    //To update the brand name of the vaccine.
                    System.out.println("Enter updated value of brand: ");
                    String brandName = scanner.nextLine();
                    VaccineBrand brand = VaccineBrand.valueOf(brandName);
                    inventory[vaccineNumber - 1].setVaccineBrand(brand);
                    showDetails(inventory, vaccineNumber);
                    break;
                case 2:
                    //To update the dose of particular vaccine.
                    System.out.println("Enter updated value of dose: ");
                    double dose = scanner.nextDouble();
                    inventory[vaccineNumber - 1].setDose(dose);
                    showDetails(inventory, vaccineNumber);
                    break;
                case 3:
                    //To update the expiry date of the vaccine.
                    System.out.println("Enter updated value of expiry date: ");
                    String expiry = scanner.nextLine();
                    inventory[vaccineNumber - 1].setExpiryDate(expiry);
                    showDetails(inventory, vaccineNumber);
                    break;
                case 4:
                    //To update the price of particular vaccine.
                    System.out.println("Enter updated value of price: ");
                    double price = scanner.nextDouble();

                    inventory[vaccineNumber - 1].setPrice(price);
                    showDetails(inventory, vaccineNumber);
                    break;
                case 5:
                    //Exit from update menu and get back to the main menu.
                    subCaseNumber = -1;
                    break;
                default:
                    //Default block.
                    System.out.println("Not a valid choice. Please select from the above mentioned choices.");
                    break;
            }
        }
    }

    /**
     * This method will find the vaccine on the basis of the brand value enter by user.
     *
     * @param vaccineName is the brand of vaccine of which user want more information.
     * @param inventory   inventory array which stores vaccine objects.
     */
    public static void findVaccinesBy(String vaccineName, Vaccine[] inventory) {
        VaccineBrand brand = VaccineBrand.CoVaxin;
        try {
            brand = VaccineBrand.valueOf(vaccineName);
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter a designated brand of vaccine.");
        }

        boolean mark = false;
        if (Vaccine.findNumberOfCreatedVaccines() == 0) {
            System.out.println("Please enter vaccines in your inventory.");
        } else {
            for (int i = 0; i < Vaccine.findNumberOfCreatedVaccines(); i++) {
                if (inventory[i].getVaccineBrand().equals(brand)) {
                    System.out.println(inventory[i].toString());
                    mark = true;
                }
            }
            if (!mark) {
                System.out.println("Try with some other name as no vaccine found under this brand.");
            }
        }
    }

    /**
     * The method will find all the vaccines that fall under the price cap mentioned by the user.
     *
     * @param priceFilter it is the price filter given by user.
     * @param inventory   inventory array which stores vaccine objects.
     */
    public static void findCheaperThan(double priceFilter, Vaccine[] inventory) {
        boolean mark = false;
        if (Vaccine.findNumberOfCreatedVaccines() == 0) {
            System.out.println("Please enter vaccines in your inventory.");
        } else {
            for (int i = 0; i < Vaccine.findNumberOfCreatedVaccines(); i++) {
                if (inventory[i].getPrice() < priceFilter) {
                    mark = true;
                    System.out.println(inventory[i].toString());
                }
            }
            if (!mark) {
                System.out.println("Try with some price filter as no vaccine found under this filter.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome Staff!! You all are a precious asset to our company.");
        Scanner scanner = new Scanner(System.in);
        Vaccine[] inventory = {};
        try {
            System.out.println("What total number of vaccine does your stone can contain?");
            int totalNumberOfVaccines = scanner.nextInt();
            inventory = new Vaccine[totalNumberOfVaccines];
        } catch (NegativeArraySizeException e) {
            System.out.println("Please enter inventory size in positive value.");
            System.exit(0);
        }

        int caseNumber = 1;

        while (caseNumber >= 1) {
            System.out.println("What do you want to do?");
            System.out.println("\t" + "1. Enter new vaccines.");
            System.out.println("\t" + "2. Change information of a vaccine.");
            System.out.println("\t" + "3. Display all vaccines by a specific brand.");
            System.out.println("\t" + "4. Display all vaccines under a certain a price.");
            System.out.println("\t" + "5. Quit.");
            System.out.println("Please enter your choice >");
            caseNumber = scanner.nextInt();
            scanner.nextLine();
            switch (caseNumber) {
                case 1:
                    //To add the vaccine by entering a valid password.
                    int localWrongPasswordCount = 0;
                    boolean login = false;
                    //Validating the user password
                    while (localWrongPasswordCount >= 0 && localWrongPasswordCount < 3 && wrongPasswordCount < 12) {
                        System.out.println("Please enter your password: ");
                        String userPassword = scanner.nextLine();
                        localWrongPasswordCount = checkPassword(userPassword, localWrongPasswordCount, 1);
                        if (localWrongPasswordCount == -1) {
                            login = true;
                        }
                    }

                    //Once login validated, adding vaccine data into an Vaccine type object then to an inventory array,
                    while (login) {
                        System.out.println("How many vaccines do you want to enter?");
                        int numberOfVaccines = scanner.nextInt();
                        if (numberOfVaccines <= inventory.length - Vaccine.count) {
                            addVaccine(inventory, numberOfVaccines, scanner);
                            break;
                        } else {
                            System.out.println("You can only add, " + (inventory.length - Vaccine.count)
                                    + " number of vaccines in your inventory.");
                        }
                    }
                    break;

                case 2:
                    //To update the vaccine details on successful validating user password.
                    wrongPasswordCount = 0;
                    int illigalPasswordCount = 0;
                    boolean checkLogin = false;
                    //Validating user password.
                    while (illigalPasswordCount >= 0 && illigalPasswordCount < 3) {
                        System.out.println("Please enter your password: ");
                        String password = scanner.nextLine();
                        illigalPasswordCount = checkPassword(password, illigalPasswordCount, 2);
                        if (illigalPasswordCount == -1) {
                            checkLogin = true;
                        }
                    }

                    //Once login is validated, checking for the update information from user.
                    if (checkLogin) {
                        boolean loopCheck = true;
                        while (loopCheck) {
                            System.out.println("Which Vaccine number information, do you want to update?");
                            int vaccineNumber = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                System.out.println("Vaccine: " + vaccineNumber);
                                System.out.println(inventory[vaccineNumber - 1].toString());
                                int subCaseNumber = 1;
                                updateChanges(vaccineNumber, scanner, inventory, subCaseNumber);
                                loopCheck = false;
                            } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                                System.out.println(
                                        "The vaccine number you entered is not in the List. Do you want to re-enter the another vaccine number. Please enter Y if you want to re-enter otherwise enter N.");
                                String decisionOutput = scanner.nextLine();
                                if (decisionOutput.equals("Y")) {
                                    loopCheck = true;
                                } else {
                                    loopCheck = false;
                                }
                            }
                        }
                    }
                    break;

                case 3:
                    //To search the vaccine details by the name of vaccine brand.
                    System.out.println("Please enter the brand, you want information of:");
                    String vaccineName = scanner.nextLine();
                    findVaccinesBy(vaccineName, inventory);
                    break;

                case 4:
                    //Filtering the vaccine search by its price.
                    System.out.println("Please enter the price of vaccines you to want to filter by: ");
                    double priceFilter = scanner.nextDouble();
                    findCheaperThan(priceFilter, inventory);
                    break;

                case 5:
                    //Exiting from the main menu as the user selected 5th option.
                    System.out.println("Thank You for using our application. We will meet soon. Till there Bye Bye!!");
                    System.exit(0);
                    break;

                default:
                    //Default block.
                    System.out.println("Not a valid choice. Please select from the above mentioned choices.");
            }
        }
        scanner.close();
    }
}