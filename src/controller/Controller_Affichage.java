package controller;

import metier.I_Catalogue;

public class Controller_Affichage {

	private I_Catalogue catalogue;

	public Controller_Affichage() {
		this.catalogue = this.catalogue = ControllerInstance.createInstance();
	}

	public String affichageCatalogue() {
		return catalogue.toString();
	}
}
