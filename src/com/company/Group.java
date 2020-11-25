package com.company;

import java.util.Arrays;

public class Group {
    private Student group[] =new Student[10];
    private int k=0;
    public Group(){}
    public void addStudent (Student student) throws MyNewException{

        for(int i=0; i<k; i++){
            if (student.getRecordBook() == group[i].getRecordBook()) {
                System.out.println("Этот студент уже есть в группе");
                break;
            }
        }
        for (int i = 0; i < group.length; i++) {
            if (group[i] == null) {
                group[i] = student;
                System.out.println("Студент успешно добавлен в группу. В группе "+k+" студ.");
                k++;
                return;
            }

        }
        throw new MyNewException();
    }
    public void deleteStudent(Student student){
        int i=1;
        for(; i<k; i++){
            if(student.getRecordBook() == group[i].getRecordBook()){
                group[i]=null;
                k--;
                System.out.println("Студен удалён из этой группы. В группе "+k+" студ.");
                for(; i<k; i++){
                    group[i]=group[i+1];
                }
            }
        }
    }
    public Student findStudent(String surname){
        for(int i=0; i<k;i++){
            if(surname.equals(group[i].getSurname()))
            {
                System.out.println("Студент найден.");
                return group[i];
            }
        }
        return null;
    }
    public Student[] sortirovka(Student[] grooup){
        for(int i=0; i<k;i++){
            String minSurname=grooup[i].getSurname();
            Student min=grooup[i];
            int position=i;
            for (int j=i+1; j<k;j++){
                if(grooup[j].getSurname().compareTo(minSurname)<0){
                    position=j;
                    minSurname=grooup[j].getSurname();
                    min=grooup[j];
                }
            }
            grooup[position]=grooup[i];
            grooup[i]=min;
        }
        return grooup;
    }

    @Override
    public String toString() {
        return "Group{" +
                "group=" +  Arrays.toString(sortirovka(group)) +
                '}';
    }
}
