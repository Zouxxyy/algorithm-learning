/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
*/


/*
简单的链表操作
*/


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode* newhead = new ListNode(0);
        newhead->next = head;
        ListNode* i = newhead;
        ListNode* j = head;
        while(i->next != NULL && i->next->next != NULL){
            i->next = j->next;
            j->next = j->next->next;
            i->next->next = j;
            i = j;
            j = j->next;
        }
        return newhead->next;
    }
};