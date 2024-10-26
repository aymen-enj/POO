package banque;

import java.util.Date;

public class Transaction {
	private String type;
	private double montant;
	private Date date;
	
	public Transaction(String type, double montant) {
        this.type = type;
        this.montant = montant;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Transaction : " + type + ", Montant : " + montant + ", Date : " + date;
    }
}
