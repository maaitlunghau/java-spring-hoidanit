package vn.hoidanit.springsieutoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringsieutocApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(SpringsieutocApplication.class, args);

		System.out.println("----------------------------------------");
		System.out.println("Danh sách các Bean đang được quản lý bởi Spring Context:");
		System.out.println("----------------------------------------");
		for (String s : ac.getBeanDefinitionNames()) {
			System.out.println(s);
		}
		System.out.println("----------------------------------------");
	}
}
