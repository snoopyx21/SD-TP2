import java.rmi.server.UnicastRemoteObject ;
import java.rmi.RemoteException ;

public class OpMatriceImpl 
	extends UnicastRemoteObject
	implements OpMatrice
{
	public OpMatriceImpl ()
		throws RemoteException
	{
		super() ;
	} ;

  public int[][] multiplicationMatrice(int [][] a, int [][] b) 
		throws RemoteException
	{ 
		int [][] res = new int [a.length][b[0].length] ;
		for (int i = 0; i < a.length; ++i) 
	    for (int j = 0; j < b[0].length; ++j) 
				for (int k = 0; k < a[0].length; ++k) 
		    	res[i][j] += a[i][k]*b[k][j] ;

		return(res) ;
  }
}
