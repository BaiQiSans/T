#include <stdio.h>
#include <stdlib.h>
#include "..\Headers\duLinkedList.h"

void TraverseList_DuL(DuLinkedList L,void (*visit)(ElemType e)){
	if(L==NULL){
	printf("                                  ____________________________________________________________\n");
	printf("                                  __*            ******************************            *__\n");
	printf("                                  __*                   请先去初始化过了哦                 *__\n"); 
	printf("                                  __*            ******************************            *__\n");
	printf("                                  ____________________________________________________________\n");
	return;}
	DuLinkedList p = L->next;
	while(p)
    {
		visit(p->data);
		p = p->next;
	}
	printf("\n");
}


