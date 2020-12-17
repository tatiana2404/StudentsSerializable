package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Group implements Voenkom, Serializable{

    private static final long serialVersionUID=1l;
    private Student Students[] =new Student[10];
    private String nameGroup;
    private int k=0;

    public Group(){}

    public Student[] getStudents() {

        return Students;
    }

    public void setStudents(Student[] Students) {
        this.Students = Students;
    }

    public String getNameGroup() {
        Scanner s=new Scanner(System.in);
        System.out.println("Введите название группы");
        nameGroup=s.nextLine();
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }




    public void addStudent (Student student) throws MyNewException{

        for (int i = 0; i < Students.length; i++) {
            if (Students[i] == null) {
                Students[i] = new Student(AddFact.newSurname(), AddFact.newName(), AddFact.newAge(), AddFact.newGender(),
                        AddFact.newCourse(), AddFact.newRecordBook());

                k++;
                System.out.println("Студент успешно добавлен в группу. В группе "+k+" студ.");
                return;
            }

        }

        throw new MyNewException();
    }

    public Student[] sortSurname(){
        Arrays.sort(Students, Comparator.nullsFirst(new SurnameComparator()));
        return Students;
    }
    public Student[] sortSurnameGender(){
        Arrays.sort(Students, Comparator.nullsFirst(new GenderComparator()));
        return Students;
    }

    public Student findStudent(){
        Scanner str=new Scanner(System.in);
        str.nextLine();
        System.out.println("Введите фамилию студента, которого хотите найти: ");
        String line = str.nextLine();
        for(int i = 0; i< Students.length; i++){
            if(Students[i]!=null && line.equals(Students[i].getSurname()))
            {
                System.out.println("Студент найден.");
                return Students[i];
            }
        }
        return null;
    }
    public void deleteStudent(){
        Scanner str=new Scanner(System.in);
        str.nextLine();
        System.out.println("Введите фамилию студента, которого хотите удалить: ");
        String line = str.nextLine();
        for(int i = 0; i< Students.length; i++){
            if(Students[i]!=null && line.equals(Students[i].getSurname())){
                Students[i]=null;
                k--;
                System.out.println("Студен удалён из этой группы. В группе "+k+" студ.");
            }
        }
    }

    public void saveToFile(){
        try(ObjectOutputStream OOS=new ObjectOutputStream(new FileOutputStream(getNameGroup()))){
            OOS.writeObject(Students);
            System.out.println("Успешно сохранено");
            Students =new Student[10];
            k=0;
        } catch(IOException e){
            System.out.println("Ошибка при сохранение");
        }
    }
    public Group readFromFile(){
        Group readGroup=new Group();
        Students=null;
        try (ObjectInputStream OIS=new ObjectInputStream(new FileInputStream(getNameGroup()))){
            Students=(Student[]) OIS.readObject();
            readGroup.setStudents(Students);
            System.out.println("Успешно считано");
            return readGroup;
        } catch(IOException |
                ClassNotFoundException e){
            System.out.println("Ошибка считывания");
        }
       return null;
    }



    @Override
    public Student[] otbor() {
        Student[] voen=new Student[k];
        int n=0;
        for(int i=0; i<k; i++){
            if(Students[i].getGender().equals(Sex.man) && Students[i].getAge()>18 ){
                voen[0]= Students[i];
                n++;
            }
        }
        if (n>0){
            return voen;
        }
        else {
            System.out.println("Таких студентов нет");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "Students=" + Arrays.toString(Students) +
                '}';
    }

}