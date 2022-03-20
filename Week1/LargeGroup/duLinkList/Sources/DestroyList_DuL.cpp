#include <stdio.h>
#include <stdlib.h>
#include "..\Headers\duLinkedList.h"



void DestroyList_DuL(DuLinkedList *L){
	if((*L)==NULL)return;
	DuLinkedList * p;
    p = L;
	while(*p)
    {
		(*p)= (*p)->next;
		free(L);
		L = p;
	}
}

