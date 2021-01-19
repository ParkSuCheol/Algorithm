package Jan;

public class Soulution_PG_전화번호목록_해쉬 {
	public static void main(String[] args) {
//		String[] a = {"119", "97674223", "1195524421"};
//		String[] a = {"123","456","789"};
		String[] a = {"12","123","1235","567","88"};
		
		solution(a);
	}
	
	public static Boolean solution(String[] phone_book) {
		
		for (int i = 0; i < phone_book.length-1; i++) {
			
			int hashPhone = phone_book[i].hashCode();
			int len = phone_book[i].length();
			for (int j = i + 1; j < phone_book.length; j++) {
				if(phone_book[j].length() >= len && 
						hashPhone == (phone_book[j].substring(0,len).hashCode())){
					System.out.println("false");
					return false;
				}
				else if (phone_book[j].length() < len && 
						phone_book[i].substring(0, phone_book[j].length()).hashCode() == phone_book[j].hashCode()) {
					System.out.println("false");
					return false;
				}
			}
		}
		System.out.println("true");
		return true;
	}
	
	public static Boolean solution2(String[] phone_book) {
		for (int i = 0; i < phone_book.length-1; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				if(phone_book[i].startsWith(phone_book[i])) return false;
				if(phone_book[j].startsWith(phone_book[j])) return false;
			}
		}
		return true;
	}
}
