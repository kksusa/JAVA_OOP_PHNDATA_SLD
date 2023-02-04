import java.util.ArrayList;
import java.io.*;

public class ManageOutData {

    /**Вывод списка абонентов в консоль*/
    public static void List(ArrayList<Subscriber> data)
    {
        if (data.size() != 0) // Проверка на пустую БД
        {
            for (int i = 0; i < data.size(); i++)
            {
                System.out.printf("Номер: %d, Абонент: %s\n", data.get(i).getPhoneNumber(), data.get(i).getName());
            }
        }
        else System.out.println("База данных пуста.\nДобавьте что-нибудь через add.");
    }

    /**Чтение данных из внешнего хранилища*/
    public static ArrayList <Subscriber> Read()
    {
        ArrayList<Subscriber> data = new ArrayList<>();
        String filename = "data.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            if (filename.isEmpty()) return data; // Проверка на пустой файл
            else
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    String array[] = line.split(" "); // Разбиение каждой записи как строки на две строки в массив
                    data.add(new Subscriber(array[0], Integer.parseInt(array[1])));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return data;
    }

    /**Запись данных во внешнее хранилище*/
    public static void Write(ArrayList<Subscriber> data)
    {
        String filename = "data.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            for (int i = 0; i < data.size(); i++)
            {
                writer.write(data.get(i).getName() + " " + data.get(i).getPhoneNumber() + "\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
