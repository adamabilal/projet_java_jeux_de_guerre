package personnage.util;

/**
 * @author AissatouIbrahima & AdamaTRAORE
 *
 */
public enum Ressource {
	/**
	 * the resources
	 */
	roche(0), sable(0), bois(0), ble(0);

	private int qte_ressource;

	private Ressource(int qte_ressource) {
		this.qte_ressource = qte_ressource;
	}

	/**
	 * @return the qte_ressource
	 */
	public int getQte_ressource() {
		return this.qte_ressource;
	}

	/**
	 * @param qte_ressource the qte_ressource to add
	 */
	public void addQte_ressource(int qte) {
		this.qte_ressource += qte;
	}

	/**
	 * @param qte_ressource the qte_ressource to set
	 */
	public void setQte_ressource(int qte_ressource) {
		this.qte_ressource = qte_ressource;
	}

}
