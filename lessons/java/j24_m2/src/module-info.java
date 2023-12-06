import ru.spbstu.j24.module1.api.Service;
import ru.spbstu.j24.module2.api.ServiceImpl;

module j24_m2 {
	requires j24_m1;
	provides Service with ServiceImpl;
}