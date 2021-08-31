import java.lang.Math;
public class toss_2 {
	public static void main(String[] args) {
		solution(100,0,0);
	}

	public static long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
		// orderAmount : 주문금액
		// taxFreeAmount : 비과세금액
		// serviceFee : 봉사료
		
		// taxAmount : 과세금액
		// 소수점 올림 Math.ceil();
		long taxAmount; // 과세 금액
		long deGa; // 공급대가
		deGa = orderAmount - serviceFee;
		long a = (long)(orderAmount / 1.1);
		System.out.println(deGa-a);
		return deGa-a;
	}
}
