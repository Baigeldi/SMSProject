package com.company;

import java.io.Serializable;
import java.util.Locale;
import java.util.Scanner;

public class Student implements Serializable {
    private String name;
    private String surname;
    private String login;
    private String password;
    private int id;
    private int course;
    private int contract;
    private int payed = 0;
    private int chet;

    public Student(String name, String surname, String login, String password, int course, int contract, int chet) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.id = Human.genUniqueId();
        this.course = course;
        this.contract = contract;
        this.chet = chet;
    }

    public static void searchStudID() {
        boolean temp = false;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ID студента:");
            int id = scanner.nextInt();
            for (Student student : Main.students) {
                if (id == student.getId()) {
                    System.out.println("ФИО студента: " + student.getSurname() + " " + student.name);
                    System.out.println("ID студента: " + student.getId());
                    System.out.println("Курс студента: " + student.getCourse());
                    System.out.println("Контракт студента: " + student.getContract());
                    System.out.println("*******************************************");
                    temp = true;
                }
            }
            if (temp) {
                School.restart();
                break;
            }
            if (!temp) {
                System.out.println("Такого студента нет! Повторите попытку!");
            }
        }
    }

    public static void searchStudName() {
        boolean temp = false;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя студента:");
            String name = scanner.nextLine();
            for (Student student : Main.students) {
                if (student.getName().toLowerCase().matches("(.*)" + name.toLowerCase() + "(.*)")) {
                    System.out.println("ФИО студента: " + student.getSurname() + " " + student.getName());
                    System.out.println("ID студента: " + student.getId());
                    System.out.println("Курс студента: " + student.getCourse());
                    System.out.println("Контракт студента: " + student.getContract());
                    System.out.println("*********************************************");
                    temp = true;
                }
            }
            if (temp) {
                School.restart();
                break;
            }
            if (!temp) {
                System.err.println("Такого студента нет!");
            }
        }
    }

    public static void getAllStudents() {
        for (Student student : Main.students) {
            getStudentInfo(student);
        }
    }

    static void getStudentInfo(Student student) {
        System.out.println("ФИО студента: " + student.getSurname() + " " + student.name);
        System.out.println("ID студента: " + student.getId());
        System.out.println("Курс студента: " + student.getCourse());
        System.out.println("Контракт студента: " + student.getContract());
        System.out.println("**********************************************");
    }

    public static void addNewStud() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вашу фамилию...");
        String surname = scanner.next();
        Human.lowerFirsSurename(surname);
        System.out.println("Введите ваше имя...");
        String name = scanner.next();
        Human.lowerFirsName(name);
        System.out.println("Придумайте логин...");
        String login = scanner.next();
        Human.loginGmail(login);
        System.out.println("Придумайте пароль...");
        String password = null;
        password = Human.passwordSetting(password);
        int contract = 0;
        int course = 0;
        int schet = 0;
        boolean c = false;
        while (true) {
            try {
                int first = 1;
                int two = 2;
                int three = 3;
                int foure = 4;
                int fifty = 5;
                int six = 6;
                course = courseLimit(course);
                contract = contractLimit(contract);
                schet = dobovlenieCheta(first, two, three, foure, fifty, six);
                c = true;
            } catch (Exception e) {
                System.err.println("Ошибка! Неверный формат ввода!");
            }
            if (c) {
                break;
            }
        }
        Student student = new Student(Human.lowerFirsSurename(surname), Human.lowerFirsName(name), Human.loginGmail(login), password, course, contract, schet);
        Main.students.add(student);
        System.out.println("ФИО студента: " + Human.lowerFirsSurename(surname) + " " + Human.lowerFirsName(name));
        System.out.println("ID студента: " + student.getId());
        System.out.println("Курс студента: " + course);
        System.out.println("Денег на карте:" + schet);
        System.out.println("Логин студента: " + Human.loginGmail(login));
        System.out.println("Контракт студента: " + contract + " сомов");
        System.out.println("Пароль студента: " + password);
        System.out.println("Информация о новом студенте успешно добавлена в базу данных");
    }

    private static int contractLimit(int contract) {
        boolean b = false;
        while (true) {
            System.out.println("Укажите стоимость контракта");
            Scanner scan = new Scanner(System.in);
            int c = scan.nextInt();
            if (c >= 3000 && c <= 16000) {
                contract = c;
                b = true;
            }
            if (b == false) {
                System.err.println("Минимальный контракт 3000 сомов, а максимальный 16000 сомов");
            }
            if (b == true) {
                break;
            }
        }
        return contract;
    }

    private static int courseLimit(int course) {
        boolean b = false;
        while (true) {
            System.out.println("Введите курс студента...");
            Scanner scan = new Scanner(System.in);
            int c = scan.nextInt();
            if (c <= 6) {
                course = c;
                b = true;
            }
            if (b == false) {
                System.err.println("Такого курса нет!");
            }
            if (b == true) {
                break;
            }
        }
        return course;
    }

    public static int dobovlenieCheta(int first, int two, int three, int foure, int fifty, int six) {
        int schet = 0;
        boolean temp2 = false;
        while (true) {
            System.out.println("Введите ID своего банковского счета:");
            Scanner scanner = new Scanner(System.in);
            int idCheta = scanner.nextInt();
            if (idCheta == first) {
                schet = 10000;
                temp2 = true;
            }
            if (idCheta == two) {
                schet = 20000;
                temp2 = true;
            }
            if (idCheta == three) {
                schet = 30000;
                temp2 = true;
            }
            if (idCheta == foure) {
                schet = 40000;
                temp2 = true;
            }
            if (idCheta == fifty) {
                schet = 50000;
                temp2 = true;
            }
            if (idCheta == six) {
                schet = 60000;
                temp2 = true;
            }

            if (!temp2) {
                System.err.println("Такого счета нет!");
            }
            if (temp2) {
                break;

            }
        }
        return schet;
    }

    public static void payedContract() {
        boolean temp = false;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ID кому хотите оплатить контракт");
            int id = scanner.nextInt();
            for (Student student : Main.students) {
                if (id == student.getId()) {
                    System.out.println("Это ученик :" + student.getSurname() + " " + student.getName());
                    payContract(student);
                    temp = true;
                }
            }
            if (temp) {
                break;
            }
            if (temp == false) {
                System.err.println("Такого сотрудника нет!");
            }
        }
    }

    private static void payContract(Student student) {
        System.out.println("Бюджет школы состовляет: " + Main.theSchoolsBadge);
        System.out.println("Контракт состовляет " + student.getContract() + " сомов");
        System.out.println("Денег на карте: " + (student.getChet() + " cомов"));
        boolean daNet = false;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите 'ДА', если хотите оплатить контракт или 'НЕТ', чтобы отменить процесс");
            String vvod = scanner.nextLine();
            if (vvod.toLowerCase(Locale.ROOT).equals("да")) {
                if (student.getChet() < student.getContract()) {
                    System.err.println("У вас не достаточно денег на счете чтобы оплатить контракт");
                    daNet = true;
                }
                if (student.getChet() > student.getContract()) {
                    System.out.println("Вы оплатили контракт");
                    System.out.println("Было денег на счету: " + student.getChet());
                    int b = (student.getChet() - student.getContract());
                    System.out.println("Осталось денег на счету: " + b);
                    System.out.println("-Бюджет школы состовляло: " + Main.theSchoolsBadge);
                    Main.theSchoolsBadge = Main.theSchoolsBadge + student.getContract();
                    System.out.println("Стало: " + Main.theSchoolsBadge);
                    b = student.getChet();
                    daNet = true;
                }
            }
            if (vvod.toLowerCase(Locale.ROOT).equals("нет")) {
                System.err.println("Не забудьте оплатить контракт, а то Вас отчислят");
                daNet = true;
            }
            if (!daNet) {
                System.err.println("Введите 'ДА' или 'НЕТ'");
            }
            if (daNet) {
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public int getCourse() {
        return course;
    }

    public int getContract() {
        return contract;
    }

    public int getPayed() {
        return payed;
    }

    public int getChet() {
        return chet;
    }
}
