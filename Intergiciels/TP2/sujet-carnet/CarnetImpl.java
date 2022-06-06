import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
public class CarnetImpl extends UnicastRemoteObject implements Carnet  {
    private HashMap<String,RFiche> ListNomsRFiche;
    private Carnet AutreCarnet;

    public CarnetImpl(Carnet AutreCarnet) throws RemoteException{
        ListNomsRFiche = new HashMap<String,RFiche>();
        this.AutreCarnet = AutreCarnet;
    }

    public void Ajouter (SFiche sf) throws RemoteException{
        ListNomsRFiche.put(sf.getNom(),new RFicheImpl(sf.getNom(),sf.getEmail()));

    }

    public RFiche Consulter(String n, boolean forward) throws RemoteException{
        RFiche rf = ListNomsRFiche.get(n);
        if (rf == null && forward){
            rf = AutreCarnet.Consulter(n,false);
        }
        return rf;
    }

    private void SetAutreCarnet(Carnet AutreCarnet){
        this.AutreCarnet = AutreCarnet;
    }
    public static void main (String [] args){
        try {
            Registry registry = LocateRegistry.createRegistry(4000);
            CarnetImpl carnet1 = new CarnetImpl(null);
            CarnetImpl carnet2 = new CarnetImpl(carnet1);
            carnet1.SetAutreCarnet(carnet2);
            Naming.rebind("//localhost:4000/Carnet1", carnet1);
            Naming.rebind("//localhost:4000/Carnet2", carnet2);
         } catch (Exception exc) { 
             exc.printStackTrace();
         }
    }
} 
