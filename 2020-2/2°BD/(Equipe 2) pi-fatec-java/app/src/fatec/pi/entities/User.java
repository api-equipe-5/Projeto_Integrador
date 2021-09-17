package fatec.pi.entities;

public class User {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private Boolean admin;
	
	public User(String name, String email, String password, Boolean admin) {
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
		this.setAdmin(admin);
		
	}
	
	public User(Integer id, String name, String email, String password, Boolean admin) {
		this.setId(id);
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
		this.setAdmin(admin);
		
	}
	
	public User() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	
}
