package webBilling;

public class Billing {

	private String client_LName;
	private String client_FName;
	private String product_Name;
	private double prd_Price;
	private int prd_Qty;

	public static double Fed_Tax = 0.075;
	public static double Prv_Tax = 0.06;

	public Billing() {
		this.client_LName = "";
		this.client_FName = "";
		this.product_Name = "";
		this.prd_Price = 0.0;
		this.prd_Qty = 0;
	}

	public Billing(String client_LName, String client_FName, String product_Name, double prd_Price, int prd_Qty) {

		this.client_LName = client_LName;
		this.client_FName = client_FName;
		this.product_Name = product_Name;
		this.prd_Price = prd_Price;
		this.prd_Qty = prd_Qty;
	}

	public String getClient_LName() {
		return client_LName;
	}

	public void setClient_LName(String client_LName) {
		this.client_LName = client_LName;
	}

	public String getClient_FName() {
		return client_FName;
	}

	public void setClient_FName(String client_FName) {
		this.client_FName = client_FName;
	}

	public String getproduct_Name() {
		return product_Name;
	}

	public void setproduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public double getPrd_Price() {
		return prd_Price;
	}

	public void setPrd_Price(double prd_Price) {
		this.prd_Price = prd_Price;
	}

	public int getPrd_Qty() {
		return prd_Qty;
	}

	public void setPrd_Qty(int prd_Qty) {
		this.prd_Qty = prd_Qty;
	}

	public double CalculateBilling() {
		double T_Billing = (prd_Price * prd_Qty) + (prd_Price * prd_Qty) * Fed_Tax + (prd_Price * prd_Qty) * Prv_Tax;

		return T_Billing;
	}
}