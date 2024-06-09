package bankProject;

public class AccountBean 
{
	private String name,password,address;
	private double amount;
	private long phone;
	private long account;
	private long Taccount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public long getTaccount() {
		return Taccount;
	}
	public void setTaccount(long taccount) {
		Taccount = taccount;
	}
	@Override
	public String toString() {
		return "AccountBean [name=" + name + ", password=" + password + ", address=" + address + ", amount=" + amount
				+ ", phone=" + phone + ", account=" + account + ", Taccount=" + Taccount + "]";
	}
}
	