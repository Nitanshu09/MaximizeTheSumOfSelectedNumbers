import java.util.*;

public class MaximizeTheSum {
	public static int maximizeSum(int arr[], int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int sum = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (map.containsKey(arr[i])) {
				if (map.get(arr[i]) > 1) {
					sum = sum + arr[i];
					map.put(arr[i], map.get(arr[i]) - 1);
				} else {
					map.remove(arr[i]);
					sum = sum + arr[i];
				}
				System.out.println(map);
				if (map.containsKey(arr[i] - 1) && map.get(arr[i] - 1) > 1) {
					map.put(arr[i] - 1, map.get(arr[i] - 1) - 1);
				} else if (map.containsKey(arr[i] - 1)) {
					map.remove(arr[i] - 1);
				}
			}
			System.out.println(map);
		}
		return sum;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 2, 3, 4 };
		System.out.println(maximizeSum(arr, arr.length));
	}

}
