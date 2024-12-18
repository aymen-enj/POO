package Tp_Collections;

import java.util.Date;

public class Commande implements Comparable<Commande>{
	private int NumCommand;
	private Date DateCommande;
	private String NomFournisseur;
	
	public Commande(int NumCommand , Date DateCommande, String NomFournisseur){
		this.NumCommand=NumCommand;
		this.DateCommande=DateCommande;
		this.NomFournisseur=NomFournisseur;
	}
	
	public int getNumCommand(){
		return NumCommand;
	}
	public void setNumCommand(int NumCommande){
		this.NumCommand=NumCommand;
	}
	
	public Date getDateCommande(){
		return DateCommande;
	}
	public void setDateCommande(Date DateCommande){
		this.DateCommande=DateCommande;
	}
	
	public String getNomFournisseur(){
		return NomFournisseur;
	}
	public void setNomFournisseur(String NomFournisseur){
		this.NomFournisseur=NomFournisseur;
	}
	
	@Override
	public String toString(){
		return "Commande( NumCommand = "+NumCommand+", DateCommande = "+ DateCommande + " , NomFournisseur = "+ NomFournisseur + ")";
	}
	
	@Override
	public boolean equals(Object obj){
		if (this==obj) return true;
		if (obj == null || getClass()!=obj.getClass()) return false;
		Commande commande = (Commande)obj;
		return NumCommand == commande.NumCommand;
	}

	public int compareTo(Commande cmd) {
		// TODO Auto-generated method stub
		return this.DateCommande.compareTo(cmd.DateCommande);
	}
}
