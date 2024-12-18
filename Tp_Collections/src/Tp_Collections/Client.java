package Tp_Collections;

import java.util.ArrayList;

public class Client {
	private String CodeClient;
    private String NomClient;
    private String AdrClient;
    private String TelClient;
    private ArrayList<Commande> ListeCommandes;
    
    public Client(String CodeClient, String NomClient, String AdrClient, String TelClient) {
        this.CodeClient = CodeClient;
        this.NomClient = NomClient;
        this.AdrClient = AdrClient;
        this.TelClient = TelClient;
        this.ListeCommandes = new ArrayList<Commande>();
    }
    
    public boolean EnregistrerCommande(Commande cmd) {
        return ListeCommandes.add(cmd);
    }

    public boolean supprimerCommande(int NumCommande) {
        for (Commande cmd : ListeCommandes){
        	if (cmd.getNumCommand()==NumCommande){
        		ListeCommandes.remove(cmd);
        		return true;
        	}
        }
        return false;
    }
    public ArrayList<Commande> getListeCommandes() {
        return ListeCommandes;
    }
    @Override
    public String toString(){
    	return "Client ( CodeClient = " + CodeClient + " , NomClient = " + NomClient+ " , AdrClient= " + AdrClient + " , TelClient = " + TelClient + " , ListeCommandes = " + ListeCommandes +")";
    }
}
