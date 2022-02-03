package lectures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamFilter {

	public void regular()

	{

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "/Users/ASUS/Documents/chromedriver.exe"); WebDriver driver = new
		 * ChromeDriver();
		 *
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 */

		ArrayList<String> names = new ArrayList<>();
		names.add("gokul");
		names.add("gowtham");
		names.add("gopika");
		names.add("suriya");

		int count = 0;

		for (String name : names) {
			if (name.startsWith("g")) {
				count++;
			}
		}

		System.out.println("counts :" + count);
		System.out.println("\t");
	}

	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<>();
		names.add("s.gokul");
		names.add("s.gowtham");
		names.add("p.gopika");
		names.add("s.suriya");

		long c = names.stream().filter(g -> g.startsWith("s")).count();
		System.out.println("1st count " + c);

		long b = Stream.of("cat", "dog", "rat", "goat").filter(k -> {k.startsWith("c");
			return true;
		}).count();

		System.out.println("2nd count :" + b);
		System.out.println("\t");

		// print all the name of arrayList
		names.stream().filter(s -> s.length() > 7).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 8).limit(1).forEach(s -> System.out.println("more than 8 letters :" +s));
		System.out.println("\t");

	}

	@Test
	public void streamMap()

	{
		ArrayList<String> names = new ArrayList<>();
		names.add("s.gokul");
		names.add("s.gowtham");
		names.add("p.gopika");
		names.add("s.suriya");

		System.out.println("Words ends with g :");
		Stream.of("Cat", "dog", "Rat", "goat", "coat", "cow", "mug").filter(s -> s.endsWith("g")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("\t");

		List<String> person = Arrays.asList("Cat", "dog", "Rat", "goat", "coat", "cow", "mug");

		System.out.println("Words starts with c :");
		person.stream().filter(s -> s.startsWith("c")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("\t");

		Stream<String> newStream = Stream.concat(names.stream(), person.stream());
		// newStream.sorted().forEach(s -> System.out.println(s));

		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Cat"));
		Assert.assertTrue(flag);
		System.out.println(flag);

	}

	@Test
	public void streamCollect()

	{

		List<String> ls = Stream.of("Cat", "dog", "Rat", "goat", "coat", "cow", "mug").filter(s -> s.startsWith("g")).map(s -> s.toUpperCase()).collect(Collectors.toList());
		List<String> lsx = Stream.of("GOWTHAM RAJ" , "GOBIKA").map(s -> s.toLowerCase()).collect(Collectors.toList());

		String t1 = ls.get(0);
		String t2 = lsx.get(1);

		System.out.println(t1 + "\n" + t2);

		///////////////

		List<Integer> values = Arrays.asList(3,5,6,7,6,5,1,2,2);
		System.out.println("unique numbers are ");

		values.stream().distinct().forEach(s->
		System.out.println(s));
		List<Integer> v = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("3rd values of unique numbers " + v.get(3));

	}
}