package main;

import features.*;
import models.*;
import util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManagement um = new UserManagement();
        CourseManagement cm = new CourseManagement();
        EnrollmentManagement em = new EnrollmentManagement();

        // creating default admin for example
        em.register("Admin", "admin@example.com", "000", "admin123", "admin");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add Student\n2.Delete Student\n3.Add Course \n4.Delete Course");
            System.out.println("5.Enroll \n6.Unenroll \n7.Login \n8.List Users \n9.List Courses\n10.Exit");
            System.out.println("------------------");
            System.out.print(" Please Enter Your Choice : ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 0) break;
            switch (ch) {
                case 1 -> {
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("Email: "); String e = sc.nextLine();
                    System.out.print("Phone: "); String p = sc.nextLine();
                    System.out.print("Pass: "); String pw = sc.nextLine();
                    User s = um.addStudent(n, e, p, pw);
                    System.out.println("Student added: " + s.userId);
                }
                case 2 -> {
                    System.out.print("Student ID: ");
                    String id = sc.nextLine();
                    System.out.println(um.deleteStudent(id) ? "Deleted" : "Not found");
                }
                case 3 -> {
                    System.out.print("Course Name: "); String cn = sc.nextLine();
                    System.out.print("Duration: "); String d = sc.nextLine();
                    CourseModel c = cm.addCourse(cn, d);
                    System.out.println("Course added: " + c.courseId);
                }
                case 4 -> {
                    System.out.print("Course ID: ");
                    String id = sc.nextLine();
                    System.out.println(cm.deleteCourse(id) ? "Deleted" : "Not found");
                }
                case 5 -> {
                    System.out.print("Student ID: "); String sid = sc.nextLine();
                    System.out.print("Course ID: "); String cid = sc.nextLine();
                    System.out.println(em.enroll(sid, cid) ? "Enrolled" : "Failed");
                }
                case 6 -> {
                    System.out.print("Student ID: "); String sid = sc.nextLine();
                    System.out.print("Course ID: "); String cid = sc.nextLine();
                    System.out.println(em.unenroll(sid, cid) ? "Unenrolled" : "Failed");
                }
                case 7 -> {
                    System.out.print("Email: "); String e = sc.nextLine();
                    System.out.print("Pass: "); String pw = sc.nextLine();
                    LoginModel lm = new LoginModel(e, pw);
                    User u = em.login(lm);
                    System.out.println(u != null ? "Login Success " + u.userType : "Invalid");
                }
                case 8 -> {
                    for (int i = 0; i < Utils.userCount; i++) {
                        User u = Utils.users[i];
                        System.out.println(u.userId + " " + u.username + " " + u.userType);
                    }
                }
                case 9 -> {
                    for (int i = 0; i < Utils.courseCount; i++) {
                        CourseModel c = Utils.courses[i];
                        System.out.println(c.courseId + " " + c.courseName);
                    }
                }
            }
        }
        sc.close();
    }
}
