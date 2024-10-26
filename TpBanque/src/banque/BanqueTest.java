package banque;

public class BanqueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Banque banque1 = new Banque();
		 
		 CompteBancaire compte1 = new CompteBancaire("1","Aymen");
		 CompteBancaire compte2 = new CompteBancaire("2","Amine");
		 CompteBancaire compte3 = new CompteBancaire("3","Youssef");
		 CompteCourant CompteCourant1= new CompteCourant("4","Saad",200);
		 CompteEpargne CompteEpargne1=new CompteEpargne("5","Reda",1);
		 
		 banque1.ajouterCompte(compte1);
		 banque1.ajouterCompte(compte2);
		 banque1.ajouterCompte(compte3);
		 banque1.ajouterCompte(CompteCourant1);
		 banque1.ajouterCompte(CompteEpargne1);
		 
		 compte1.deposer(700);
		 compte2.deposer(400);
		 compte3.deposer(500);
		 compte1.retirer(100);
		 
		 CompteCourant1.deposer(300);
		 CompteEpargne1.deposer(200);
		 CompteCourant1.retirer(200);
		 CompteEpargne1.retirer(100);
		 
		 banque1.transfert("1","2", 200);
		 
		 CompteEpargne1.calculerInteret();
		 
		 compte1.afficherSolde();
		 compte2.afficherSolde();
		 compte3.afficherSolde();
		 CompteCourant1.afficherSolde();
		 CompteEpargne1.afficherSolde();
		 
		 CompteCourant1.afficherHistorique();
		 compte1.afficherHistorique();
		 CompteEpargne1.afficherHistorique();
		 
		 Banque.afficherNombreComptes();	 
	}
}
