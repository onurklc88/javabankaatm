
import java.net.MalformedURLException;
import java.rmi.*;

import javax.swing.*;

public class AdditionClient {

	
	public static void hesapEkle() throws MalformedURLException, RemoteException, NotBoundException{
		System.setSecurityManager(new RMISecurityManager());
		AdditionInterface onurk�l�c=(AdditionInterface)Naming.lookup("//localhost/Pro");
		String result = onurk�l�c.hesapEkle(1, "Hesap 1");
		result = onurk�l�c.hesapEkle(2, "Hesap 2");
		result = onurk�l�c.hesapEkle(3, "Hesap 3");
		result = onurk�l�c.hesapEkle(4, "Hesap 4");
		System.out.println(result);
	}
	
	public static void bakiyeYatir() throws MalformedURLException, RemoteException, NotBoundException{
		System.setSecurityManager(new RMISecurityManager());
		AdditionInterface onurk�l�c=(AdditionInterface)Naming.lookup("//localhost/Pro");
		String resultDeposit = onurk�l�c.bakiyeYat�r�m(1, 150);
		resultDeposit = onurk�l�c.bakiyeYat�r�m(3, 100);
		System.out.println(resultDeposit); 
		onurk�l�c.hesapListe();
	}
	
	public static void bakiyeCek() throws MalformedURLException, RemoteException, NotBoundException{
		System.setSecurityManager(new RMISecurityManager());
		AdditionInterface onurk�l�c=(AdditionInterface)Naming.lookup("//localhost/Pro");
		String resultPull = onurk�l�c.bakiyeCek(3,50);
		System.out.println(resultPull);
		onurk�l�c.hesapListe();
	}
	
	public static void musteriEkle() throws MalformedURLException, RemoteException, NotBoundException{
		System.setSecurityManager(new RMISecurityManager());
		AdditionInterface onurk�l�c=(AdditionInterface)Naming.lookup("//localhost/Pro");
		String resultCust = onurk�l�c.musteriEkle(1, "Samet �ahin", 1);
		resultCust = onurk�l�c.musteriEkle(2, "Emre Ya��z Mala", 2);
		resultCust = onurk�l�c.musteriEkle(3, "Berk Alt�n", 3);
		resultCust = onurk�l�c.musteriEkle(4, "Ender Alkan", 5); //Bu kullan�c�y� kay�t etmeyecek ��nk� hesap numaras� kay�tl� de�il.
		System.out.println(resultCust);
		onurk�l�c.musteriListe();
	}
	
	public static void hesapListele() throws MalformedURLException, RemoteException, NotBoundException{
		System.setSecurityManager(new RMISecurityManager());
		AdditionInterface onurk�l�c=(AdditionInterface)Naming.lookup("//localhost/Pro");
		onurk�l�c.musteriListe();
	}
	
	public static void musteriListele() throws MalformedURLException, RemoteException, NotBoundException{
		System.setSecurityManager(new RMISecurityManager());
		AdditionInterface onurk�l�c=(AdditionInterface)Naming.lookup("//localhost/Pro");
		onurk�l�c.musteriListe();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdditionInterface onurk�l�c;
				
		try{
			System.setSecurityManager(new RMISecurityManager());
			onurk�l�c=(AdditionInterface)Naming.lookup("//localhost/Pro");
			
			//Yeni Hesap a�ma Fonksiyonu
		   //hesapEkle();
			
			//Para yat�rma Fonksiyonu
			//bakiyeYatir();
			
			//Para �ekme Fonksiyonu
			bakiyeCek();
			
			//M��teri Ekleme Fonksiyonu
			//musteriEkle();
			
			//Hesap Listeleme Fonksiyonu
			//hesapListele();
			
			//M��teri Listeleme Fonksiyonu
			 //musteriListele();
			 
		}
		
		catch (Exception e){
			System.out.println("Client Hatas�: "+ e);
		}
	}

}
