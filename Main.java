package assn07;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Map<String,String> passwordManager = new PasswordManager<>();
        //while
        String input = "alsdkfjasldkfasdfiwenfwofudafncoewufh29384204erdlfasndfs"; // starter string
        while (passwordManager.checkMasterPassword(input) == false){
            System.out.println("Enter Master Password");
            input = scanner.nextLine();
        }
        String[] options = {"New password", "Get password", "Delete account", "Check duplicate password",
                "Get accounts", "Generate random password", "Exit"};
        boolean passGate = false;

        while (passGate == false) {
            input = scanner.nextLine();
            System.out.println("Command not found");
            for (int index = 0; index < options.length; index++) {
                if (options[index].equals(input)) {
                    passGate = true;
                }
            }
        }

        System.out.println("Lick my fat balls, test success");

        //passwordManager.checkMasterPassword();

        // ability to type in a few options


        // exit

        }

        // your code below
    }

