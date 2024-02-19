package classs;

public class property {

	private int landlord_id;
	private String names;
	private String identity_number;
	private String contact;
	private String bank_account;
	public int getLandlord_id() {
		return landlord_id;
	}
	public void setLandlord_id(int landlord_id) {
		this.landlord_id = landlord_id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getIdentity_number() {
		return identity_number;
	}
	public void setIdentity_number(String identity_number) {
		this.identity_number = identity_number;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getBank_account() {
		return bank_account;
	}
	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}
	public property(int landlord_id, String names, String identity_number, String contact, String bank_account) {
		super();
		this.landlord_id = landlord_id;
		this.names = names;
		this.identity_number = identity_number;
		this.contact = contact;
		this.bank_account = bank_account;
	}
	}


