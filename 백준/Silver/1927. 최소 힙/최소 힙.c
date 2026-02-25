#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>
#include <math.h>


typedef struct {
	int key;
}element;
typedef struct {
	element heap[100000];
	int heap_size;
}HeapType;

HeapType* create() {
	return (HeapType*)malloc(sizeof(HeapType));
}
void init(HeapType* heap) {
	heap->heap_size = 0;
}
void insert_min_heap(HeapType* h, element item) {
	int i = ++(h->heap_size);

	while (i != 1 && item.key < h->heap[i / 2].key) {
		h->heap[i] = h->heap[i / 2];
		i /= 2;
	}
	h->heap[i] = item;
}
element delete_min_heap(HeapType* h) {
	if (h->heap_size == 0) { 
		element item;
		item.key = 0;
		return item;
	}

	element item = h->heap[1];
	element temp = h->heap[h->heap_size--];
	int parent = 1, child = 2;

	while (child <= h->heap_size) {
		if ((child < h->heap_size) && h->heap[child].key > h->heap[child + 1].key) {
			child++;
		}
		if (temp.key <= h->heap[child].key) { break; }

		h->heap[parent] = h->heap[child];
		parent = child;
		child *= 2;
	}
	h->heap[parent] = temp;
	return item;
}


int main() {
	HeapType* h = create();
	init(h);
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		element x;
		scanf("%d", &x.key);
		if (x.key == 0) {
			printf("%d\n", delete_min_heap(h).key);
		}
		else {
			insert_min_heap(h, x);
		}
	}
	free(h);

	return 0;
}