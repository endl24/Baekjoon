#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>
#include <math.h>
#define SWAP(x, y, t) ((t)=(x), (x)=(y), (y)=(t))

int sort(int* a, int n, int* t) {
	int tmp;
	int dif_cnt = 0;
	for (int i = 0; i < n; i++) {
		if (a[i] != t[i]) { dif_cnt++; }
	}
	if (!dif_cnt) { return 1; }
	for (int i = n-1; i >= 1; i--) {
		for (int j = 0; j < i; j++) {
			if (a[j] > a[j + 1]) {
				if (a[j] != t[j]) { dif_cnt--; }
				if (a[j + 1] != t[j + 1]) { dif_cnt--; }
				SWAP(a[j], a[j + 1], tmp);
				if (a[j] != t[j]) { dif_cnt++; }
				if (a[j + 1] != t[j + 1]) { dif_cnt++; }
				if (dif_cnt==0) { return 1; }
			}
		}
	}
	return 0;
}

int main() {
	int n;
	scanf("%d", &n);
	int* arr = (int*)malloc(n * sizeof(int));
	int* tmp = (int*)malloc(n * sizeof(int));
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 0; i < n; i++) {
		scanf("%d", &tmp[i]);
	}

	int flag = sort(arr, n, tmp);

	printf("%d", flag);

	free(arr);
	free(tmp);
	return 0;
}

