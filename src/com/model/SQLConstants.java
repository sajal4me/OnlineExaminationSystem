package com.model;

public interface SQLConstants {
	
	String REGISTER_SQL_ADMIN="INSERT INTO admin_login(name,email,password) VALUES(?,?,?)";
	String LOGIN_SQL_ADMIN="SELECT email,password FROM admin_login WHERE email=? and password=?";
	/*String Register_SQL_USER="INSERT INTO user_login(name,email,pass,mobileNumber,security_id,ans) VALUES(?,?,?,?,?,?)";*/
	
	// This Query Save User's Details in Db at the time Of Registration and Random Salt Value 
		String Register_SQL_USER="INSERT INTO user_login(name,email,pass,salt,mobileNumber,security_id,ans) VALUES(?,?,?,?,?,?,?)";
	
   /* String LOGIN_SQL_USER="SELECT email,pass from user_login WHERE email=? and pass=?";*/
		
	String LOGIN_SQL_USER="SELECT email,pass,salt from user_login WHERE email=?  ";
		
    String USER_FEEDBACK="SELECT * FROM feedback";
    String SELECT_ANS_USER="SELECT ans FROM user_login WHERE email=?";
    String SELECT_SECURITY_QUESTION="SELECT * FROM security_question";
    String FETCH_USERNAME="SELECT name FROM user_login WHERE email= ? ";
    String SAVE_FEEDBACK="INSERT INTO feedback(email,user_feedback,currentTime) VALUES(?,?,? )";
    
    //This Query Updates Password
    String UPDATE_PASS="UPDATE user_login SET pass=? WHERE email=?";
    String USER_RECOVERY_SECURITY_QUESTION="select question from security_question WHERE question_id=(select security_id from user_login where email=?)";
    String ADD_CATEGORY="INSERT INTO categories(category_name) VALUES(?)";
    String ADD_SET="INSERT INTO category_set(category_ref,no_of_question) VALUES(?,?)";
    String ADD_TOPIC="INSERT INTO topic(category_ref,topic_name) VALUES(?,?)";
    String ADD_QUESTION="INSERT INTO question_container(question,option_a,option_b,option_c,option_d,answer,set_ref,topic_ref,category_ref) VALUES(?,?,?,?,?,?,?,?,?) ";
    String SELECT_CATEGORY="SELECT * FROM categories";
    String SELECT_SET="SELECT * FROM category_set";
    String SELECT_TOPIC="SELECT * FROM topic";
    String SELECT_QUESTION="SELECT * FROM question_container";
    String UPDATE_QUESTION="UPDATE question_container SET question=?,option_a=?,option_b=?,option_c=?,option_d=?,answer=? WHERE question_no=?";
    String UPDATE_SET="UPDATE category_set SET no_of_question=? WHERE set_id=?";
    String UPDATE_TOPIC="UPDATE topic SET category_ref=?,topic_name=? WHERE topic_id=?";
    String SELECT_PARTICULAR_QUESTION="SELECT question,option_a,option_b,option_c,option_d,answer,set_ref,topic_ref,category_ref FROM question_container WHERE (question_no=?);";
    String SELECT_PARTICULAR_SET="SELECT no_of_question FROM category_set WHERE set_id=?";
    String SELECT_PARTICULAR_TOPIC="SELECT topic_name FROM topic WHERE topic_id=?";
    
    //This Query Gives The Table Having Details(CategoryName,Total Set,Total Topic)
    
    String CATEGORY_DETAILS="SELECT category_name, COUNT(DISTINCT set_id) AS sets, COUNT(DISTINCT topic_id) AS topics FROM (((categories AS c) LEFT OUTER JOIN (category_set AS cset) ON c.category_id=cset.category_ref ) LEFT OUTER JOIN topic ON c.category_id=topic.category_ref) GROUP BY category_id,category_name";
    
    //This Query Gives Set Id,No. Of Questions In Set.
    String GETSET_ID_QUES="SELECT set_id, no_of_question FROM category_set WHERE category_ref = (SELECT category_id FROM categories WHERE category_name=?)";
    
    //This Query Gives Topic Id,TopicName in Topic.
    String GETTOPIC_ID_NAME="SELECT topic_id, topic_name FROM topic WHERE category_ref = (SELECT category_id FROM categories WHERE category_name=?)";
    
    //This Query Checks The Current Password For the LoggedInUser.
    String GET_CURRENT_PASSWORD="SELECT pass FROM user_login WHERE email=?";
    
    //This Query used to get Profile Of User.
    String GET_PROFILE="select name,email,pass,mobileNumber,security_id,ans FROM user_Login WHERE email=?";
    
    //This Query Gives The Ques From Id
    String GET_PROFILE_QUES="SELECT question FROM security_question WHERE question_id=?";
    
