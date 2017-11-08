import java.util.Arrays;

public class Kuan {
	 private int[] array;

	public Kuan(int[] array){
		this.array = array;
	}

	public  int getLunkhead() {
		return array.length;
	}

	public  int getRousing() {
		Arrays.sort(array);
		int min = array[0];
		int max = array[array.length - 1];
		return max-min;
	}

	public  double getCollomia() {
		double sum = 0.0;
		for(int i = 0; i < array.length ; i++) {
			sum += array[i];
		}
		sum = sum/array.length;
		return sum;
	}
}


