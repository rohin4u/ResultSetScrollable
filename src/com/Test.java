package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
		
				Statement st =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				ResultSet rs=st.executeQuery("select * from employee");
				
				System.out.println("Records in Original Order");
				
				System.out.println("EMP\tEID\tEADDR");
				
				System.out.println("---------------------------");
				while(rs.next())
				{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				}
				rs.first();// First Record
				System.out.println(rs.getRow()+"--->"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				rs.last();//Last Record
				System.out.println(rs.getRow()+"--->"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				rs.relative(-2);//2nd Record from the last
				System.out.println(rs.getRow()+"--->"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				rs.absolute(2);//2nd Record
				System.out.println(rs.getRow()+"--->"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				con.close();
	}

}
