package helloapp;

import java.util.Comparator;
import java.util.TreeSet;

public class Program {
	  public static void main(String[] args) {
		   
		  Comparator<Student> studentComparator = new StudentNameComparator() //компараторы
				  								     .thenComparing(new StudentSurnameComparator())
				  								     .thenComparing(new StudentGpaComparator());
		  
		  TreeSet<Student> students = new TreeSet<Student>(studentComparator); // TreeSet
		  
		  students.add(new Student("Tom", "White", 4.9));
		  students.add(new Student("Nick", "Black", 4.2));
		  students.add(new Student("Tom", "Yellow", 3.5));
		  students.add(new Student("Bill", "Red", 5.0));
		  students.add(new Student("Tom", "Yellow", 2.5));
		  
		  for(Student  s : students){
			  
			    System.out.println(s.GetName() + " " + s.GetSurname() + " " + s.GetGpa());
			}	
		  
		  StudentsActions startedStudingStudents = new StudentsActions() {  //анонимные классы

			@Override
			public void StartAction() {
				System.out.println("Студенты начали учебу!");				
			}
		  };
		  
		  StudentsActions finishedStudingStudents = new StudentsActions() {

				@Override
				public void StartAction() {
					System.out.println("Студенты закончили учебу!");						
		    }
		  };
			  
		   startedStudingStudents.StartAction();
		   finishedStudingStudents.StartAction();
	        
	    }
}

class Student{    
    String name;    
    String surname;
    double gpa;
    
    Student(String name, String surname, double gpa){
        this.name = name;
        this.surname = surname;
        this.gpa = gpa;
        } 
    
    String GetName(){return name;}
    String GetSurname(){return surname;}
    double GetGpa(){return gpa;}  
}

class StudentNameComparator implements Comparator<Student>{
	  
    public int compare(Student a, Student b){
      
        return a.GetName().compareTo(b.GetName());
    }
}

class StudentSurnameComparator implements Comparator<Student>{
	  
    public int compare(Student a, Student b){
      
        return a.GetSurname().compareTo(b.GetSurname());
    }
}

class StudentGpaComparator implements Comparator<Student>{
  
    public int compare(Student a, Student b){
      
        if(a.GetGpa() > b.GetGpa())
            return 1;
        else if(a.GetGpa() < b.GetGpa())
            return -1;
        else
            return 0;
    }
}



