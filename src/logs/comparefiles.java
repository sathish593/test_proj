package logs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class comparefiles {

	public comparefiles() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException {
		 File file1 =
			      new File("C:\\Users\\ukumar18\\Downloads\\proj\\Dental\\tickets\\duncan recon\\duncan project testing\\from db.txt");
		 File file2 =
			      new File("C:\\Users\\ukumar18\\Downloads\\proj\\Dental\\tickets\\duncan recon\\duncan project testing\\from zip.txt");
		 Scanner sc = new Scanner(file1);
		 
		 Scanner sc1 = new Scanner(file2);
		 List<String> from_db= new ArrayList<String>();
		 List<String> from_zip= new ArrayList<String>();
		 while (sc.hasNextLine()) {
		      from_db.add(sc.nextLine());
		      
		 }
		 System.out.println("db pdf count"+from_db.size());
		 while (sc1.hasNextLine())
		 {
			 from_zip.add(sc1.nextLine());
		 }
		 System.out.println("zip pdf count"+from_zip.size());
		 
		 int i=0;
		 for (String item : from_db) {
			if(!from_zip.contains(item)) {
				System.out.println(++i +"--pdf not there in zips---"+item);
			}
		}
		 
		 int j=0;
		 for (String item : from_zip) {
			if(!from_db.contains(item)) {
				System.out.println(++j +"--pdf not there in Db---"+item);
			}
		}
		 
	}
}
