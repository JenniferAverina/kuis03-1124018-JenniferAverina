package kuis03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

class EmptyListException extends Exception {
    public EmptyListException(String message) {
        super(message);
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class CustomList<T extends Number> {
    private ArrayList<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public int getNumbers() {
        return list;
    }

    // public static String askForString(String message) {
    // return message;
    // }

    // public ArrayList<Number> getNumber() {
    // // String input = askForString(message);
    // // if (input == null) {
    // // return 0;
    // // }
    // // try {
    // // return Integer.parseInt(input)
    // // } catch (InvalidInputException e) {
    // // System.out.println("input tidak valid. masukkan int");
    // // }
    // return list;

    // }

    public void add(T element) {
        list.add(element);
    }

    public void sortList() throws InvalidInputException {
        list.sort((a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));
        System.out.println("list tersort: " + list);
    }

    public double getAverage(T element) throws EmptyListException {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = list.get(i);
            i++;
        }
    }

    // ArrayList<Number> numbers
    public T getMax() throws EmptyListException {
        int max = (int) list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (max < (int) list.get(i)) {
                max = (int) list.get(i);
            }
        }
        System.out.println(max);
        return list.get(max);
        
    }

    public T getMin() throws EmptyListException {
        int min = (int) list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (min > (int) list.get(i)) {
                min = (int) list.get(i);
            }
        }
        return list.get(min);
    }

    public static String askForString(String message) {
        return message;
    }

    public static int askForInt(String message) {
        String input = askForString(message);
        if (input == null) {
            return 0; // Kembalikan 0 (atau -1) sebagai penanda 'batal'
        }
        try {
            return Integer.parseInt(input);
        } catch (InvalidInputException e) {
            System.out.println("input tidak valid. masukkan int");
        }
    }
}

public class App {
    public static void main(String[] args) {
        CustomList<Number> numberList = new CustomList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("MENU");
            System.out.println("1. Tambah Angka");
            System.out.println("2. Tampilkan Rata-Rata");
            System.out.println("3. Tampilkan Nilai Maksimum");
            System.out.println("4. Tampilkan Nilai Minimum");
            System.out.println("5. Tampilkan Median");
            System.out.println("6. Tampilkan Daftar (Sorted)");
            System.out.println("0. keluar");
            System.out.print("pilih menu: ");
            int menu = sc.nextInt();

            switch (menu) {
                case 0:
                    break;
                case 1:
                    try {
                        System.out.println("masukkan angka: ");
                        int number = sc.nextInt();
                        numberList.add(number);
                        if (numberList == 0) {
                            
                        }

                    } catch (EmptyListException e) {
                        // TODO: handle exception
                    }
                    break;
                case 3:
                    System.out.println(numberList.getMax());
                    break;
                case 4:
                    System.out.println(numberList.getMin());
                case 6:
                    try {
                        numberList.sortList();
                        if (Number.IsNan(numberList)) {

                        }
                    } catch (InvalidInputException e) {
                        System.out.println("input harus numerik");
                    }
                default:
                    break;
            }
        }
    }

}