import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Interview {
	
	public void charOccurance() {
		String word = "aaabbaabc";

		char[] ch = word.toCharArray();
//		Map<Character,Integer> map=new HashMap<>();
//		for(int i=0;i<word.length();i++) {
//			ch=word.charAt(i);
//			map.put(ch, map.getOrDefault(ch,0)+1);
//		}
//		System.out.println(map);
		int[] count1 = new int[256];
		for (int j = 0; j < word.length(); j++) {
			//System.out.println(count1['a']);
			count1[word.charAt(j)]++;
			
		}
		for (int i = 0; i < word.length(); i++) {
			int count = 0;
			String str = "";
			char ch1 = word.charAt(i);
			for (int j = 0; j <=i; j++) {
				char ch2 = word.charAt(j);
				// if(!str.contains(String.valueOf(ch1))) {
				if (ch2 == ch1) {
					count++;
				}

			}
if(count==1) {
	System.out.println(word.charAt(i)+" ="+count1[word.charAt(i)]);
}
		}

		// System.out.println(ch1 +" " + count);
	}

	public static void factorial(int n) {
		int sum=1;
		for(int i=1;i<=n;i++) {
			sum=sum*i;
			System.out.println(sum);
		}
	}
	
	public static void uniqueNumber(int[] A) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<A.length;i++) {
			map.put(A[i], map.getOrDefault(A[i], 0)+1);
		}
		for(Entry<Integer, Integer> entry:map.entrySet()) {
			if(entry.getValue()==1) {
				System.out.println(entry.getKey()+" is unique number");
			}
		}
	}

	public static void main(String[] args) {
		//factorial(10);
		int arr[] = {3,5,7,9,7,5,8};
		uniqueNumber(arr);
	}
}
