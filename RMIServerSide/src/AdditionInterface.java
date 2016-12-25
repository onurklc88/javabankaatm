import java.rmi.*;

public interface AdditionInterface extends Remote{
	public String hesapEkle(int NO, String NM) throws RemoteException;
	public String bakiyeYat�r�m(int NO, int TL) throws RemoteException;
	public String bakiyeCek(int NO, int TL) throws RemoteException;
	public String musteriEkle(int NO, String NM, int ACCUUNTNO) throws RemoteException;
	public String musteriListe() throws RemoteException;
	public String hesapListe() throws RemoteException;
}
