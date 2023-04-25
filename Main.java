package assn07;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> passwordManager = new PasswordManager<>();
        String input = "alsdk333fjasldkf6asdfiwenfwofuda5fncoewufh29384204erdlfasndfs"; // starter string
        while (passwordManager.checkMasterPassword(input) == false) {
            System.out.println("Enter Master Password");
            input = scanner.nextLine();

        }
            boolean passGate = false;

            while (passGate == false) {
                String[] options = {"New password", "Get password", "Delete account", "Check duplicate password",
                        "Get accounts", "Generate random password", "Exit"};
                input = scanner.nextLine();
                for (int index = 0; index < options.length; index++) {
                    if (options[index].equals(input)) {
                        passGate = true;
                    }
                }
                if (passGate == false) {

                    System.out.println("Command not found");
                }
                if (passGate == true) {

                    if (input.equals("New password")) {



                        // set passgate back to
                    } else if (input.equals("Get password")) {


                    } else if (input.equals("Delete account")) {
                        System.out.println("DELETE ACCOUNT");


                    } else if (input.equals("Check duplicate password")) {

                        System.out.println("CHECK DUPL");


                    } else if (input.equals("Get accounts")) {


                    } else if (input.equals("Generate random password")) {

                    }
                    passGate = false;
                }

                if (passGate == true || input.equals("Exit")) {
                    //do nothing, exit the method
                }
            }


        }




    }