    //This Query Update The User Profile From User Dashboard
    String UPDATE_USER_PROFILE="UPDATE user_login SET name=?,pass=?,mobileNumber=? WHERE email=?";
    
    //This Query Is Used To Get Particular Set Questions.
    String GET_SET_QUES="SELECT question_no,question,option_a,option_b,option_c,option_d,answer FROM question_container WHERE set_ref=? AND category_ref=?";
    
    //This Query Is Used To Get Particular Topic Questions.
    String GET_TOPIC_QUES="SELECT question_no,question,option_a,option_b,option_c,option_d,answer FROM question_container WHERE topic_ref=? AND category_ref=?";
    
    //This Query Is Used To Get The CategoryId From CategoryName
    String GET_CATEGORY_ID="SELECT category_id FROM categories WHERE category_name=?";
    
    //This Query Is Used To Get The CategoryName From CategoryId.
    String GET_CATEGORY_NAME="SELECT category_name FROM categories WHERE category_id=?";
    
    //This Query Is Used To get Answer For A QuestionId.
    String GET_ANSWER="SELECT answer FROM question_container WHERE question_no=?";
    
 
    //This Query is used to save user data by Set
    String SAVE_TEST_DATA_BY_SET="INSERT INTO user_score(email,marks_obtained,time_taken,question_attempted,correctly_answered,wrongly_answered,total_question,set_ref,category_type,date_time) VALUES(?,?,?,?,?,?,?,?,?,?)";
    
    //This Query is used to save user data by Topic
    String SAVE_TEST_DATA_BY_TOPIC="INSERT INTO user_score(email,marks_obtained,time_taken,question_attempted,correctly_answered,wrongly_answered,total_question,topic_ref,category_type,date_time) VALUES(?,?,?,?,?,?,?,?,?,?)";
    
    //This Query is Used to Fetch User Score and Using Alias name for the Columns.(Metadata)
    String GET_USER_SCORE="SELECT marks_obtained AS Score,time_taken AS Duration,question_attempted AS Attempted,correctly_answered AS Correct ,wrongly_answered AS Wrong,total_question AS TOTAL,set_ref,topic_ref,category_type,date_time AS DATE FROM user_score WHERE email=?";
    
    //This Query is used to Fetch Set For Particular Category Id.
    String GET_SET_FOR_CATEGORY="SELECT set_id FROM category_set WHERE category_ref=?";
    
    //This Query Is Used To Fetch Topic For Particular Category Id.
    String GET_TOPIC_FOR_CATEGORY="SELECT topic_id,topic_name FROM topic WHERE category_ref=?";
    
    //This Query Is Used To Fetch Question For Particular Category Id.
    String GET_QUESTION_FOR_CATEGORY="SELECT question_no,question FROM question_container WHERE category_ref=?";
    
    //This Query Is Used To Remove Category From DataBase
    String DELETE_CATEGORY="DELETE FROM categories WHERE category_id=?";
    
    //This Query Is Used To Remove Set From DataBase
    String DELETE_SET="DELETE FROM category_set WHERE set_id=?";
    
    //This Query Is Used To Remove Topic From DataBase
    String DELETE_TOPIC="DELETE FROM topic WHERE topic_id=?";
    
    //This Query Is Used To Remove Question From DataBase
    String DELETE_QUESTION="DELETE FROM question_container WHERE question_no=?";
    
    // This Query is used to give top 5 user
    String TOP5_USER="SELECT name,user_score.email, SUM(marks_obtained) FROM user_score INNER JOIN user_login ON user_score.email=user_login.email GROUP BY email ORDER BY SUM(marks_obtained) DESC LIMIT 5";
    
    //This Query Is Used To Give User Details.
    String GET_USER_DETAILS="SELECT * FROM user_login";
    
    //This Query Is Used TO Get Security Name From Security Id.
    String GET_SECURITY_ID="SELECT question FROM security_question WHERE question_id=?";
    
    //This Query Is Used To Show Complete User Score To Admin.
    String ALL_USER_SCORE="SELECT * FROM user_score";
    
  //This Query Is Used Get Salt From E-mailId.
    String GET_SALT="SELECT salt FROM user_login WHERE email=?";
    
  //This Query Is Used To Get A Particular Set For Particular CategoryId.
    String GET_PARTICULAR_SET="SELECT set_id,no_of_question FROM category_set WHERE category_ref=?";
    
  //This Query Is Used To Get A Particular Topic For Particular CategoryId.
    String GET_PARTICULAR_TOPIC="SELECT topic_id,topic_name FROM topic WHERE category_ref=?";
    
  //This Query Is Used To Get A Particular Question For Particular CategoryId.
    String GET_PARTICULAR_QUESTION="SELECT question_no,question,option_a,option_b,option_c,option_d,answer,set_ref,topic_ref FROM question_container WHERE category_ref=?";
    
    
}
