import java.net.* ;
import java.rmi.* ;

public class Serveur
{
  public static void main(String [] args)
	{
  	try
		{
			OpMatriceImpl objLocal = new OpMatriceImpl () ;
			Naming.rebind("OpMatrice",objLocal) ;
			System.out.println("Serveur Matrice pret") ;
		}
    catch (RemoteException re) { System.out.println(re) ; }
    catch (MalformedURLException e) { System.out.println(e) ; }
  }
}
