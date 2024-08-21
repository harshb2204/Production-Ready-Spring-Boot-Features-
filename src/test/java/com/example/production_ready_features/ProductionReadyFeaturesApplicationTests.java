package com.example.production_ready_features;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductionReadyFeaturesApplicationTests {
//	@Autowired
//	private EmployeeClient employeeClient;
//	@Test
//	@Order(3)
//	void getAllEmployeesTest(){
//		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
//		System.out.println(employeeDTOList);
//
//	}
//
//	@Test
//	@Order(2)
//	void getEmployeeByIdTest(){
//		EmployeeDTO employeeDTO  = employeeClient.getEmployeebyid(1L);
//		System.out.println(employeeDTO);
//	}
//
//	@Test
//	@Order(1)
//	void createNewEmployeeTest(){
//		EmployeeDTO employeeDTO= new EmployeeDTO(null, "Harsh", 20, "USER", LocalDate.
//				of(2020, 12, 1),
//				true
//				);
//		EmployeeDTO savedemployeeDTO = employeeClient.createnewemployee(employeeDTO);
//		System.out.println(savedemployeeDTO);
//	}

}
