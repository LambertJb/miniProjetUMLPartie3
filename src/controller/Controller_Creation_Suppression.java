package controller;

import metier.Catalogue;
import metier.I_Catalogue;
import metier.Produit;

public class Controller_Creation_Suppression {

	private I_Catalogue catalogue;

	public Controller_Creation_Suppression() {
		catalogue = ControllerInstance.createInstance();
	}

	public String[] demandeSuppression() {

		return catalogue.getNomProduits();
	}

	public boolean supprimerProduit(String nomProd) {

		boolean resultat = false;
		try {
			resultat = catalogue.removeProduit(nomProd);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		this.catalogue.mettreAJour();
		return resultat;
	}

	public boolean ajouterProduit(String nomProd, String prixUnitaireHT, String qte) {

		boolean resultat = false;
		try {
			resultat = catalogue.addProduit(nomProd, Double.parseDouble(prixUnitaireHT), Integer.parseInt(qte));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		this.catalogue.mettreAJour();
		return resultat;
	}
}
