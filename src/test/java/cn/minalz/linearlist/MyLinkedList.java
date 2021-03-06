package cn.minalz.linearlist;

/**
 * 链表设计
 */
public class MyLinkedList {

    // 头结点
    Node head;
    // 尾结点
    Node tail;
    // 链表长度
    int size;

    // Node定义
    private class Node {
        int val;
        Node prev;
        Node next;
        Node(int value){
            this.val = value;
        }
    }

    // 初始化链表构造方法
    public MyLinkedList() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    // 根据索引获取值
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node curr = head;
        if(index + 1 < size - index){
            for(int i = 0; i < index + 1; i++){
                curr = curr.next;
            }
        }else{
            curr = tail;
            for(int i = 0; i < size - index; i++){
                curr = curr.prev;
            }
        }
        return curr.val;
    }

    // 添加值到链表的头部
    public void addAtHead(int val) {
        Node pred = head;
        Node succ = head.next;
        ++size;
        Node toAdd = new Node(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    // 添加值到链表的尾部
    public void addAtTail(int val) {
        Node succ = tail;
        Node pred = tail.prev;
        ++size;
        Node toAdd = new Node(val);
        toAdd.next = succ;
        toAdd.prev = pred;
        pred.next = toAdd;
        succ.prev = toAdd;
    }
    
    // 在索引index处添加新的元素
    public void addAtIndex(int index, int val) {
        if(index > size ) {
            return;
        }
        if(index < 0){
            index = 0;
        }
        Node pred,succ;
        if(index < size - index){
            pred = head;
            for(int i = 0; i < index; i++){
                pred = pred.next;
            }
            succ = pred.next;
        }else{
            succ = tail;
            for(int i = 0; i < size - index; i++){
                succ = succ.prev;
            }
            pred = succ.prev;
        }

        ++size;
        Node toAdd = new Node(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }
    
    // 删除索引index处的值
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        Node pred,succ;
        if(index < size - index){
            pred = head;
            for(int i = 0; i < index; i++){
                pred = pred.next;
            }
            succ = pred.next.next;
        }else{
            succ = tail;
            for(int i = 0; i < size - index -1; i++){
                succ = succ.prev;
            }
            pred = succ.prev.prev;
        }
        --size;
        pred.next = succ;
        succ.prev = pred;
    }
}