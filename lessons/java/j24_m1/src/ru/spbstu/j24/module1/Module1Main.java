package ru.spbstu.j24.module1;

import ru.spbstu.j24.module1.api.Service;
import ru.spbstu.j24.module2.api.ServiceImpl;

public class Module1Main {
	public static void main(String[] args) {
		Service service = new ServiceImpl();
	}
}
