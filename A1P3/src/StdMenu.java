//By RuM
//Telegram: @RU44_Y
//Twitter:  @RU44_Y
import java.io.*;
import java.util.*;

public class StdMenu {

    public static Scanner in = new Scanner(System.in);
    public static FreelanceJobMarketplace link = new FreelanceJobMarketplace();
    static String command[];
    static String command1[];
    static PrintWriter print1 = null;
    static PrintWriter print2 = null;

    public static void main(String[] args) throws Exception {

        File inputFile = new File("freelancers.txt");
        File inputFile2 = new File("projects.txt");
        FileWriter f1 = new FileWriter(inputFile, true);
        FileWriter f2 = new FileWriter(inputFile2, true);
        if (!(inputFile.exists()) && !(inputFile2.exists())) {
            System.err.println("Files does not exists!");
            System.exit(0);
        }
        Scanner in1 = null;
        PrintWriter output = new PrintWriter("output.txt");
        //---------------------------
        try {
            // I DONT BUT I WILL IGONRE IT FOR NOW
            readfromthefilefreelancer(in, inputFile, f1);
            readfromthefileproject(in1, inputFile2, f2);
        } catch (Exception e) {
            System.out.println("Could not read from file!");
        }
        //---------------------------

        String choice;
        do {
            menu();
            choice = in.nextLine();
            try {
                if (choice.equals("1")) {
                    addNewFreelacner();
                } else if (choice.equals("2")) {
                    addNewProject();
                } else if (choice.equals("3")) {
                    printFreelancerVaildAc(output);
                } else if (choice.equals("4")) {
                    printNSProjectList(output);
                } else if (choice.equals("5")) {
                    SearchProject(output);
                } else if (choice.equals("6")) {
                    RemoveProject();
                } else if (choice.equals("7")) {
                    printTopTen(output);
                } else if (choice.equals("8")) {
                    System.out.println("\n\t|>   Goodbye!   <|");
                    System.out.println();
                } else {
                    System.out.println("\n>\tWrong selection. Try again.");
                    System.out.println();
                }
            } catch (Exception ex) {
                System.out.println("Something Wrong");

            }
        } while (!(choice.equals("8")));
        try {
            in.close();
            output.flush();
            output.close();
            print1.flush();
            print1.close();
            print2.flush();
            print2.close();
        } catch (Exception e) {
            System.out.println("Input Files Empty!");
            System.exit(0);
        }
    }

    public static void menu() {
        System.out.println("|---------------------------------------------------|");
        System.out.println("|-------  Freelance Job Marketplace(Menu)  ---------|");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|> 1. Add a new freelancer.                         " + "|");
        System.out.println("|> 2. Add a new project.                            " + "|");
        System.out.println("|> 3. Print freelancer list with a valid account.   " + "|");
        System.out.println("|> 4. Print ‘not started’ project list.              " + "|");
        System.out.println("|> 5. Search project for freelancer.                " + "|");
        System.out.println("|> 6. Remove project by project Id.                 " + "|");
        System.out.println("|> 7. Print the 10 best freelancers.                " + "|");
        System.out.println("|> 8. Exit.                                         " + "|");
        System.out.println("|---------------------------------------------------|");
        System.out.print("  |> Please enter your choice: ");
    }

    //=========================== MODIFYING METHODS=============================
    public static void addNewFreelacner() throws Exception {
        System.out.println("Please enter the freelacner information:\n");
        System.out.print("PseudoName: ");
        String pseudoName = in.nextLine();
        if (!link.checkPseudoName(pseudoName)) {
            System.out.print("Name: ");
            String name = in.nextLine();
            System.out.print("Email: ");
            String email = in.nextLine();
            System.out.print("Phone: ");
            String phone = in.nextLine();
            System.out.print("Skills: ");
            String skills = in.nextLine();
            System.out.print("Experience: ");
            int expr = in.nextInt();
            System.out.print("Rating: ");
            float rating = in.nextFloat();
            int arr[] = new int[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Project-ID-" + (i + 1) + ": ");
                arr[i] = in.nextInt();
            }
            System.out.println("The freelacner is added!");
            link.addFreelancer(pseudoName, name, email, phone, skills, expr, rating, arr);
            String prepro = "";
            for (int i = 0; i < arr.length; i++) {
                prepro += arr[i] + ",";
            }
            print1.println(pseudoName + "," + name + "," + email + "," + phone + "," + skills + "," + expr + "," + rating + "," + prepro + "#");
            in.nextLine();

        } else {
            System.out.println("\nThe freelancer already exists!");
        }

    }

