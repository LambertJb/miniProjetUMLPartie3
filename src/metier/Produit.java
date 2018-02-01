package metier;

import DAO.FactoryDAO;
import DAO.ProduitDAO;

public class Produit implements I_Produit {
	
	private int quantiteStock;

	private String nom;

	private double prixUnitaireHT;

	private double tauxTVA = 0.2;
	
	private ProduitDAO produitBDD;

	public Produit( String nom, double prixUnitaireHT, int qte) {
		produitBDD = FactoryDAO.createInstance();
		this.nom = nom.trim().replace("\t", " ");
		this.prixUnitaireHT = prixUnitaireHT;
		this.quantiteStock = qte;
	}

	@Override
	public boolean ajouterBDD() {
		return produitBDD.create(this);
	}
	
	@Override
	public boolean ajouter(int qteAchetee) {
		this.quantiteStock += qteAchetee;
		return produitBDD.update(this.getQuantite(), this.getNom());
	}

	@Override
	public boolean enlever(int qteVendue) {
		this.quantiteStock = this.quantiteStock - qteVendue;
		if(this.quantiteStock==0) {
			this.produitBDD.delete(this.nom);
		}
		else {
			this.produitBDD.update(this.getQuantite(), this.getNom());
		}
		return true;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public int getQuantite() {
		return this.quantiteStock;
	}

	@Override
	public double getPrixUnitaireHT() {
		return this.prixUnitaireHT;
	}

	@Override
	public double getPrixUnitaireTTC() {
		double d = (this.prixUnitaireHT * (1 + this.tauxTVA));
		return d;
	}

	@Override
	public double getPrixStockTTC() {
		double prixUnitaireTTC = this.getPrixUnitaireTTC();
		return this.quantiteStock * prixUnitaireTTC;
	}

}
