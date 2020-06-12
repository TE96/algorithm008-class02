# 学习笔记

## 初级排序算法代码

直接插入排序

```java
public static void insertSort(int[] arr) {
    int len = arr.length;
    int preIndex, current;
    for (int i = 1; i < len; i ++) {
        preIndex = i - 1;
        current = arr[i];
        while (preIndex >= 0 && arr[preIndex] > current) {
            arr[preIndex + 1] = arr[preIndex];
            preIndex --;
        }
        arr[preIndex + 1] = current;
    }
}
```

折半插入排序

```java
public static void insertSort(int[] arr) {
    for (int i = 1; i < arr.length; i ++) {
        int current = arr[i];
        // 二分查找插入位置
        int low = 0, high = i - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > current) high = mid - 1;
            else low = mid + 1;
        }
        for (int j = i - 1; j >= high + 1; j --) {
            arr[j + 1] = arr[j];
        }
        arr[high + 1] = current;
    }
}
```

希尔排序

```java
public static void shellSort(int[] arr) {
    int len = arr.length;
    for (int dk = len / 2; dk >= 1; dk /= 2) {
        for (int i = dk + 1; i < len; i ++) {
            // 子表插入排序
            if (arr[i] < arr[i - dk]) {
                int current = arr[i];
                int j = i - dk;
                for (; j >= 0 && current < arr[j]; j -= dk) {
                    arr[j + dk] = arr[j]
                }
                arr[j + dk] = current;
            }
        }
    }
}
```

冒泡排序

```java
public static void bubbleSort(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len; i ++) {
        boolean flag = false;
        for (int j = len - 1; j < i; j --) {
            if (arr[j - 1] > arr[j]) {
                // 交换元素
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                flag = true;
            }
        }
        if (flag == false) return;
    }
}
```

选择排序

```java
public static void selectSort(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len - 1; i ++) {
        int min = i;
        for (int j = i + 1; j < len; j ++) {
            if (arr[j] < min) min = j;
        }
        if (min != i) {
            // 交换元素
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = arr[i];
        }
    }
}
```

