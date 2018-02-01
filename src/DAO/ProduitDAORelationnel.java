package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import metier.I_Produit;
import metier.Produit;

public class ProduitDAORelationnel implements ProduitDAO {
	private PreparedStatement pst;
	private Connection cn;
	private ResultSet res;
	private static ProduitDAORelationnel instance;
	
	private ProduitDAORelationnel() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@162.38.222.149:1521:iut", "lambertj", "Jibet199");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean create(I_Produit p) {
		if (p != null) {
			try {
				CallableStatement call = cn.prepareCall("{call procedure_insert_produits( ?, ?, ? )}");
				call.setString(1, p.getNom());
				call.setInt(2, p.getQuantite());
				call.setDouble(3, p.getPrixUnitaireHT());
				return call.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<I_Produit> read() {
		List<I_Produit> listeResultat = new ArrayList<I_Produit>();
		
		try {
			String sql = "SELECT nom, quantiteStock,prixUnitaireHT FROM Produits";
			pst = cn.prepareStatement(sql);
			res = pst.executeQuery();
			while (res.next()) {
				String nom = res.getString(1);
				double prixHTUnitaire = res.getDouble(3);
				int quantite = res.getInt(2);
				I_Produit produit = new Produit(nom,prixHTUnitaire,quantite);
				listeResultat.add(produit);
			}
			return listeResultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean update(int qte, String nom) {
		if (qte != 0 && nom != null) {
			String sql = "Update Produits SET quantiteStock = :qteStock WHERE nom = :nom";
			try {
				pst = cn.prepareStatement(sql);
				pst.setInt(1, qte);
				pst.setString(2, nom);
				return pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean delete(String nom) {
		if (nom != null) {
			String sql = "Delete From Produits WHERE nom = :nom";
			try {
				pst = cn.prepareStatement(sql);
				pst.setString(1, nom);
				return pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}
	
	public static ProduitDAORelationnel getInstance() {
		if (instance == null) 
			instance = new ProduitDAORelationnel();
		return instance;
	}
}
