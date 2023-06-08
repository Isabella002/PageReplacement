import java.util.Random;

public class PageGenerator {

	public int[] getReferenceString() {

		int[] rStr1 = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
		//int[] fStr2 = {8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3};
		//int[] rStr3 = {4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4};
		return rStr1;
	}

	public int[] generateRandomReferenceString(int size) {
		int[] referenceString = new int[size];
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			referenceString[i] = random.nextInt(10);
		}

		return referenceString;
	}
}
