package wtchuigo.springframework.dependencyInjection.datasource;

public class FakeDataSource {
	
	private String username;
	private String password;
	private String jdbcurl;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the jdbcurl
	 */
	public String getJdbcurl() {
		return jdbcurl;
	}
	/**
	 * @param jdbcurl the jdbcurl to set
	 */
	public void setJdbcurl(String jdbcurl) {
		this.jdbcurl = jdbcurl;
	}

}
