package l20231018;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		// Null problems

		int primitiveInt = null; // compilation error

		Integer objectInt = null; // Ok

		primitiveInt = objectInt; // No compilation error. Runtime exception

		// Java arrays are covariant
		Number[] nums = new Number[5];
		nums[0] = Integer.valueOf(1); // Ok
		nums[1] = Double.valueOf(1.1); // Ok

		Integer[] intArr = new Integer[5];
		Number[] numArr = intArr; // Ok

		// The problem of covariant arrays
		numArr[0] = Double.valueOf(1.1);

		List<Integer> intList = List.of();
		List<Number> numList = List.of();
		List<? extends Number> covariantNumList = List.of();
		List<? super Integer> contravariantIntList = List.of();

		numList = intList; // Collections are invariant by default
		intList = numList; // Collections are invariant and this looks strange

		covariantNumList = intList;
		contravariantIntList = numList;

		Box<String> bs = new Box<>("hi!"); // safe
		Box<?> bq = bs; // safe, via subtyping
		Box<Integer> bi = (Box<Integer>) bq; // unchecked cast -- warning issued
		Integer i = bi.get(); // ClassCastException in synthetic cast to Integer

		List<Integer> myInts = List.of(1, 2, 3, 4);
		List<Double> myDoubles = List.of(3.14, 6.28);
		List<Object> myObjs = new ArrayList<>();
		copy(myInts, myObjs);
		copy(myDoubles, myObjs);
		myObjs.forEach(o -> System.out.println(o.toString()));

	}

	public static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for (Number number : source) {
			destiny.add(number);
		}
	}

}