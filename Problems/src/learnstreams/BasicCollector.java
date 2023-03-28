package learnstreams;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
 
public class BasicCollector {
  static List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45),
      new Employee("Harry Major", 25),
      new Employee("Ethan Hardy", 65),
      new Employee("Nancy Smith", 22),
      new Employee("Deborah Sprightly", 29));
 
  public static void main(String args[]){
		/*
		 * Map<Boolean,List<Employee>> employeeMap = employeeList.stream()
		 * .collect(Collectors.partitioningBy(emp -> emp.getAge() > 30));
		 * System.out.println("Employees partitioned based on age");
		 * employeeMap.forEach((Boolean key, List<Employee> empList) ->
		 * System.out.println(key +"->" + empList));
		 */
	  

	     
	      List<Employee> filteredList = employeeList.stream().filter(emp -> emp.getAge() > 40)
	                  .collect(Collectors.toList());
	    System.out.println("Employees partitioned based on age");
	    filteredList.forEach((Employee e) -> System.out.println(e));
  }
 
}