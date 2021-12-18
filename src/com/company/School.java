package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class School implements Serializable {

    public static void theWelcome() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Войти");
            System.out.println("2.Выход");
            try {
                int choice = scanner.nextInt();
                if (choice < 3 && choice > 0) {
                    switch (choice) {
                        case 1:
                            login();
                            break;
                        case 2:
                            System.out.println("Выход из системы...");
                            System.exit(0);
                            break;
                    }
                } else {
                    System.out.println("Нет такого раздела! Введите правильное число");
                }
            } catch (Exception e) {
                System.out.println("Неверный форма ввода! Повторите ввод");
                scanner.next();
            }
        }
    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Поиск студентов и сотрудников");
            System.out.println("2.Просмотр всех студентов и сотрудников");
            System.out.println("3.Добавлять новых студентов и сотрудников");
            System.out.println("4.Оплачивать контракт студента или заработную плату сотрудника");
            System.out.println("5.Выйти и сохранить");
            try {
                int choice = scanner.nextInt();
                if (choice < 6 && choice > 0) {
                    switch (choice) {
                        case 1:
                            search();
                            restart();
                            break;
                        case 2:
                            getAllPeople();
                            restart();
                            break;
                        case 3:
                            addNewPerson();
                            restart();
                            break;
                        case 4:
                            payContract();
                            restart();
                            break;
                        case 5:
                            save();
                    }
                } else {
                    System.out.println("Нет такого раздела! Повторите ввод");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("Неверный формат ввода! Повторите ввод");
                scanner.next();
            }
        }
    }

    private static void payContract() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Выдать зарплату сотруднику");
            System.out.println("2.Оплатить контракт студента");
            System.out.println("3.Перевести деньги сотрудникам");
            try {
                int choice4 = scanner.nextInt();
                if (choice4 < 4 && choice4 > 0) {
                    switch (choice4) {
                        case 1:
                            Human.payedSalary();
                            break;
                        case 2:
                            Student.payedContract();
                            break;
                        case 3:
                            Human.transferOfFunds();
                            break;
                    }
                } else {
                    System.out.println("Нет такого раздела! Введите правильное число");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("Неверный формат ввода! Повторите ввод");
                scanner.next();
            }
        }
    }

    private static void addNewPerson() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Добавить новых сотрудников");
            System.out.println("2.Добавить новых сотрудников");
            try {
                int x = scanner.nextInt();
                if (x < 3 && x > 0) {
                    switch (x) {
                        case 1:
                            Human.addNewSot();
                            break;
                        case 2:
                            Student.addNewStud();
                            break;
                    }
                } else {
                    System.out.println("Нет такого раздела! Введите правильное число");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("Неверный формат ввода! Повторите ввод");
                scanner.next();
            }
        }
    }

    private static void getAllPeople() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Инфорация о всех студентах");
            System.out.println("2.Информация о всех сотрудниках");
            System.out.println("3.Информация о школе");
            try {
                int choice5 = scanner.nextInt();
                if (choice5 < 4 && choice5 > 0) {
                    switch (choice5) {
                        case 1:
                            System.out.println("Информация о всех студентах:");
                            Student.getAllStudents();
                            System.out.println("Количество всех студентов: " + Main.students.size());
                            break;
                        case 2:
                            System.out.println("Информация о всех сотрудниках");
                            Human.getAllEmployees();
                            System.out.println("Количество всех сотрудников: " + Main.employees.size());
                            break;
                        case 3:
                            System.out.println("Информация о школе:");
                            schoolInformation();
                            break;
                    }
                } else {
                    System.out.println("Такого раздела нет!");
                    scanner.next();
                }

            } catch (Exception e) {
                System.out.println("Неверный формат ввода! Повторите ввод");
                scanner.next();
            }
        }
    }

    private static void schoolInformation() {
        System.out.println("Школа гимназии №3 им. М.В.Ломоносова");
        System.out.println("Количество сотрудников составляет: " + Main.employees.size());
        System.out.println("Количество студентов составляет: " + Main.students.size());
        int totalSalary = 0;
        int totalContract = 0;

        for (int i = 0; i < Main.employees.size(); i++) {
            totalSalary = totalSalary + Main.employees.get(i).getSalary();
        }
        for (int i = 0; i < Main.students.size(); i++) {
            totalContract = totalContract + Main.students.get(i).getContract();
        }
        System.out.println("За месяц сотрудникам выдается: " + totalSalary + " сомов");
        System.out.println("Общий контрак студентов составляет: " + totalContract + " сомов");
    }

    private static void search() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Поиск студентов");
            System.out.println("2.Поиск сотрудников");
            try {
                int choice = scanner.nextInt();
                if (choice < 3 && choice > 0) {
                    switch (choice) {
                        case 1:
                            System.out.println("1.Искать всех студентов по ID");
                            System.out.println("2.Искать всех студентов по имени");
                            int choice2 = scanner.nextInt();
                            switch (choice2) {
                                case 1:
                                    Student.searchStudID();
                                    break;
                                case 2:
                                    Student.searchStudName();
                                    break;
                            }
                        case 2:
                            System.out.println("1.Искать всех сотрудников по ID");
                            System.out.println("2.Искать всех сотрудников по имени");
                            int choice3 = scanner.nextInt();
                            switch (choice3) {
                                case 1:
                                    Human.searchSotID();
                                    break;
                                case 2:
                                    Human.searchSotName();
                                    break;
                            }
                    }
                } else {
                    System.out.println("Нет такого раздела! Введите правильно число");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("Неверный формат ввода! Повторите ввод");
                scanner.next();
            }
        }
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.println("Введите свой логин...");
            String y = scanner.nextLine();
            System.out.println("Введите свой пароль...");
            String x = scanner.nextLine();
            if (y.equals(Main.accountant.getLogin()) && x.equals(Main.accountant.getPassword())) {
                System.out.println("Здравствуйте, " + Main.accountant.getName() + "!");
                System.out.println("Что будем делать сегодня?");
                System.out.println("**************************");
                System.out.println();
                mainMenu();
                break;
            } else {
                count++;
                System.out.println("Неправильный пароль или логин! Осталось попыток: " + (3 - count));
            }
            if (count == 3) {
                System.out.println("Использовано 3 попыток ввода. Программа завершена");
                break;
            }
        }
    }

    public static void restart() {
        boolean d = false;
        System.out.println("Нажмите любое число, чтобы перейти в главное меню");
        System.out.println("Нажмите 0 чтобы завершить процесс и сохранить изминение");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int b = scanner.nextInt();
                if (b == 0) {
                    save();
                }
                d = true;
                mainMenu();
                break;
            } catch (Exception e) {
                System.err.println("Нажмите любое ЧИСЛО чтобы перейти в главное меню!");
            }
            if (d) {
                break;
            }
        }
    }

    private static void save() {
        try {
            ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("employees"));
            ois.writeObject(Main.employees);
            ObjectOutputStream oys = new ObjectOutputStream(new FileOutputStream("students"));
            oys.writeObject(Main.students);
            ObjectOutputStream ofs = new ObjectOutputStream(new FileOutputStream("ids"));
            ofs.writeObject(Human.ids);
            ObjectOutputStream of = new ObjectOutputStream(new FileOutputStream("theSchoolsBadge"));
            of.writeObject(Main.theSchoolsBadge);
            of.close();
            ois.close();
            oys.close();
            ofs.close();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Запись не удалась");
        }
    }

    public static void file() {
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("employees"));
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("students"));
            ObjectInputStream osf = new ObjectInputStream(new FileInputStream("ids"));
            ObjectInputStream oj = new ObjectInputStream(new FileInputStream("theSchoolsBadge"));
            Main.theSchoolsBadge = (Double) oj.readObject();
            Main.employees = (ArrayList<Human>) oos.readObject();
            Main.students = (ArrayList<Student>) os.readObject();
            Human.ids = (ArrayList<Integer>) osf.readObject();
            oj.close();
            osf.close();
            oos.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка! Не удалось прочитать файл.");
        }
    }
}
