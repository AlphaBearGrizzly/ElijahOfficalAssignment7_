package assn07;
//import java.util.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> passwordManager = new PasswordManager<>();
        String input = "alsdk333fjasldkf6asdfiwenfwofuda5fncoewufh29384204erdlfasndfs"; // starter string
        String value = "dsfalkjsdfaslkfjdfbeufduafn";
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
                        input = scanner.nextLine();
                        value = scanner.nextLine();
                        passwordManager.put(input, value);
                        System.out.println("New password added");

                    } else if (input.equals("Get password")) {
                        input = scanner.nextLine();
                        System.out.println(passwordManager.get(input));

                    } else if (input.equals("Delete account")) {
                        input = scanner.nextLine();
                        passwordManager.remove(input);

                    } else if (input.equals("Check duplicate password")) {
                        value = scanner.nextLine();
                        boolean hasDupl = false;
                        System.out.println("Websites using that password:");
                        List<String> keys = passwordManager.checkDuplicate(value);

                        for(int i=0; i <= passwordManager.size(); i++){
                            System.out.println(keys.get(i));
                            hasDupl = true;
                        }
                        if (hasDupl == false){
                            System.out.println("No account uses that password");
                        }
                    } else if (input.equals("Get accounts")) {


                    } else if (input.equals("Generate random password")) {
                        int length = Integer.parseInt(scanner.nextLine());
                        System.out.println(passwordManager.generateRandomPassword(length));
                    }
                    passGate = false;
                }

                if (passGate == true || input.equals("Exit")) {
                    //do nothing, exit the method
                }
            }


        }




    }






