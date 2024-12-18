package Tp_Collections;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Commande cmd1 = new Commande(1, new Date(), "FournisseurA");
			Commande cmd2 = new Commande(2, new Date(), "FournisseurB");
			
			Client client1 = new Client("C001", "Client1", "Adresse1", "0600000000");
            Client client2 = new ClientFidel("C002", "Client2", "Adresse2", "0600000001", "F001", 10.5f);
            
            client1.EnregistrerCommande(cmd1);
            client2.EnregistrerCommande(cmd2);
            
            ArrayList<Client> clients = new ArrayList<Client>();
            clients.add(client1);
            clients.add(client2);

            Collections.sort(client1.getListeCommandes());

            Set<Commande> uniqueCommandes = new HashSet<Commande>(client1.getListeCommandes());

            Map<String, Client> clientMap = new HashMap<String, Client>();
            clientMap.put(client1.toString(), client1);
            clientMap.put(client2.toString(), client2);

            BufferedWriter out = new BufferedWriter(new FileWriter("clients.txt"));
            for (Client client : clients) {
                out.write(client.toString());
                out.newLine();
            }
            out.close();

            BufferedReader in = new BufferedReader(new FileReader("clients.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}

}
