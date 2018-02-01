package DAO;

import java.util.List;

import metier.I_Produit;
import metier.Produit;

public class AdaptateurProduitXML implements ProduitDAO {

	private ProduitDAOXML produitXML;

	public AdaptateurProduitXML() {
		produitXML = new ProduitDAOXML();
	}

	@Override
	public boolean create(I_Produit p) {
		return produitXML.creer(p);
	}

	@Override
	public List<I_Produit> read() {
		return produitXML.lireTous();
	}

	@Override
	public boolean update(int qte, String nom) {
		return produitXML.maj(new Produit(nom, 0 ,qte));
	}

	@Override
	public boolean delete(String nom) {
		return produitXML.supprimer(new Produit(nom, 0, 0));
	}

}
