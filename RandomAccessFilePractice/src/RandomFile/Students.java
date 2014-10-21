package RandomFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Students {
	RandomAccessFile file;
	int section=32;
	
	public Students(){
		file=null;
	}
	
	public void open(String name) throws IOException{
		if(file!=null)
			file.close();
		
		file=new RandomAccessFile(name,"rw");
	}
	
	public int size() throws IOException{
		return (int)(file.length()/section);
	}
	
	public Student read(int n) throws IOException{
		file.seek(section*n);
		int StudentId=file.readInt();
		double GPA=file.readDouble();
		String name=file.readUTF();
		Scanner scan=new Scanner(name);
		String first=new String();
		String second=new String();
		
		if(scan.hasNext())
			first=scan.next();
		if(scan.hasNext())
			second=scan.next();
		scan.close();
		return new Student(first, second, GPA,StudentId);
	}
	
	
	public void write(int n, Student stud) throws IOException{
		file.seek(n*section);
		
		file.writeUTF(stud.getFirstName()+ " "+stud.getLastName());
		file.writeDouble(stud.getGPA());
		file.writeInt(stud.getID());
	}
	
	public int find(int ID) throws IOException{
		
		for(int i=0; i<size(); i++){
			file.seek(section*i);
			if(file.readInt()==ID)
				return i;
		}
		
		
		return -1 ;
	}

}
