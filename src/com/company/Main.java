package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Логин и пароль бухгалтера: nur@gmail.com, N17.

public class Main {
    static List<Student> students = new ArrayList<>();
    static List<Human> employees = new ArrayList<>();
    public static Accountant accountant;
    public static double theSchoolsBadge = 400000;

    public static void main(String[] args) {
        HashMap<Integer, Integer> bankChet = new HashMap<>();
        bankChet.put(1, 10000);
        bankChet.put(2, 20000);
        bankChet.put(3, 30000);
        bankChet.put(4, 40000);
        bankChet.put(5, 50000);
        bankChet.put(6, 60000);

        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Accountant> accountants = new ArrayList<>();
        ArrayList<Nurse> nurses = new ArrayList<>();
        ArrayList<Security> securities = new ArrayList<>();
        ArrayList<Cook> cooks = new ArrayList<>();
        ArrayList<StreetCleaner> streetCleaners = new ArrayList<>();

        Teacher ainagul = new Teacher("Айнагул","Умарбекова","ai@gmail.com","A12","Старший учитель",27000,5,bankChet.get(4));
        Teacher jyldyz = new Teacher("Жылдыз","Умаркулова","jyl@gmail.com","J12","Старший учитель",27000,5,bankChet.get(4));
        Teacher malika = new Teacher("Малика","Сагынбекова","mal@gmail.com","M12","учитель",23000,4,bankChet.get(2));
        Teacher aiganysh = new Teacher("Айганыш","Сагынова","aig@gmail.com","Aa12","учитель",23000,4,bankChet.get(2));
        Teacher jibek = new Teacher("Жибек","Султанова","jib@gmail.com","Jj12","учитель",22000,3,bankChet.get(1));
        Teacher begimay = new Teacher("Бегимай","Сулайманова","beg@gmail.com","B12","учитель",22000,2,bankChet.get(1));

        teachers.add(ainagul);
        teachers.add(jyldyz);
        teachers.add(malika);
        teachers.add(aiganysh);
        teachers.add(jibek);
        teachers.add(begimay);

        Cook tanya = new Cook("Таня","Лазерова","tan@gmail.com","T13","Старший повар",30000,6,bankChet.get(2));
        Cook dastan = new Cook("Дастан","Кадыров","das@gmail.com","D13","повар",23000,4,bankChet.get(1));
        cooks.add(tanya);
        cooks.add(dastan);
        Nurse elnura = new Nurse("Эльнура","Касымова","kas@gmail.com","E14","Медсестра",30000,4,bankChet.get(4));
        nurses.add(elnura);
        Security timur = new Security("Тимур","Кадырбеков","tim@gmail.com","T15","Охранник",15000,4,bankChet.get(1));
        securities.add(timur);
        StreetCleaner jyngyz = new StreetCleaner("Чынгыз","Муратов","jyn@gmail.com","J16","Дворник",15000,4,bankChet.get(1));
        streetCleaners.add(jyngyz);
        accountant = new Accountant("Нурсулуу","Мырзакова","nur@gmail.com","N17","Бухгалтер",35000,8,bankChet.get(5));
        accountants.add(accountant);

        employees.addAll(teachers);
        employees.addAll(cooks);
        employees.addAll(nurses);
        employees.addAll(securities);
        employees.addAll(streetCleaners);
        employees.addAll(accountants);

        Student azizbek = new Student("Азизбек","Муратов","az@gmail.com","A18",1,25000,bankChet.get(1));
        Student bakyt = new Student("Бакыт","Ысмаилов","bak@gmail.com","B18",1,25000,bankChet.get(1));
        Student sultan = new Student("Султан","Жалилов","sul@gmail.com","S18",2,30000,bankChet.get(2));
        Student bektursun = new Student("Бектурсун","Бакытов","bekt@gmail.com","B18",2,30000,bankChet.get(2));
        Student beksultan = new Student("Бексултан","Муратов","beks@gmail.com","Bb18",3,25000,bankChet.get(3));
        Student nurjan = new Student("Нуржан","Сагынбеков","sag@gmail.com","S18",3,25000,bankChet.get(3));
        Student akbermet = new Student("Акбермет","Муратова","ak@gmail.com","Aa18",4,25000,bankChet.get(4));
        Student zarina = new Student("Зарина","Муратбекова","za@gmail.com","Z18",4,25000,bankChet.get(4));

        students.add(azizbek);
        students.add(bakyt);
        students.add(sultan);
        students.add(bektursun);
        students.add(beksultan);
        students.add(nurjan);
        students.add(akbermet);
        students.add(zarina);

        System.out.println("------SCHOOL MANAGEMENT SYSTEM------");
        System.out.println("*************************************");

        School.file();
        School.theWelcome();

    }
}
