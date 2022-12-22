package HW11;

import java.util.Scanner;

public class Main11 {
    static UsersList usersList = new UsersList();
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        System.out.println("\n Register new user - press 1" +
                "\n To authorisation - press 2" +
                "\n Get user by ID - press 3" +
                "\n Get all users - press 4" +
                "\n To exit - press 5");

        String inStr = "";
        boolean exit = false;
        int command;
        while (exit != true) {
            inStr = String.valueOf(scanner.nextInt());
            try {
                command = Integer.parseInt(inStr);

                switch (command) {
                    case 1:
                        register();
                        break;
                    case 2:
                        auth();
                        break;
                    case 3:
                        getUserById();
                        break;
                    case 4:
                        getAllUsers();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("No command");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Format exception");
            }
        }
    }
     static void register() {
         var scanner = new Scanner(System.in);
         System.out.println("Please enter username: ");
         String userName = scanner.nextLine();
         System.out.println("Please enter password: ");
         String password = scanner.nextLine();
         System.out.println("Please enter first name: ");
         String firstName = scanner.nextLine();
         System.out.println("Please enter last name: ");
         String lastName = scanner.nextLine();

     User newUser = new User(userName, password, firstName, lastName);
     try {
         System.out.println(usersList.register(newUser));
     } catch (UsernameIsNotFreeException e) {
         System.out.println(e.toString());
        }
    }

    static void getUserById() {
        var scanner = new Scanner(System.in);
        System.out.println("To get user please enter ID");
        try {
            int userId = Integer.parseInt(scanner.nextLine());
            System.out.println(usersList.getById(userId));
        } catch (NoSuchIdException e) {
            System.out.println(e.toString());
        } catch (NumberFormatException e) {
            System.out.println("ID should be a number");
        }
    }
    static void auth() {
        var scanner = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String myUsername = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String myPass = scanner.nextLine();

        try {
            System.out.println(usersList.authorisation(myUsername, myPass));
        } catch (IncorrectPassOrUsernameException e) {
            System.out.println(e.toString());
        }
    }
    static void getAllUsers() {
        System.out.println("Get all registered users ");
        System.out.println(usersList.getUsers());
    }
}


