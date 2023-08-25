import java.rmi.* ;

public class Client
{
  public static void main(String[] args)
  {
    if (args.length != 2)
    {
      System.out.println("Usage : java Client <machine RMIregistry> <port rmiregistr") ;
      System.exit(0) ;
    }
    System.out.println("Client args(" + args.length + "): " + args[0] + " " + args[1]) ;
    if (System.getSecurityManager() == null)
    {
      System.setSecurityManager(new RMISecurityManager()) ;
    }
    try
    {
      Annuaire annuaire = (Annuaire) Naming.lookup("rmi://" + args[0] + ":" + args[1] + "/LAnnuaire") ;
      System.out.println("Liste annuaire\n" + annuaire.listerNoms()) ;
    }
    catch (Exception e)
    {
      System.out.println("Client : " + e.getMessage()) ;
      e.printStackTrace() ;
    }
  }
}