    //=========================== MODIFYING METHODS=============================
    public static void addNewProject() throws Exception {
        System.out.println("Please enter the project information:\n");
        System.out.print("Project Id: ");
        String projectId = in.nextLine();
        if (!link.checkProjectId(projectId)) {
            System.out.print("Company: ");
            String company = in.nextLine();
            System.out.print("Title: ");
            String title = in.nextLine();
            System.out.print("Description: ");
            String desc = in.nextLine();
            System.out.print("Category: ");
            String category = in.nextLine();
            System.out.print("min-price: ");
            int min = in.nextInt();
            System.out.print("max-price: ");
            int max = in.nextInt();
            System.out.println("\nThe freelancer is added!");
            link.addproject(projectId, company, title, desc, category, min, max, "not started", "");
            print2.println(projectId + "," + company + "," + title + "," + desc + "," + category + "," + min + "," + max + "," + "not started" + "," + "" + "#");
        } else {
            System.out.println("\nThis project already exists!");
        }
    }

    //=========================== MODIFYING METHODS=============================
    public static void RemoveProject() throws Exception {
        System.out.println("Please enter the projectId of the project to be deleted:\n");
        System.out.print("Project Id: ");
        String projectId = in.nextLine();
        if (!link.searchpreProject(projectId)) {
            link.removeProject(projectId);
            System.out.println("\nThe project has been deleted!\n");
        } else {
            System.out.println("\nThis project cannot be deleted!\n");
        }
    }

    public static void printFreelancerVaildAc(PrintWriter output) throws Exception {
        System.out.println(link.printValidFreelancerList());
        output.println(link.printValidFreelancerList());
    }

    public static void printNSProjectList(PrintWriter output) throws Exception {
        System.out.println(link.printNotStartedProject());
        output.println(link.printNotStartedProject());
    }

    public static void SearchProject(PrintWriter output) throws Exception {
        System.out.println("Please enter the information related to the project:");
        System.out.print("skill: ");
        String skill = in.nextLine();
        System.out.print("min-price: ");
        int min = in.nextInt();
        in.nextLine();
        String result = link.searchProject(skill, min);
        if (!result.isEmpty()) {
            System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------|\n");
            output.println("|------------------------------------------------------------------------------------------------------------------------------------------------|\n");
            System.out.printf("%s%-10s%s%-14s%s%-28s%s%-37s%s%-14s%s%-6s%s%-10s%s%-15s%s\n", "|", "Project Id", "|", "company", "|",
                    "title", "|", "description", "|", "category", "|", "min-price", "|", "max-price", "|", "status", "|");
            output.printf("%s%-10s%s%-14s%s%-28s%s%-37s%s%-14s%s%-6s%s%-10s%s%-15s%s\r\n", "|", "Project Id", "|", "company", "|",
                    "title", "|", "description", "|", "category", "|", "min-price", "|", "max-price", "|", "status", "|");
            System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------|\n");
            output.println("|------------------------------------------------------------------------------------------------------------------------------------------------|\n");
            System.out.println("Results:\n");
            output.println("Results:\n");
            System.out.println(result);
            output.println(result);
            System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------|\n");
            output.println("|------------------------------------------------------------------------------------------------------------------------------------------------|\n");
        } else {
            System.out.println("Results:\n");
            System.out.println("Not Found!\n");
        }
    }

    public static void printTopTen(PrintWriter output) throws Exception {
        System.out.println(link.printBestFreelancer());
        output.println(link.printBestFreelancer());
    }

    static void readfromthefilefreelancer(Scanner in, File inputFile, FileWriter f1) throws Exception {
        in = new Scanner(inputFile);
        in.nextLine();
        while (in.hasNext()) {
            String commandz = in.nextLine();
            String[] command = getCommand(commandz);
            int arr[] = new int[command.length - 7];// I did that to make it dynamic
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(command[i + 7]);
            }
            link.addFreelancer(command[0], command[1], command[2], command[3], command[4],
                    Integer.parseInt(command[5]), Float.parseFloat(command[6]), arr);
        }
        writetoFreelancer(f1);

    }

    static void readfromthefileproject(Scanner in, File inputFile2, FileWriter f2) throws Exception {
        in = new Scanner(inputFile2);
        in.nextLine();
        while (in.hasNext()) {
            String commandz = in.nextLine();
            String[] command = getCommand(commandz);
            if (command.length < 9) {
                link.addproject(command[0].trim(), command[1].trim(), command[2].trim(), command[3].trim(), command[4].trim(),
                        Integer.parseInt(command[5]), Integer.parseInt(command[6]), command[7].trim(), null);
            } else {
                link.addproject(command[0].trim(), command[1].trim(), command[2].trim(), command[3].trim(), command[4].trim(),
                        Integer.parseInt(command[5]), Integer.parseInt(command[6]), command[7].trim(), command[8].trim());
            }
        }
        writetoProject(f2);
    }

    static void writetoFreelancer(FileWriter f1) throws Exception {
        print1 = new PrintWriter(f1); 
    }

    static void writetoProject(FileWriter f2) throws Exception {
        print2 = new PrintWriter(f2);
    }

    static String[] getCommand(String commands) {
        String[] Tokens = commands.split(",|#");

        return Tokens;

    }

}
