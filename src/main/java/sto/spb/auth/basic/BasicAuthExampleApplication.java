/*
In case of basic authentication, the username and password is only encoded with Base64, but not encrypted or hashed in any way.
Hence, it can be compromised by any man in the middle. It is always recommended to authenticate rest API calls by this header 
over a SSL connection.
*/
package sto.spb.auth.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/*
 (exclude={SecurityAutoConfiguration.class}) --> By default if spring security jars are included in the build path then default security
 												 configuration are added. When this is added the security constraints are disabled.
*/
@SpringBootApplication/*(exclude={SecurityAutoConfiguration.class})*/
@ComponentScan(basePackages = "sto.spb.auth.basic")
public class BasicAuthExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthExampleApplication.class, args);
	}

}