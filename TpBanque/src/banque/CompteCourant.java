package banque;

public class CompteCourant extends CompteBancaire {
	
	private double decouvertAutorise;
	
	 // Constructeur de CompteCourant
    public CompteCourant(String numeroCompte, String titulaire, double decouvertAutorise) {
        super(numeroCompte, titulaire); // Appelle le constructeur de CompteBancaire
        this.decouvertAutorise = decouvertAutorise;
    }
    
    @Override
    public void retirer(double montant) {
        if (getSolde() + decouvertAutorise >= montant) {
            ajusterSolde(-montant);  // Utilisation de `ajusterSolde` pour soustraire le montant
            transactions.add(new Transaction("D�bit", montant)); // Ajoute la transaction � l'historique
            System.out.println("Retrait de " + montant + " bien effectu�. Votre solde est de : " + getSolde());
        } else {
            System.out.println("Retrait refus� : d�passement du d�couvert autoris�.");
        }
    }
}
