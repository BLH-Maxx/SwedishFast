package SwedishFast.GetOneBasicWord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients("SwedishFast.GetOneBasicWord")
@EnableDiscoveryClient
public class GetOneBasicWordApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetOneBasicWordApplication.class, args);
	}

}

