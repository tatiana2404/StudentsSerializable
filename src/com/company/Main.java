package com.company;

public class Main {

    public static void main(String[] args) {
        Student s1=new Student("Бырченко", "Татьяна", 24, Sex.woman,
            "РФ-131", 3, "МК 789456");
        Student s2=new Student("Мельник", "Дмитрий", 25, Sex.man,
                "РФ-131", 3, "НР 782585");
        Student s3=new Student("Иванов", "Андрей", 21, Sex.man,
                "РФ-131", 3, "РО 782128");
        Student s4=new Student("Петрова", "Валерия", 25, Sex.woman,
                "РФ-131", 3, "МТ 782157");
        Student s5=new Student("Кожухарь", "Екатерина", 26, Sex.woman,
                "РФ-131", 3, "АН 896457");
        Student s6=new Student("Нахаба", "Елена", 24, Sex.woman,
                "РФ-131", 3, "АН 896457");
        Student s7=new Student("Олехин", "Степан", 23, Sex.man,
                "РФ-131", 3, "АН 482167");
        Student s8=new Student("Афанасьев", "Дмитрий", 23, Sex.man,
                "РФ-131", 3, "АН 157965");
        Student s9=new Student("Михайлов", "Владислав", 23, Sex.man,
                "РФ-131", 3, "ОН 157934");
        Student s10=new Student("Цокур", "Олег", 26, Sex.man,
                "РФ-131", 3, "МН 781577");
        Student s11=new Student("Борова", "Наталья", 24, Sex.woman,
                "РФ-131", 3, "МТ 157867");
        Student s12=new Student("Синицина", "Ангелина", 23, Sex.woman,
                "РФ-131", 3, "ОА 847625");
        Student s13=new Student("Синицина", "Ангелина", 23, Sex.woman,
                "РФ-131", 3, "ОА 457625");
        Group group= new Group();
        try{group.addStudent(s1);
        group.addStudent(s2);
        group.addStudent(s3);
        group.addStudent(s4);
        group.addStudent(s5);
        group.addStudent(s6);
        group.addStudent(s7);
        group.addStudent(s8);
        group.addStudent(s9);
        group.addStudent(s10);
        group.addStudent(s11);
        }
        catch (MyNewException e){
            System.out.println("Индекс за пределами массива."+e);
        }

       group.deleteStudent(s3);

        System.out.println(group.findStudent("Мельник").toString());
        System.out.println(group.toString());
    }
}
