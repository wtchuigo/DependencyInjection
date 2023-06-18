package wtchuigo.springframework.dependencyInjection.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("wtchuigo")
@ConstructorBinding
public class SfgConstructorConfig {
	
	private final String username;
	private final String password;
	private final String jdbcurl;
	public SfgConstructorConfig(String username, String password, String jdbcurl) {
		super();
		this.username = username;
		this.password = password;
		this.jdbcurl = jdbcurl;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the jdbcurl
	 */
	public String getJdbcurl() {
		return jdbcurl;
	}

}
