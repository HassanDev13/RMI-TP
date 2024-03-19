package exo2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServeurCarnet {
    public static void main(String[] args) {
        try {
            CarnetImpl carnet1 = new CarnetImpl();
            CarnetImpl carnet2 = new CarnetImpl();
            Adresse adresse = new Adresse("Birouana Number 10", "Tlemcen");
            Adresse adresse2 = new Adresse("Amir Abdkadar Number 12", "Sabra");

            carnet1.enregistrer("Zerrouk Hacene", adresse);
            carnet2.enregistrer("Ferradj Omar", adresse2);

            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/Carnet1", carnet1);
            Naming.rebind("rmi://localhost:1099/Carnet2", carnet2);

            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("Server failed: " + e);
        }
    }
}