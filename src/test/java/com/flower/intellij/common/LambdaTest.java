package com.flower.intellij.common;

import com.flower.intellij.domain.Shed;
import com.flower.intellij.domain.Switch;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wanli zhou
 * @created 2018-01-26 10:33 PM.
 */
public class LambdaTest {

	@Test
	public void lambdaTest(){
		List<Shed> sheds = new ArrayList<>();
		Shed shed1 = new Shed();
		Switch s1 = new Switch();
		s1.setDeviceId("1");
		Switch s2 = new Switch();
		s2.setDeviceId("2");
		Switch s3 = new Switch();
		s3.setDeviceId("3");
		Switch s4 = new Switch();
		s4.setDeviceId("4");

		shed1.getSwitchs().add(s1);
		shed1.getSwitchs().add(s2);
		shed1.getSwitchs().add(s3);
		shed1.getSwitchs().add(s4);

		Shed shed2 = new Shed();
		Switch s11 = new Switch();
		s11.setDeviceId("1");
		Switch s12 = new Switch();
		s12.setDeviceId("2");
		Switch s13 = new Switch();
		s13.setDeviceId("3");
		Switch s14 = new Switch();
		s14.setDeviceId("4");

		shed2.getSwitchs().add(s11);
		shed2.getSwitchs().add(s12);
		shed2.getSwitchs().add(s13);
		shed2.getSwitchs().add(s14);

		sheds.add(shed1);
		sheds.add(shed2);

		List<String> ss = sheds.stream().map(shed -> shed.getSwitchs().stream().map(s -> s.getDeviceId()).distinct()).flatMap(s -> s).distinct().collect(Collectors.toList());

		System.out.println(ss);
	}

	@Test
	public void lambdaTryCatchTest(){
		List<Integer> lists = IntStream.range(0, 20).boxed().collect(Collectors.toList());
		lists.stream().forEach(i -> {
			try{
				System.out.println(5 / i);
			}catch (Exception e){
				e.printStackTrace();
				return;
			}
		});
	}

	@Test
	public void percentTest(){
		int a = 1;
		int b = 30;
		System.out.println(a / b );
		System.out.println((float)a / (float)b);
		System.out.println(BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_UP));
	}

	@Test
	public void toMapLambda(){
		List<Person> persons = new ArrayList<>();
		Map<String, Person> pmap = IntStream.range(1, 10).boxed().map(i -> new Person("p" + i)).collect(Collectors.toList()).stream().collect(Collectors.toMap(p -> p.getName(), p -> p));
		System.out.println(pmap);
	}

	@Test
	public void sbTest(){
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.delete(0, sb.length()));
		sb.append("Hello World");
		System.out.println(sb);
		System.out.println(sb.delete(0, sb.length()));
	}
}
class Person{
	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
			"name='" + name + '\'' +
			'}';
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
