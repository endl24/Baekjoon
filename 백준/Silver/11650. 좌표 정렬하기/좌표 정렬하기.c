#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>
#include <math.h>
#define SWAP(x, y, t) ((t)=(x), (x)=(y), (y)=(t))

typedef struct {
	int x;
	int y;
}crdnt;


int compare(const void* a, const void* b) {
	crdnt* p1 = (crdnt*)a;
	crdnt* p2 = (crdnt*)b;

	if (p1->x > p2->x) { return 1; }
	if (p1->x < p2->x) { return -1; }

	if (p1->y > p2->y) { return 1; }
	if (p1->y < p2->y) { return -1; }
	return 0;

}



int main() {
	int n;
	scanf("%d", &n);
	crdnt* arr = (crdnt*)malloc(n * sizeof(crdnt));
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &arr[i].x, &arr[i].y);
	}
	qsort(arr, n, sizeof(crdnt), compare);
	for (int i = 0; i < n; i++) {
		printf("%d %d\n", arr[i].x, arr[i].y);
	}


	return 0;
}
