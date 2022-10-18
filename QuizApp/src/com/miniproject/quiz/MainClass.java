package com.miniproject.quiz;

import java.util.Scanner;
import java.sql.*;

public class MainClass {
	public static void main(String[] args) {
		for(int i=1;i<=2;i++) {
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter the Unique ID");
			int id=sc.nextInt();
			System.out.println("Enter the your Name");
			String name=sc.next();
			QuestionClass qn=new QuestionClass();	
			qn.startQuiz();
			int score=qn.count;
			
			String url ="jdbc:mysql://localhost:3306/quizapp";
			String username ="root";
			String password ="jagdish@5484";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn =DriverManager.getConnection(url,username,password);
				Statement stmt =conn.createStatement();
				ResultSet rs =stmt.executeQuery("select * from studentinfo");
				System.out.println("Connected");
				
				PreparedStatement pstmt=conn.prepareStatement("insert into studentinfo(studentid,studentname,studentscore)values(?,?,?)");
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, score);
				int j=pstmt.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

	}

}

}
