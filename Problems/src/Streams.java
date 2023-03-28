import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import problems.model.Person;

public class Streams {
	public static void main(String[] args) {
		List<String> collect = Stream.of("one", "two", "three", "four")
		  .filter(e -> e.length() > 3)
		  .peek(e -> System.out.println("Filtered value: " + e))
		  .map(String::toUpperCase)
		  .peek(e -> System.out.println("Mapped value: " + e))
		  .collect(Collectors.toList());
		
		collect.stream().forEach(i -> System.out.println("Post collection:"+i));
		
		//exercise 1
		System.out.println(getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam"));
		
		//exercise 2
		List<List<String>> collection = Arrays.asList(Arrays.asList("Viktor", "Farcic"), Arrays.asList("John", "Doe", "Third"));
	    List<String> expected = Arrays.asList("Viktor", "Farcic", "John", "Doe", "Third");
	    transform(collection).forEach(s -> System.out.println(s));
	}

	
	public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
	    return Arrays.stream(names).mapToInt(s -> s.length()).filter(i -> i>5).sum();
	   
	}
	
	public static List<String> transform(List<List<String>> collection) {
//		List<String> newCollection = new ArrayList<>();
//		for (List<String> subCollection : collection) {
//			for (String value : subCollection) {
//				newCollection.add(value);
//			}
//		}
//		return newCollection;
		
		return collection.stream().flatMap(ls -> ls.stream()).collect(Collectors.toList());
	}
	
	public static Person getOldestPerson(List<Person> people) {
//		Person oldestPerson = new Person("", 0);
//		for (Person person : people) {
//			if (person.getAge() > oldestPerson.getAge()) {
//				oldestPerson = person;
//			}
//		}
//		return oldestPerson;
		
		return people.stream().max(Comparator.comparing(Person::getAge)).get();
		
	}
	
	//Sum of all numbers using reduce
	public static int calculate(List<Integer> numbers) {
		return numbers.stream().reduce(0, (n1,n2) -> (n1+n2));
	}

	public static Set<String> getKidNames(List<Person> people) {
		/*Set<String> kids = new HashSet<>();
		for (Person person : people) {
			if (person.getAge() < 18) {
				kids.add(person.getName());
			}
		}
		return kids;*/


        return people.stream().filter(p -> p.getAge() < 18).map(Person::getName).collect(Collectors.toSet());
    }
}
