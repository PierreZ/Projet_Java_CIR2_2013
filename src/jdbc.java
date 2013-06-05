import java.sql.*;
   
   
public class jdbc {
	
	 String url;
     String user;
     String passwd;
     String driver ;
     int solde;
     Connection con = null;
     Statement st = null;
     ResultSet rs = null;
     
     
     
     
	public jdbc() {
        url = new String("127.0.0.1/conges");
        user  = new String("conges");
        passwd = new String("conges");
        driver = new String("com.mysql.jdbc.Driver");
	}
	
	public void connexionbdd(){
		try{
		 Class.forName(driver).newInstance();
		DriverManager.getConnection("jdbc:mysql://"+url,user,passwd);
		System.out.println("connexion réussite");
		}
		  catch(Exception e){
	        	System.err.println("Exception: " + e.getMessage());

	        }
		
	}

	
	
	public int retourSolde(String login){
		
	        try {
	            Class.forName(driver).newInstance();
	            con = DriverManager.getConnection("jdbc:mysql://"+url,user, passwd);
	            st = con.createStatement();
	            rs = st.executeQuery("SELECT SOLDE FROM UTILISATEUR WHERE LOGIN = \""+login +"\"");
	            rs.next();
	            solde=rs.getInt(1);
	            System.out.println(solde);
		
	        }
	        catch(Exception e){
	        	System.err.println("Exception: " + e.getMessage());

	        }
		
		
		return solde;
	}
	
	

	public boolean testconnexion(String login,String mot_de_passe){
		

        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection("jdbc:mysql://"+url,user, passwd);
            st = con.createStatement();
            rs = st.executeQuery("SELECT MOT_DE_PASSE FROM UTILISATEUR WHERE LOGIN =\""+login +"\"");
            rs.next();
            if(rs.getString(1)!=mot_de_passe){
            	System.out.println("test");

            	
            }
            return true;
        }    
        
        catch(Exception e){
        	System.err.println("Exception: " + e.getMessage());
			
        	return false;
        }
		
	
	}
	
	public boolean jourferie(Date date_ferie){
		try{
		 st = con.createStatement();
         rs = st.executeQuery("SELECT DATE_FERIE FROM JOUR_FERIE WHERE DATE_FERIE =\""+ date_ferie +"\"");
         rs.next();
         if(rs.getDate(1)!=null){
         
         return true;
         }else{
        	 return false;
         }
         
		}
		catch(Exception e){
			System.err.println("Exception: " + e.getMessage());
			return false;
		}
		
	}
	
	
}
