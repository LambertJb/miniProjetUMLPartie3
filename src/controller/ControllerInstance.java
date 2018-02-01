package controller;

import metier.Catalogue;
import metier.I_Catalogue;

public class ControllerInstance {

	private static I_Catalogue catalogue;
	
	public static I_Catalogue createInstance () {
		if (catalogue == null)
			catalogue = new Catalogue();
		return catalogue;
	}
}
