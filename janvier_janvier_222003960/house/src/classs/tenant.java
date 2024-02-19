package classs;

public class tenant {

	private int tenant_id;
	private String names;
	private String contact;
	private String lease_start_date;
	private String lease_end_date;
	private String monthly_rent_payment;
	public tenant(int tenant_id, String names, String contact, String lease_start_date, String lease_end_date,
			String monthly_rent_payment) {
		super();
		this.tenant_id = tenant_id;
		this.names = names;
		this.contact = contact;
		this.lease_start_date = lease_start_date;
		this.lease_end_date = lease_end_date;
		this.monthly_rent_payment = monthly_rent_payment;
	}
	public int getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(int tenant_id) {
		this.tenant_id = tenant_id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getLease_start_date() {
		return lease_start_date;
	}
	public void setLease_start_date(String lease_start_date) {
		this.lease_start_date = lease_start_date;
	}
	public String getLease_end_date() {
		return lease_end_date;
	}
	public void setLease_end_date(String lease_end_date) {
		this.lease_end_date = lease_end_date;
	}
	public String getMonthly_rent_payment() {
		return monthly_rent_payment;
	}
	public void setMonthly_rent_payment(String monthly_rent_payment) {
		this.monthly_rent_payment = monthly_rent_payment;
	}

}
