package simpleDataBase;

import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main  {

	static List<Student> students = new ArrayList<Student>();
	static String path = "C:\\Users\\Arbnor\\eclipse-workspace\\SimpleDataBase\\src\\database\\student.csv";
	static File file = new File(path);

	static Scanner scan; 

	
	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		Student s1 = new Student(10, "jane", "doe", 19);
		
//		students.add(s1);
//		createStudent();
//		System.out.println(students.get(0).name);
		
		System.out.println(getStudent(file, 42).age);

//		createStudent();
		
//		String.format("%n");
		
//		PrintStream fileStream = new PrintStream(file);
//		fileStream.println(Integer.toString(s1.id) + "," + s1.name + "," + s1.surname + "," + Integer.toString(s1.age) + "\r\n");

		
	}
	
	
	public static Student getStudent(File file, int id)  {
		
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No File Found To Read");
		}
		
		Student a = new Student(1, "a", "a", 1);
		
		while(scan.hasNextLine()) {
			String row = scan.nextLine();
			String[] columns = row.split(",");
//			System.out.println(columns[0]);
			if(Integer.parseInt(columns[0]) == id) {
//				System.out.println("exist");
				a = new Student(Integer.parseInt(columns[0]), columns[1], columns[2], Integer.parseInt(columns[3]));
				
			}
		}
		return a;
	}
	
	public static void createStudent()  {
		
		scan = new Scanner(System.in);
		
		System.out.println("Enter Student id: ");
		int id = scan.nextInt();
		System.out.println("Enter Student name: ");
		String name = scan.next();
		System.out.println("Enter Student surname: ");
		String surname = scan.next();
		System.out.println("Enter Student age: ");
		int age = scan.nextInt();
		
//		students.add(new Student(id, name, surname, age));
		save(file, new Student(id, name , surname, age));
		

		
	}
	
	public static void save(File file, Student student) {
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(file, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fw.append(Integer.toString(student.id) + "," + student.name + "," + student.surname + "," + Integer.toString(student.age));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
