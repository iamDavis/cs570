import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;


  public class testdb {
	  public static void main(String[] args) {
		// set up database's user name, password and URL
		String usr = "postgres";
		String pwd = "270688";
		String url = "jdbc:postgresql://localhost:5432/postgres";
	    ArrayList<String> Elist = new ArrayList<String>();
	    ArrayList<String> Klist = new ArrayList<String>();
	    ArrayList<String> Blist = new ArrayList<String>();
	    ArrayList<String> Hlist =new ArrayList<String>();
	    ArrayList<String> Slist = new ArrayList<String>();
	      
	    //cadmy
	    ArrayList<Integer> Elistc = new ArrayList<Integer>();
	    ArrayList<String> Elistp = new ArrayList<String>();
	    ArrayList<String> Elistd = new ArrayList<String>();
	    ArrayList<String> Elistm = new ArrayList<String>();
	    ArrayList<String> Elisty = new ArrayList<String>();
	    
	    ArrayList<Integer> Klistc = new ArrayList<Integer>();
	    ArrayList<String> Klistp = new ArrayList<String>();
	    ArrayList<String> Klistd = new ArrayList<String>();
	    ArrayList<String> Klistm =new ArrayList<String>();
	    ArrayList<String> Klisty = new ArrayList<String>();
	    
	    
	    ArrayList<Integer> Blistc = new ArrayList<Integer>();
	    ArrayList<String> Blistp = new ArrayList<String>();
	    ArrayList<String> Blistd = new ArrayList<String>();
	    ArrayList<String> Blistm = new ArrayList<String>();
	    ArrayList<String> Blisty = new ArrayList<String>();
	    
	    ArrayList<Integer> Hlistc = new ArrayList<Integer>();
	    ArrayList<String> Hlistp = new ArrayList<String>();
	    ArrayList<String> Hlistd = new ArrayList<String>();
	    ArrayList<String> Hlistm = new ArrayList<String>();
	    ArrayList<String> Hlisty =new ArrayList<String>();
	    
	    ArrayList<Integer> Slistc = new ArrayList<Integer>();
	    ArrayList<String> Slistp = new ArrayList<String>();
	    ArrayList<String> Slistd = new ArrayList<String>();
	    ArrayList<String> Slistm = new ArrayList<String>();
	    ArrayList<String> Slisty = new ArrayList<String>();
	    
	    
	try {
		Class.forName("org.postgresql.Driver");
		System.out.println("Successfully loaded the driver!");
		}
		catch (Exception e) {
		System.out.println("Failed to load the driver!");
		e.printStackTrace();
		}
		// connecting server
		try {
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Successfully connected to the server!");
			// get query result to ResultSet rs
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Sales");

			
			while (rs.next()) {
				String cust = rs.getString("cust");
				int quant = rs.getInt("quant");
				String day = rs.getString("day");
				String month = rs.getString("month");
				String pro = rs.getString("prod");
				String year = rs.getString("year");
				
				
				 if( day.length()<2) {
					   day = "0"+rs.getString("day");
					   
				  }
				  if( month.length()<2) {
					   month = "0"+rs.getString("month");
					  
				  }
				
					
				if(cust.equals("Emily")) {
					Elistc.add(quant);
					Elist.add(cust);
					Elistp.add(pro);
					Elistd.add(day);
					Elistm.add(month);
					Elisty.add(year);
					
				}if(cust.equals("Knuth")) {
					Klistc.add(quant);
					Klistp.add(pro);
					Klistd.add(day);
					Klistm.add(month);
					Klisty.add(year);
					Klist.add(cust);
				}
				if(cust.equals("Bloom")) {
					Blistc.add(quant);
					Blistp.add(pro);
					Blistd.add(day);
					Blistm.add(month);
					Blisty.add(year);
					Blist.add(cust);
					
				}
				if(cust.equals("Helen")) {
					Hlistc.add(quant);
					Hlistp.add(pro);
					Hlistd.add(day);
					Hlistm.add(month);
					Hlisty.add(year);
					Hlist.add(cust);
				}
				if(cust.equals("Sam")) {
					Slistc.add(quant);
					Slistp.add(pro);
					Slistd.add(day);
					Slistm.add(month);
					Slisty.add(year);
					Slist.add(cust);
				}
								
			}
			}
			catch (SQLException e) {
			System.out.println("Connection URL or username or password errors!");
			e.printStackTrace();
			}
		
		
		System.out.println("Max quant!");
		 int quanqt = Collections.max(Elistc);
	
		 int index = Elistc.indexOf(quanqt);
		
		 System.out.println(Elist.get(index) + " "+Elistc.get(index) + " "+Elistp.get(index) + " "+Elistd.get(index) +"/"+Elistm.get(index)+ "/"+Elisty.get(index));
		 
		 
		 int quanqt01 = Collections.max(Blistc);
	
		 int index01 = Blistc.indexOf(quanqt01);
		
		 System.out.println(Blist.get(index01) + " "+Blistc.get(index01) + " "+Blistp.get(index01) + " "+Blistd.get(index01) +"/"+Blistm.get(index01)+ "/"+Blisty.get(index));
		 
		 
		 int quanqt02 = Collections.max(Slistc);
			
		 int index02 = Slistc.indexOf(quanqt02);
		
		 System.out.println(Slist.get(index02) + " "+Slistc.get(index02) + " "+Slistp.get(index02) + " "+Slistd.get(index02) +"/"+Slistm.get(index02)+ "/"+Slisty.get(index02));
		 
		 int quanqt03 = Collections.max(Klistc);
			
		 int index03= Klistc.indexOf(quanqt03);
		
		 System.out.println(Klist.get(index03) + " "+Klistc.get(index03) + " "+Klistp.get(index03) +  " "+Klistd.get(index03) +"/"+Klistm.get(index03)+ "/"+Klisty.get(index03));
		 
		 int quanqt04 = Collections.max(Hlistc);
			
		 int index04= Hlistc.indexOf(quanqt04);
		
		 System.out.println(Hlist.get(index04) + " "+Hlistc.get(index04) + " "+Hlistp.get(index04) + " "+Hlistd.get(index04) +"/"+Hlistm.get(index04)+ "/"+Hlisty.get(index04));
		 
		 System.out.println("Min quant!");
		 int quanqt0 = Collections.min(Elistc);
			
		 int index0 = Elistc.indexOf(quanqt0);
		
		 System.out.println("Emily"+" "+Elistc.get(index0) + " "+Elistp.get(index0) + " "+Elistd.get(index0) +"/"+Elistm.get(index0)+ "/"+Elisty.get(index0));
		 
		 
		 int quanqt001 = Collections.min(Blistc);
	
		 int index001 = Blistc.indexOf(quanqt001);
		
		 System.out.println("Bloom"+" "+Blistc.get(index001) + " "+Blistp.get(index001) + " "+Blistd.get(index001) +"/"+Blistm.get(index001)+ "/"+Blisty.get(index001));
		 
		 
		 int quanqt002 = Collections.min(Slistc);
			
		 int index002 = Slistc.indexOf(quanqt002);
		
		 System.out.println("Sam"+ " "+Slistc.get(index002) + " "+Slistp.get(index002) + " "+Slistd.get(index002) +"/"+Slistm.get(index002)+ "/"+Slisty.get(index002));
		 
		 int quanqt003 = Collections.min(Klistc);
			
		 int index003= Klistc.indexOf(quanqt003);
		
		 System.out.println("Knuth"+ " " +Klistc.get(index003) +" " + Klistp.get(index003) + " " +Klistd.get(index003) +"/" +Klistm.get(index003)+ "/" +Klisty.get(index003));
		 
		 int quanqt004 = Collections.min(Hlistc);
			
		 int index004= Hlistc.indexOf(quanqt004);
		
		 System.out.println("Helen"+ " "+ Hlistc.get(index004) + " "+ Hlistp.get(index004) + " "+ Hlistd.get(index004) +"/"+ Hlistm.get(index004)+ "/"+ Hlisty.get(index004));
 
		 // 1 2000 2005
		 System.out.println("Max Jan between 2000 and 2005!");
		 ArrayList<Integer> Elist11 = new ArrayList<Integer>();
		 for(int i=0;i<Elistm.size();i++) {

			int d =  Integer.parseInt(Elistm.get(i));
			int y = Integer.parseInt(Elisty.get(i));
			 if(d ==1 && (y>=2000 && y<= 2005)) {
				 Elist11.add(Elistc.get(i));
			 }
		 }
		 // max jan 2000-2005
		 int quan = Collections.max(Elist11);
		 int ind = Elistc.indexOf(quan);
		
		 System.out.println("Emily"+" "+Elistc.get(ind) + " "+Elistp.get(ind) +" "+ Elistd.get(ind) +"/"+ Elistm.get(ind)+"/" +  Elisty.get(ind));
		 
		 
		 
		 
		 ArrayList<Integer> Blist11 = new ArrayList<Integer>();
		 for(int i=0;i<Blistm.size();i++) {

			int d =  Integer.parseInt(Blistm.get(i));
			int y = Integer.parseInt(Blisty.get(i));
			 if(d ==1 && (y>=2000 && y<= 2005)) {
				 Blist11.add(Blistc.get(i));
			 }
		 }
		 // max jan 2000-2005
		 int quan1 = Collections.max(Blist11);
	
		 int ind1 = Blistc.indexOf(quan1);
		
		 System.out.println("Bloom "+ Blistc.get(ind1) + " "+Blistp.get(ind1) + " "+Blistd.get(ind1) +"/"+Blistm.get(ind1)+ "/"+Blisty.get(ind1));
		 
		 ArrayList<Integer> Hlist11 = new ArrayList<Integer>();
		 for(int i=0;i<Hlistm.size();i++) {

			int d =  Integer.parseInt(Hlistm.get(i));
			int y = Integer.parseInt(Hlisty.get(i));
			 if(d ==1 && (y>=2000 && y<= 2005)) {
				 Hlist11.add(Hlistc.get(i));
			 }
		 }
		 // max jan 2000-2005
		 int quan2 = Collections.max(Hlist11);
	
		 int ind2 = Hlistc.indexOf(quan2);
		
		 System.out.println("Helen"+ " "+Hlistc.get(ind2) + " "+Hlistp.get(ind2) + " "+Hlistd.get(ind2) +"/"+Hlistm.get(ind2)+ "/"+Hlisty.get(ind2));
		 
		 ArrayList<Integer> Klist11 = new ArrayList<Integer>();
		 for(int i=0;i<Klistm.size();i++) {

			int d =  Integer.parseInt(Klistm.get(i));
			int y = Integer.parseInt(Klisty.get(i));
			 if(d ==1 && (y>=2000 && y<= 2005)) {
				 Klist11.add(Klistc.get(i));
			 }
		 }
		 // max jan 2000-2005
		 int quan3 = Collections.max(Klist11);
		
		 int ind3 = Klistc.indexOf(quan3);
		
		 System.out.println("Knuth "+Klistc.get(ind3) +" "+ Klistp.get(ind3) + " "+Klistd.get(ind3) +"/"+Klistm.get(ind3)+ "/"+Klisty.get(ind3));
		 
		 ArrayList<Integer> Slist11 = new ArrayList<Integer>();
		 for(int i=0;i<Slistm.size();i++) {

			int d =  Integer.parseInt(Slistm.get(i));
			int y = Integer.parseInt(Slisty.get(i));
			 if(d ==1 && (y>=2000 && y<= 2005)) {
				 Slist11.add(Slistc.get(i));
			 }
		 }
		 // max jan 2000-2005
		 int quan4 = Collections.max(Slist11);
		
		 int ind4 = Slistc.indexOf(quan4);
		
		 System.out.println("Sam"+ "  "+Slistc.get(ind4) +" "+ Slistp.get(ind4)+ " " + Slistd.get(ind4)+ "/" +Slistm.get(ind4)+ "/"+Slisty.get(ind4));
		 
		 System.out.println("mini feb:" ); 
		 ArrayList<Integer> Elist111 = new ArrayList<Integer>();
		 for(int i=0;i<Elistm.size();i++) {

			int d =  Integer.parseInt(Elistm.get(i));
			 if(d ==2) {
				 Elist111.add(Elistc.get(i));
			 }
		 }
		 // max jan 2000-2005
		 int quan111 = Collections.min(Elist111);
	
		 int ind111= Elistc.indexOf(quan111);
		
		 System.out.println("Emily"+" "+Elistc.get(ind111) + " "+Elistp.get(ind111) + " "+Elistd.get(ind111) +"/"+Elistm.get(ind111)+ "/"+Elisty.get(ind111));
		 
		 
		 
		 
		 
		 
		 ArrayList<Integer> Blist111 = new ArrayList<Integer>();
		 for(int i=0;i<Blistm.size();i++) {
         int d =Integer.parseInt(Blistm.get(i));
			 if(d ==2) {
				 Blist111.add(Blistc.get(i));
			 }
		 }
		 int quan11 = Collections.min(Blist111);
	     int ind11 = Blistc.indexOf(quan11);
		
		 System.out.println("Bloom "+ Blistc.get(ind11) + " "+Blistp.get(ind11) + " "+Blistd.get(ind11) +"/"+Blistm.get(ind11)+ "/"+Blisty.get(ind11));
		 
		 ArrayList<Integer> Hlist111 = new ArrayList<Integer>();
		 for(int i=0;i<Hlistm.size();i++) {
             int d =  Integer.parseInt(Hlistm.get(i));
			 if(d ==2) {
				 Hlist111.add(Hlistc.get(i));
			 }
		 }
		int quan22 = Collections.min(Hlist111);
		int ind22 = Hlistc.indexOf(quan22);
		
		 System.out.println("Helen "+Hlistc.get(ind22) + " "+Hlistp.get(ind22) + " "+Hlistd.get(ind22) +"/"+Hlistm.get(ind22)+ "/"+Hlisty.get(ind22));
		 
		 ArrayList<Integer> Klist111 = new ArrayList<Integer>();
		 for(int i=0;i<Klistm.size();i++) {

			int d =  Integer.parseInt(Klistm.get(i));
		         if(d ==2 ) {
				 Klist111.add(Klistc.get(i));
			 }
		 }
		 //min feb 
		 int quan33 = Collections.min(Klist111);
		 int ind33 = Klistc.indexOf(quan33);
		 System.out.println("Knuth "+Klistc.get(ind33) +" "+ Klistp.get(ind33) + " "+Klistd.get(ind33) +"/"+Klistm.get(ind33)+ "/"+Klisty.get(ind33));
		 
		 ArrayList<Integer> Slist111 = new ArrayList<Integer>();
		 for(int i=0;i<Slistm.size();i++) {
           int d =  Integer.parseInt(Slistm.get(i));
			 if(d ==2 ) {
				 Slist111.add(Slistc.get(i));
			 }
		 }
		 // MIN FEB 
		 int quan44 = Collections.min(Slist111);
		
		 int ind44 = Slistc.indexOf(quan44);
		
		 System.out.println("Sam"+ "  "+Slistc.get(ind44) +" "+ Slistp.get(ind44)+ " " + Slistd.get(ind44)+ "/" +Slistm.get(ind44)+ "/"+Slisty.get(ind44));
		 
		 
		 
		 
		 
		 System.out.println("mini Mar:" ); 
		 ArrayList<Integer> Elist1111 = new ArrayList<Integer>();
		 for(int i=0;i<Elistm.size();i++) {

			int d =  Integer.parseInt(Elistm.get(i));
			 if(d ==3) {
				 Elist1111.add(Elistc.get(i));
			 }
		 }
		 // max jan 2000-2005
		 int quan1111 = Collections.min(Elist1111);
	
		 int ind1111= Elistc.indexOf(quan1111);
		
		 System.out.println("Emily"+" "+Elistc.get(ind1111) + " "+Elistp.get(ind1111) + " "+Elistd.get(ind1111) +"/"+Elistm.get(ind1111)+ "/"+Elisty.get(ind1111));
		 
		 
		 
		 
		 
		 
		 ArrayList<Integer> Blist1111 = new ArrayList<Integer>();
		 for(int i=0;i<Blistm.size();i++) {
         int d =Integer.parseInt(Blistm.get(i));
			 if(d ==3) {
				 Blist1111.add(Blistc.get(i));
			 }
		 }
		 int quan11112 = Collections.min(Blist1111);
	     int ind11112 = Blistc.indexOf(quan11112);
		 System.out.println("Bloom "+ Blistc.get(ind11112) + " "+Blistp.get(ind11112) + " "+Blistd.get(ind11112) +"/"+Blistm.get(ind11112)+ "/"+Blisty.get(ind11112));
		 
		 ArrayList<Integer> Hlist1111 = new ArrayList<Integer>();
		 for(int i=0;i<Hlistm.size();i++) {
             int d =  Integer.parseInt(Hlistm.get(i));
			 if(d ==3) {
				 Hlist1111.add(Hlistc.get(i));
			 }
		 }
		int quan222 = Collections.min(Hlist1111);
		int ind222 = Hlistc.indexOf(quan222);
		
		 System.out.println("Helen "+Hlistc.get(ind222) + " "+Hlistp.get(ind222) + " "+Hlistd.get(ind222) +"/"+Hlistm.get(ind222)+ "/"+Hlisty.get(ind222));
		 
		 ArrayList<Integer> Klist1111 = new ArrayList<Integer>();
		 for(int i=0;i<Klistm.size();i++) {

			int d =  Integer.parseInt(Klistm.get(i));
		         if(d ==3 ) {
				 Klist1111.add(Klistc.get(i));
			 }
		 }
		 //min feb 
		 int quan333 = Collections.min(Klist1111);
		 int ind333 = Klistc.indexOf(quan333);
		 System.out.println("Knuth "+Klistc.get(ind333) +" "+ Klistp.get(ind333) + " "+Klistd.get(ind333) +"/"+Klistm.get(ind333)+ "/"+Klisty.get(ind333));
		 
		 ArrayList<Integer> Slist1111 = new ArrayList<Integer>();
		 for(int i=0;i<Slistm.size();i++) {
           int d =  Integer.parseInt(Slistm.get(i));
			 if(d ==3 ) {
				 Slist1111.add(Slistc.get(i));
			 }
		 }
		 // MIN FEB 
		 int quan444 = Collections.min(Slist1111);
		
		 int ind444 = Slistc.indexOf(quan444);
		
		 System.out.println("Sam"+ "  "+Slistc.get(ind444) +" "+ Slistp.get(ind444)+ " " + Slistd.get(ind444)+ "/" +Slistm.get(ind444)+ "/"+Slisty.get(ind444));
		 
			}
}
			