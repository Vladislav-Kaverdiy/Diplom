package source.it.com.database;

public enum Role {
	ADMINISTRATOR("administrator"), CLIENT("client");
	private String name;
	Role(String name)
	{
		this.name = name;		
	}
	
	public static Role getRole(source.it.com.model.Role role) {
		String roleName = role.getRoleName();
		return Role.ADMINISTRATOR.getName().equals(roleName)? Role.ADMINISTRATOR : Role.CLIENT;
	}

	public String getName() {
		return this.name;
	}
}
