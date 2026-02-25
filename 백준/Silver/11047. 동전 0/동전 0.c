#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>
#include <math.h>
#define SWAP(x, y, t) ((t)=(x), (x)=(y), (y)=(t))

int main() {
	int n, k;
	scanf("%d %d", &n, &k);
	int* arr = (int*)malloc(n * sizeof(int));
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	int coin = 0;
	for (int i = n-1; i >= 0; i--) {
		if (k >= arr[i]) {
			int tmp = k / arr[i];
			k = k - tmp * arr[i];
			coin += tmp;
		}
	}
	printf("%d", coin);
	return 0;
}
