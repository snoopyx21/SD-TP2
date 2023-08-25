import java.rmi.* ; 
import java.net.MalformedURLException ; 
import java.util.*; 

public class Client
{
  static public void afficheMatrice (int [][] mat)
	{
		for (int i = 0; i < mat.length; ++i)
		{ 
	    for (int j=0; j < mat[0].length; ++j)
			{ 
				System.out.print(mat[i][j]+" ") ;
	    }
	    System.out.println() ;
		}
  }

  public static void main(String [] args)
	{
		if (args.length != 1) 
	    System.out.println("Usage : java Client <machine du Serveur>") ;
		else
		{
	    try
			{
				OpMatrice mat = (OpMatrice) Naming.lookup("rmi://" + args[0] + "/OpMatrice") ;
	
				int[][] a = { {1, 0, 0}, {0, 2, 0}, {0, 0, 3}, {0, 0, 4}} ;
				int[][] b = { {1, 2, 3}, {1, 2, 3}, {1, 2, 3} } ;

				System.out.println("Le client recoit : ");
				int [][] res = mat.multiplicationMatrice(a,b);
				afficheMatrice(res);

				/*		int o[] = {1,3,2};
				System.out.println("egalite " + 
				Arrays.equals(res[0],o));
				Arrays.sort(o);
				System.out.println("egalite " + 
				Arrays.equals(res[0],o)); */
	    }
	    catch (NotBoundException re) { System.out.println(re) ; }
	    catch (RemoteException re) { System.out.println(re) ; }
	    catch (MalformedURLException e) { System.out.println(e) ; }
		}
  }
}
