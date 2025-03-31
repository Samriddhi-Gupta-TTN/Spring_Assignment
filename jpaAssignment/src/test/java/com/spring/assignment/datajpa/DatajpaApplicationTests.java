package com.spring.assignment.datajpa;

import com.spring.assignment.datajpa.part2.Question3.Check;
import com.spring.assignment.datajpa.part2.Question3.CreditCard;
import com.spring.assignment.datajpa.part2.Question3.PaymentRepo;
import com.spring.assignment.datajpa.part2.Question4.EmpRepo;
import com.spring.assignment.datajpa.part2.Question4.Employee3;
import com.spring.assignment.datajpa.part2.Question4.SalaryDetails2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataJpaApplicationTests {

	@Autowired
	PaymentRepo paymentRepository;

	@Autowired
	EmpRepo employeeRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreatePayment1(){
		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setAmount(1000d);
		cc.setCardNumber("1238984028402");
		paymentRepository.save(cc);
	}


	@Test
	public void testCreatePayment2(){
		Check ch = new Check();
		ch.setId(124);
		ch.setAmount(1500d);
		ch.setCheckNumber("1238984028402");
		paymentRepository.save(ch);
	}

	@Test
	public void testEmployeeComponentMapping(){

		Employee3 employee = new Employee3();
		employee.setFirstName("	Samriddhi");
		employee.setLastName("Gupat");
		employee.setAge(23);

		SalaryDetails2 salaryDetails = new SalaryDetails2();
		salaryDetails.setBasicSalary(50033);
		salaryDetails.setBonusSalary(2432);
		salaryDetails.setTaxAmount(233);
		salaryDetails.setSpecialAllowanceSalary(242552);

		employee.setSalaryDetails(salaryDetails);
		employeeRepository.save(employee);
		System.out.println("Employee saved successfully");
	}


}