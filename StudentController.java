package controller;

import java.util.Scanner;
import Dto.StudentDto;
import studentException.StudentNotFoundException;
import Dao.StudentDao;

public class StudentController {
	public static void main(String[] args) throws InterruptedException {
		while (true) {
			Scanner std = new Scanner(System.in);
			StudentDto studentDto = new StudentDto();
			StudentDao studentDao = new StudentDao();
			System.out.println("_____Select option____");
			System.out.println("1. Insert");
			System.out.println("2. Read ");
			System.out.println("3. Update");
			System.out.println("4. Delete");
		  	System.out.println("5. Exit>>>");
			int opt = 0;
			opt = std.nextInt();
			switch (opt) {
			case 1:
				boolean b = true;
				while(b) {
					System.out.println("____Insert___");
					System.out.println("Enter Student Id: ");
					studentDto.setSid(std.nextInt());
					System.out.println("Enter Student name: ");
					studentDto.setSname(std.next());
					System.out.println("Enter Student email id: ");
					studentDto.setSeid(std.next());
					System.out.println("Enter Student ph no.: ");
					studentDto.setMob(std.nextLong());
					// insert Data
					studentDao.insert(studentDto);
					System.out.println("Data inserted successfully");
					Thread.sleep(1000);
					System.out.println("Want to add one more ? click (y)/(n)");
					String val = std.next();
					if(val.equals("y")) {
						continue;
					}else {
						break;
					}
				}
				break;
			case 2:
				// read data
				System.out.println("<<Select option>>");
				System.out.println("1. Read By ID");
				System.out.println("2. Read All");
				int op = std.nextInt();
				switch (op) {
				case 1:
					System.out.println("Enter id to read");
					int id = std.nextInt();
					System.out.println("fetching this id.....");
					Thread.sleep(3000);
					try {
						studentDao.readById(id);
					}catch(StudentNotFoundException e) {
						System.out.println(e.getMsg());
					}
					System.out.println("Data fatched Sucessfully..");
					break;
				case 2:
					System.out.println(" fetching All the data......");
					Thread.sleep(2000);
					studentDao.readAll();
					System.out.println("\nFetched Successfully....");
					break;
				}
				break;
				
			//Update
			case 3:
				System.out.print("Enter id to update : ");
				int id = std.nextInt();
				System.out.println("Enter new name: ");
				String str = std.next();
				System.out.println("Enter new Mob: ");
				long val = std.nextLong();
				System.out.println("Enter seid");
				String email = std.next();
				studentDto.setSid(id);
				studentDto.setSeid(email);
				studentDto.setSname(str);
				studentDao.update(studentDto);
				break;
			//Delete
			case 4:
				int del;
				System.out.println("Select the Option");
				System.out.println("1. Delete By Id");
				System.out.println("2. Delete All");
				int o = std.nextInt();
			switch(o) {
			case 1:
				System.out.println("Enter ID to delete");
				studentDao.deleteById(std.nextInt());
				break;
			case 2:
				System.out.println("Do You really want to delete all?(y)/(n)");
				String s2 = std.next();
				if(s2.equals("y")) {
					studentDao.deleteAll();
				}
				System.out.println("All the data get deleted....");
				break;
			}
				break;
			case 5:
				return;
			}

		}

	}
}
