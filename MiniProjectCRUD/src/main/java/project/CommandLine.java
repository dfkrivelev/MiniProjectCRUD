package project;

import java.util.Scanner;

public class CommandLine {
    public void exec() {
        Database database = new Database(DbInit.employees);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("# ");
            String cmd = scanner.next();
            switch (cmd.toLowerCase()) {
                case "create":
                    database.create();
                    break;
                case "read":
                    database.read();
                    break;
                case "update":
                    database.update();
                    break;
                case "delete":
                    database.delete();
                    break;
                case "find":
                    database.find();
                    break;
                case "sort":
                    database.sort();
                    break;
                case "save":
                    database.save();
                    break;
                case "load":
                    database.load();
                    break;
                case "exit":
                    System.out.println("Exit of command line.");
                    return;
                default:
                    System.out.println("List of command: c[reate], r[ead], u[pdate], d[elete]");
            }
        }
    }
}