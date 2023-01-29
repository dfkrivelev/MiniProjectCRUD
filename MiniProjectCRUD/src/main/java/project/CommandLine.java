package project;

import java.util.Scanner;

public class CommandLine {
    public void exec() {
        Database database = new Database(DbInit.init());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("# ");
            String cmd = scanner.next();
            switch (cmd.toLowerCase().charAt(0)) {
                case 'c':
                    database.create();
                    break;
                case 'r':
                    database.read();
                    break;
                case 'u':
                    database.update();
                    break;
                case 'd':
                    database.delete();
                    break;
                case 'f':
                    database.find();
                    break;
                case 'p':
                    database.positions();
                    break;
                case 's':
                    database.sort();
                    break;
                case 'x':
                    System.out.println("Exit of command line.");
                    return;
                default:
                    System.out.println("List of command: c[reate], r[ead], u[pdate], d[elete]");
            }
        }
    }
}
