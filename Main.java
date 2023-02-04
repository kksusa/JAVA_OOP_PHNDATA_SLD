import java.util.ArrayList;
import java.util.Scanner;
public class Main{

    public static void main(String[] args) {
        ArrayList<Subscriber> DB = ManageOutData.Read();
        System.out.println("Это система хрнения данных о внутренних номерах сотрудников предприятия.");
        Help.Help();
        Scanner iScanner = new Scanner(System.in);
        while (true) { // Цикл проверки ввода команды
            System.out.println("Введите команду:");
            String cmd = iScanner.nextLine();
            if (cmd.equals("add")) {
                ManageData.Add(DB);
                ManageOutData.Write(DB);
            } else if (cmd.equals("delete")) {
                ManageData.Delete(DB);
                ManageOutData.Write(DB);
            } else if (cmd.equals("list")) ManageOutData.List(DB);
            else if (cmd.equals("help")) Help.Help();
            else if (cmd.equals("exit")) break;
            else System.out.println("Такой команды нет.\nДля вывода возможных команд введите help.");
        }
        iScanner.close();
    }
}