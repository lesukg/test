package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// 프로젝트 빌구 도구: Maven
		// 장점: 의존성 설정을 간결하게 함, 동일한 방식의 배포를 가능하게 함, ....
		// 순수 자바의 경우
		Message1 message1 = new Message1();
		message1.sayHello("홍길동");
		Message2 message2 = new Message2();
		message2.sayHello("신기해");
		System.out.println("-----");
		System.out.println("git 변경");
		// 다형성...인터페이스를 이용한 처리
		// 어떤 객체던 인터페이스를 통해 파생된 객체면 인터페이스를 통한 처리가 가능
		MessageInter inter;
		inter=message1;
		inter.sayHello("홍길동2");
		inter=message2;
		inter.sayHello("신기해2");
		
		System.out.println("******************");
		// 스프링으로 객체 만들기 ... 
		ApplicationContext context=new ClassPathXmlApplicationContext("init.xml");
		MessageInter inter2=(MessageInter)context.getBean("mBean");	// 스프링이 만들어둔 객체를 읽어온 것
		inter2.sayHello("홍길동3");
		
	}
}
