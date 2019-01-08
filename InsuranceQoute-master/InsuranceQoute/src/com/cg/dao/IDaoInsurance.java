package com.cg.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.bean.PolicyBean;
import com.cg.bean.QuestionBean;


public interface IDaoInsurance {
	public  ArrayList<PolicyBean> createPolicy(String businessSegment) throws ClassNotFoundException, IOException, SQLException;


	int PolicyQuestion(QuestionBean question);
	
}
