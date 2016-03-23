package com.xiejuqi.sort;

/**
 * 
 * @Filename bubbleSort.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年1月19日 下午4:27:33
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class BubbleSort {

	/**
	 * 简单选择排序 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
	 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
	 * 
	 * @author xiejuqi
	 */
	class selectSort {
		public selectSort() {
			int a[] = { 1, 54, 6, 3, 78, 34, 12, 45 };
			int position = 0;
			for (int i = 0; i < a.length; i++) {
				int j = i + 1;
				position = i;
				int temp = a[i];
				for (; j < a.length; j++) {
					if (a[j] < temp) {
						temp = a[j];
						position = j;
					}
				}
				a[position] = a[i];
				a[i] = temp;
			}

			for (int i = 0; i < a.length; i++)
				System.out.println(a[i]);
		}
	}

	/**
	 * 冒泡排序 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
	 * 让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
	 */
	public BubbleSort() {
		int a[] = { 49, 38, 65, 5, 5, 4323, 23 };
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			System.out.println("外层循环，i=" + i);
			for (int j = 0; j < a.length - 1 - i; j++) {
				System.out.println("里层循环，j=" + j);
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			// System.out.println(a[i]);
		}
	}

	/**
	 * 直接插入排序
	 * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，
	 * 现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
	 */
	public void insertSort() {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			int j = i - 1;
			temp = a[i];
			for (; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j]; // 将大于temp的值整体后移一个单位
			}
			a[j + 1] = temp;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		new BubbleSort();
	}

}
