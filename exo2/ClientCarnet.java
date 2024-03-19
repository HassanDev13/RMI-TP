package exo2;
import java.rmi.Naming;

public class ClientCarnet {

    public static void main(String[] args) {
        try {

            Carnet carnet1 = (Carnet) Naming.lookup("rmi://localhost:1099/Carnet1");
            Carnet carnet2 = (Carnet) Naming.lookup("rmi://localhost:1099/Carnet2");

        
            Adresse adresse = new Adresse("Birouana Number 10", "Tlemcen");
            Adresse adresse2 = new Adresse("Amir Abdkadar Number 12", "Sabra");
            Adresse adresse3 = new Adresse("Imama Number 55 A", "Tlemcen");

            carnet1.enregistrer("Zerrouk Hacene", adresse);
            carnet2.enregistrer("Ferradj Omar", adresse2);
            carnet2.enregistrer("Ferradj Omar 2", adresse3);
            
            // list them all 
            System.out.println("Client 1 : " + carnet1.lister().size());
            System.out.println("Client 2 : " + carnet2.lister().size());

            System.out.println("Search : " + carnet1.chercher("Zerrouk Hacene").getRue());
            System.out.println("Search : " + carnet2.chercher("Ferradj Omar").getRue());
            
            // Use the carnet objects
        } catch (Exception e) {
            System.out.println("Client failed: " + e);
        }
    }
}