import java.util.*;

public class KAKAO_2 {
	public static void main(String[] args) {
		solution(437674, 3);
//		solution(110011,10);
	}

	public static int solution(int n, int k) {
		int answer = 0;
		String res = "";
		int num = n;
		while (num > 0) {
			int share = num / k;
			int remainder = num % k;
			if (remainder > 9) {
				res = (char) (remainder + 55) + res;
			} else {
				res = remainder + res;
			}
			num = share;
		}
		System.out.println(res);
		String tmp = "";
		for (int i = 0; i < res.length(); i++) {
			if (res.charAt(i) == '0') {
				tmp = res.substring(0, i);
				int chk = Integer.parseInt(tmp);
				System.out.println(chk);
				if (chk >= 100) {
					if ((chk / 10) % 10 == 0) {
						continue;
					}
				}
				if (chk >= 2 && isPrime(chk)) {
					System.out.println(chk + "/////////");
					answer++;
					res = res.substring(i, res.length());
					System.out.println(res);
					i = 0;
				}else {
					res = res.substring(i,res.length());
				}
			}
		}
		return answer;
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
