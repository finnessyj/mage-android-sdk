package mil.nga.giat.mage.sdk.datastore.location;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="users")
public class User {

    @DatabaseField(generatedId = true)
    private Long pk_id;
    
    @DatabaseField
    private String email;
    
    @DatabaseField
    private String firstname;
    
    @DatabaseField
    private String lastname;
        
    @DatabaseField(canBeNull = false,foreign = true, foreignAutoRefresh = true)
    private Role role;
    
    @DatabaseField(canBeNull = false,foreign = true, foreignAutoRefresh = true)
    private Location location;

	public User() {
        // ORMLite needs a no-arg constructor 
    }
	public User(String email, String firstname, String lastname, Role role,
			Location location) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.location = location;
	}

	public Long getPk_id() {
		return pk_id;
	}

	public void setPk_id(Long pk_id) {
		this.pk_id = pk_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
    
	
}