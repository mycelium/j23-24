package l20231018;

public class Box <T> {
	private T t;

    public Box(T t) { this.t = t; }

    public Box<T> copy() { return new Box<>(t); }

    public T get() { return t; }
}
