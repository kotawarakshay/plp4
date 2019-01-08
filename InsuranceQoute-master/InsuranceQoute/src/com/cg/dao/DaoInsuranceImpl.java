package com.cg.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.bean.PolicyBean;
import com.cg.bean.QuestionBean;
import com.cg.util.DBConnection;

public class DaoInsuranceImpl implements IDaoInsurance{

	
	QuestionBean questionBean = new QuestionBean();
	
	Connection con = null;
	PreparedStatement pst = null; 
	Statement cs=null;
	ResultSet rs= null;
	@Override
	public ArrayList<PolicyBean> createPolicy(String businessSegment) throws ClassNotFoundException, IOException, SQLException {
		
		ArrayList<PolicyBean> al = new ArrayList<>();
		try {
		   con=DBConnection.getConnection();
		    cs=con.createStatement();
		    rs=cs.executeQuery("select * from policycreation where business_segment='"+businessSegment+"'");
			
			
			while(rs.next()) {
			PolicyBean policyBean=new PolicyBean();
				policyBean.setBusinessSegment(rs.getString(1));
				policyBean.setQuestion(rs.getString(2));
				policyBean.setAnswer1(rs.getString(3));
				policyBean.setWeightage1(rs.getInt(4));
				policyBean.setAnswer2(rs.getString(5));
				policyBean.setWeightage2(rs.getInt(6));
				policyBean.setAnswer3(rs.getString(7));
				policyBean.setWeightage3(rs.getInt(8));
				al.add(policyBean);
			}
			
		}
		catch(Exception e) {
			
		}
		
		return al;
	}

	@Override
	public int PolicyQuestion(QuestionBean ques) {
		int premium=0;
		PreparedStatement ps1=null;
		try {
			 con=DBConnection.getConnection();
			  pst=con.prepareStatement("insert into QA values (?,?,?,?,?)");
			  
			 pst.setString(1, ques.getQuestion());
			 pst.setString(2, ques.getAnswer());
			 pst.setInt(3, ques.getWeightage());
			 pst.setString(4,ques.getBusinessSegment());
			 pst.setString(5, ques.getUsername());
			 int i=pst.executeUpdate();
           cs=con.createStatement();
           ps1=con.prepareStatement("select sum(weightage) from qa where businesssegment=? and username=?");
           ps1.setString(1,ques.getBusinessSegment() );
           ps1.setString(2, ques.getUsername());
           rs=ps1.executeQuery();
           if(rs.next()) {
        	   premium=rs.getInt(1);
        	 
           }
			
			  
		}
		catch(Exception e)
		{
			System.out.println("Exception while Insertion");
		}
		return premium;
	}

}
