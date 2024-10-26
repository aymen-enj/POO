package banque;
import java.util.ArrayList;
public class Banque {
	
	private ArrayList<CompteBancaire> comptes = new ArrayList<>();
	private static int nombreComptes;
	
	public void ajouterCompte(CompteBancaire compte){
		comptes.add(compte);
		nombreComptes++;
	}
	
	public CompteBancaire chercherCompte(String numeroCompte) {
		for (CompteBancaire compte : comptes){
			if (compte.getNumeroCompte().equals(numeroCompte)){
				return compte;
			}
		}
		System.out.println("Compte introuvable");
		return null;
	}
	
	public void transfert(String numeroSource, String numeroDest, double montant){
		CompteBancaire source = chercherCompte(numeroSource);
        CompteBancaire dest = chercherCompte(numeroDest);

        if (source != null && dest != null && source.getSolde() >= montant) {
            source.retirer(montant);
            dest.deposer(montant);
            System.out.println("Transfert de " + montant + " effectué.");
        }
        else {
            System.out.println("Échec du transfert.");
        }
	}
	
	public static void afficherNombreComptes(){
		System.out.println("Le nombre des comptes est: " + nombreComptes);
	}
}
