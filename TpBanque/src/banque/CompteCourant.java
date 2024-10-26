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
            transactions.add(new Transaction("Débit", montant)); // Ajoute la transaction à l'historique
            System.out.println("Retrait de " + montant + " bien effectué. Votre solde est de : " + getSolde());
        } else {
            System.out.println("Retrait refusé : dépassement du découvert autorisé.");
        }
    }
}
