package controller;

import metier.I_Catalogue;
import presentation.FenetreAchat;
import presentation.FenetreAffichage;
import presentation.FenetreNouveauProduit;
import presentation.FenetreSuppressionProduit;
import presentation.FenetreVente;

public class ControllerCatalogue {
	
	public ControllerCatalogue() {
	}
	
	public Controller_Achat_Vente creerControllerAchatVente() {
		return new Controller_Achat_Vente();
	}
	
	public Controller_Creation_Suppression creerControllerCreationSuppression() {
		return new Controller_Creation_Suppression();
	}
	
	public Controller_Affichage creerControllerAffichage() {
		return new Controller_Affichage();
	}

	public void fenetreAfficher() {
		Controller_Affichage controller_affichage = new Controller_Affichage();
		new FenetreAffichage(controller_affichage.affichageCatalogue());
		
	}

	public void fenetreSupprimer(String[] tabProduits) {
		Controller_Creation_Suppression controller_creation_suppression = new Controller_Creation_Suppression();
		tabProduits = controller_creation_suppression.demandeSuppression();
		new FenetreSuppressionProduit(tabProduits);
		
	}
	
	public void supprimer(String nomProd) {
		Controller_Creation_Suppression controller_creation_suppression = new Controller_Creation_Suppression();
		controller_creation_suppression.supprimerProduit(nomProd);
	}

	public void acheter(String[] tabProduits) {
		Controller_Achat_Vente controller_achat_vente = new Controller_Achat_Vente();
		tabProduits = controller_achat_vente.demandeAchats();
		new FenetreAchat(tabProduits);
		
	}

	public void vendre(String[] tabProduits) {
		Controller_Achat_Vente controller_achat_vente = new Controller_Achat_Vente();
		tabProduits = controller_achat_vente.demandeAchats();
		new FenetreVente(tabProduits);
		
	}

	public void ajouter(String nom, String prixHT, String quantite) {
		Controller_Creation_Suppression controller_creation_suppression = new Controller_Creation_Suppression();
		controller_creation_suppression.ajouterProduit(nom, prixHT, quantite);
		
	}

	public void fenetreNouveau() {
		new FenetreNouveauProduit();
	}
	
}
