import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> familyCollection = new HashMap<>();
        TreeMap<String, Integer> workerCollection = new TreeMap<>();
        String list = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, " +
                "Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, " +
                "Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.";
//        fillCollection(familyCollection);
//        listWorker(workerCollection,list);
    }

    static Map<Integer, String> fillCollection(Map<Integer, String> getCollection) {
        //Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
        Map<String, List<Integer>> listCollection = new HashMap<>();
        getCollection.put(123456, "Иванов");
        getCollection.put(321456, "Васильев");
        getCollection.put(234561, "Петрова");
        getCollection.put(234432, "Иванов");
        getCollection.put(654321, "Петрова");
        getCollection.put(345678, "Иванов");
        for (Map.Entry entry : getCollection.entrySet()) {
            if (listCollection.containsKey(entry.getValue())) {
                listCollection.get(entry.getValue()).add((Integer) entry.getKey());
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add((Integer) entry.getKey());
                listCollection.put((String) entry.getValue(), newList);
            }
        }
        for (Map.Entry list : listCollection.entrySet()) {
            System.out.println(list);
        }
        return getCollection;
    }

    static TreeMap<String, Integer> listWorker(TreeMap<String, Integer> workerColl, String getList) {
        /*
        Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова,
        Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова,
        Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет
        повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
        */
        getList.replace(".", "").split(",");
        String[] listS = getList.split(" ");
        List<String> workerList = new ArrayList<>();

        for (int i = 0; i < listS.length; i += 2) {
            workerList.add(listS[i]);
        }

        int count = 1;
        for (String worker : workerList) {
            if (workerColl.containsKey(worker)) {
                count = workerColl.get(worker);
                count++;
                workerColl.put(worker, count);
            } else {
                count = 1;
                workerColl.put(worker, count);
            }
        }
        List<Integer> listInt = new ArrayList<>();
        for (Map.Entry getNum : workerColl.entrySet()) {
            listInt.add((Integer) getNum.getValue());
        }
        Collections.sort(listInt);
        Collections.reverse(listInt);
        HashMap<String, Integer> filtered = new LinkedHashMap<>();
        for (int i = 0; i < listInt.size(); i++) {
            for (Map.Entry getNum : workerColl.entrySet()) {
                if (listInt.get(i) == getNum.getValue()) {
                    filtered.put((String) getNum.getKey(), listInt.get(i));
                }
            }
        }

        System.out.println(filtered);
        return workerColl;
    }
}