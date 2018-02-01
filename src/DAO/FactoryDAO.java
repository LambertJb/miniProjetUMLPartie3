package DAO;

public class FactoryDAO {
	
	private static ProduitDAO instanceRelationnel;
	private static ProduitDAO instanceXML;
	
	public static ProduitDAO createInstance() {
		instanceRelationnel = ProduitDAORelationnel.getInstance();
		instanceXML = new AdaptateurProduitXML();
		return instanceXML;
	}
}
