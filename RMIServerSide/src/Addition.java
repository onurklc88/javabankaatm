import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

import javax.swing.text.html.parser.Parser;

public class Addition extends UnicastRemoteObject implements AdditionInterface{
	public Addition() throws RemoteException{}
			
	public class HesapList{
		int no;  
	    String adi; 
	    int bakiye;
	    HesapList(int no,String adi, int bakiye){  
	        this.no = no;  
	        this.adi = adi;
	        this.bakiye = bakiye;
	    } 
	}
	
	public class CUSTOMER{
		int id;  
	    String musteriAd; 
	    int musteriHesapNo;
	    CUSTOMER(int id,String musteriAd, int musteriHesapNo){  
	        this.id = id;  
	        this.musteriAd = musteriAd;
	        this.musteriHesapNo = musteriHesapNo;
	    } 
	}
	    
	ArrayList<HesapList> hesapInsert = new ArrayList<HesapList>();
	ArrayList<HesapList> hesapList = new ArrayList<HesapList>();
	ArrayList<CUSTOMER> customerInsert = new ArrayList<CUSTOMER>();
	
	public String hesapEkle(int NO, String NM) throws RemoteException{
		try {
			
			HesapList set = new HesapList(NO, NM, 0);
			//hesapInsert.add(new HesapList(NO, NM, 0));
			//burada hesap listesini kay�t yapt�m
			hesapInsert.add(set);
			hesapList.add(set);
			
			System.out.println("Hesap No : " + NO + " Hesap Tan�m : " + NM + " Bakiye : " + 0);
			
			/*Iterator itr = hesapInsert.iterator();  
 
	        while(itr.hasNext()){  
	        	HesapList st=(HesapList)itr.next();
	            System.out.println("Hesap No : " + st.ACCUUNTNO + " Hesap Tan�m : " + st.ACCUUNTNM + " Bakiye : " + st.ACCUUNTQUANTITY);  
	        }*/
			return "Hesab�n�z Kay�t Edilmi�tir.";
			
		} catch (Exception e) {
			return "Hata Olu�tu.";
		}
	}
	
	public String bakiyeYat�r�m(int NO, int TL) throws RemoteException{
		//ArrayList<HesapList> hesapList = new ArrayList<HesapList>();
		try {
			//arraylistteki hesaptaki para bilgilerini al�p �zerine yeni para tutar�n� ekleyerek tekrar arrayliste g�nderir
			  
			Iterator itr = hesapList.iterator();
			int index = 0;
			System.out.println("Para Yat�rma");
			 while(itr.hasNext()){  
		        	HesapList st = (HesapList)itr.next();  
		        	int num = st.no;
		            if (num == NO) {
		            	//hesapList.remove(pos);
		            	hesapList.set(index, new HesapList(NO, st.adi, TL + st.bakiye));
		            	//hesapInsert.add(new HesapList(NO, st.ACCUUNTNM, TL));
		            	//System.out.println("Hesap No : " + st.ACCUUNTNO + " Hesap Tan�m : " + st.ACCUUNTNM + " Bakiye : " + TL);
		            	//return "Para Transferi Ger�ekle�mi�tir.";
					}
		            else {
						index++;
					}
		        }
			 
			 return "Para Yat�rma ��lemi Ger�ekle�mi�tir.";
			
		} catch (Exception e) {
			return "Hesap Bulunamad�.";
		}
		
		//return "Hesap Bulunamad�.";
	}
	
	public String bakiyeCek(int NO, int TL) throws RemoteException{
		//ArrayList<HesapList> hesapList = new ArrayList<HesapList>();
		try {
			//Arraylist i�indeki verileri Iterator sayesinde okuyorum
			Iterator itr = hesapList.iterator();
			int index = 0;
			System.out.println("Para �ekme");
			//While ile ile Iterator kadar d�nd�r�p gelen hesap numaras�na g�re veriyi g�ncelliyorum
			 while(itr.hasNext()){  
		        	HesapList st = (HesapList)itr.next();  
		        	int num = st.no;
		        	int ACCUUNTMONEY = st.bakiye;
		            if (num == NO) {
		            	if (ACCUUNTMONEY >= TL) {
		            		//Veri g�ncelleme ve para �ekme gelen de�er ile hesaptaki bakiyeyi ��kar�yorum.
		            		hesapList.set(index, new HesapList(NO, st.adi, ACCUUNTMONEY - TL));
						}
		            	else {
		            		return "Hesab�n�zda Yeterli Bakiye Bulunmamamktad�r.";
						}
					}
		            else {
						index++;
					}
		        }
			 
			 return "Para �ekme ��lemi Ger�ekle�mi�tir.";
			
		} catch (Exception e) {
			return "Hesap Bulunamad�.";
		}
	}
	
	public String hesapListe() throws RemoteException{
		try {
			//hesaplist arrayindeki bilgileri erkana bast�r�r
			System.out.println("");
			Iterator itr = hesapList.iterator();  
			 
			//while d�ng�s�nde hesaplistteki bilgileri sat�r sat�r d�zenleri olarak getirir
	        while(itr.hasNext()){  
	        	HesapList st = (HesapList)itr.next();
	        	System.out.println("Hesap No : " + st.no + " Hesap Tan�m : " 
	        	+ st.adi + " Bakiye : " + st.bakiye);  
	        }
			
			return "Hesap Listesi";
			
		} catch (Exception e) {
			return "Hata Olu�tu.";
		}
	}
	
	public String musteriEkle(int NO, String NM, int ACCUUNTNO) throws RemoteException{
		try {
			//
			Iterator itr = hesapList.iterator();
			int index = 0;
			//customerInsert.add(set); bu komut hesapliste m��teri ekliyor
			 while(itr.hasNext()){  
		        	HesapList st = (HesapList)itr.next();  
		        	int num = st.no;
		            if (num == ACCUUNTNO) {
		            	CUSTOMER set = new CUSTOMER(NO, NM, ACCUUNTNO);
		    			//hesapInsert.add(new HesapList(NO, NM, 0));
		    			customerInsert.add(set);
					}
		            else {
						index++;
					}
		        }
			 
			System.out.println("M��teri No : " + NO + ", M��teri Ad� : " + NM + ", M��terinin Hesab� : " + ACCUUNTNO);
			
			return "M��teri Kay�t Edilmi�tir.";
			
		} catch (Exception e) {
			return "Hata Olu�tu, veya Sistemde Hesap Numasras� Bulunamad�";
		}
	}
	
	public String musteriListe() throws RemoteException{
		try {
			//burada m��terileri listeliyor
			Iterator itr = customerInsert.iterator();  
			 
	        while(itr.hasNext()){  
	        	CUSTOMER st = (CUSTOMER)itr.next();
	            System.out.println("M��teri No : " + st.id + ", M��teri Ad� : " +
	        	st.musteriAd + ", M��terinin Hesab� : " + st.musteriHesapNo);  
	        }
			
			return "M��teri Listesi";
			
		} catch (Exception e) {
			return "Hata Olu�tu.";
		}
	}

}
