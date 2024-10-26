package banque;
import java.util.ArrayList;
import java.util.Date;

public class CompteBancaire {
	private String numeroCompte;
	private double solde;
	private String titulaire;
	//Pour stocker les transactions dans un tableau:
	protected ArrayList<Transaction> transactions = new ArrayList<>();
	
	public CompteBancaire(String numeroCompte,String titulaire){
		this.numeroCompte=numeroCompte;
		this.titulaire=titulaire;
		this.solde=0.0;
	}
	
	public void deposer(double montant){
		if (montant>0){
			solde+=montant;
			transactions.add(new Transaction("Crédit", montant));
			System.out.println(montant + " deposee avec succes pour " + titulaire);
		}
	}
	public void retirer(double montant){
		if (montant > 0 && montant <= solde){
			solde-=montant;
			transactions.add(new Transaction("Débit", montant)); 
			System.out.println(montant + " retiree avec succes pour "+ titulaire);
		}
		else{
			System.out.println("Solde insuffisnat");
		}
	}
	
	//Afficher l'historique des transaction:
		public void afficherHistorique() {
			if (transactions.isEmpty()) {
		        System.out.println("Aucune transaction à afficher.");
		    } else {
		        for (Transaction transaction : transactions) {
		            System.out.println(transaction);
		        }
		    }
	    }
	
	public void afficherSolde(){
		System.out.println("Le solde actuel du compte: " + numeroCompte+ " est: " + solde);
	}
	
	public String getNumeroCompte(){
		return numeroCompte;
	}
	public double getSolde(){
		return solde;
	}
	public void setTitulaire(String titulaire){
		this.titulaire=titulaire;
	}
	
	
	//Utiliser pour assurer la modification du solde
	protected void ajusterSolde(double montant) {
        this.solde += montant;
    }
}