import java.lang.Math;
public class toss_2 {
	public static void main(String[] args) {
		solution(100,0,0);
	}

	public static long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
		// orderAmount : �ֹ��ݾ�
		// taxFreeAmount : ������ݾ�
		// serviceFee : �����
		
		// taxAmount : �����ݾ�
		// �Ҽ��� �ø� Math.ceil();
		long taxAmount; // ���� �ݾ�
		long deGa; // ���޴밡
		deGa = orderAmount - serviceFee;
		long a = (long)(orderAmount / 1.1);
		System.out.println(deGa-a);
		return deGa-a;
	}
}
