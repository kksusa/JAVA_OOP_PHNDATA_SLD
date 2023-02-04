import java.util.ArrayList;
import java.util.Scanner;

public class ManageData{

    /**Добавление экземпляра абонента*/
    public static ArrayList<Subscriber> Add(ArrayList<Subscriber> data)
    {
        Scanner iScanner = new Scanner(System.in);
        int phone = CheckPhone.CheckNumbers("Введите номер телефона");
        for (int i = 0; i < data.size(); i++) {
            if (phone == data.get(i).getPhoneNumber()) { // Проверка на наличие записи в БД
                System.out.println("Такой номер уже есть в базе данных.");
                return data;
            } else continue;
        }
        System.out.print("Введите абонента: ");
        String name = iScanner.nextLine();
        data.add(new Subscriber(name, phone));
        System.out.println("Номер добавлен.");
        return data;
    }

    /**Удаление экземпляра абонента*/
    public static ArrayList<Subscriber> Delete(ArrayList<Subscriber> data)
    {
        if (data.size() != 0)  // Проверка на пустую БД
        {
            boolean check = false; // Флаг для проверки вхождения записи в БД
            int phone = CheckPhone.CheckNumbers("Введите номер телефона для удаления");
            for (int i = 0; i < data.size(); i++)
            {
                if (phone == data.get(i).getPhoneNumber())
                {
                    data.remove(i);
                    System.out.printf("Номер %d удален.\n", phone);
                    check = true;
                }
            }
            if (check == false) System.out.println("Такого номера нет.");
        }
        else System.out.println("База данных пуста.\nДобавьте что-нибудь через add.");
        return data;
    }
}
