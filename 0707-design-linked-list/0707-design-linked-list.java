class Node {
    int val;
    Node next;

    Node(int val){
        this.val=val;
        this.next=null;
    }
}

class MyLinkedList {
    Node head;
    public MyLinkedList() {
        head=null;
    }
    
    public int get(int index) {
        Node temp=head;
        int count=0;

        while(temp!= null){
            if(count == index){
                return temp.val;
            }
            temp= temp.next;
            count++;
        }

        return -1;
    }
    
    public void addAtHead(int val) {
        Node temp=new Node(val);
        temp.next=head;
        head=temp;
    }
    
    public void addAtTail(int val) {
        Node newNode=new Node(val);
        Node temp = head;

        if (head == null) {
        head = newNode;
        return;
    }
        while(temp.next != null){
            temp= temp.next;
        }

        temp.next=newNode;
        newNode.next=null;
    }
    
    public void addAtIndex(int index, int val) {
        Node temp= head;
        int count=0;
        Node newNode= new Node(val);
        while(temp != null){
            temp= temp.next;
            count++;
        }
        if(index==count){
            addAtTail(val);
            return;
        }
        if(index==0){
            addAtHead(val);
            return;
        }
        if (index > count) {
        return;
    }
        temp=head;
        while(index != 1){
           temp=temp.next;
            index--;
        }
        newNode.next=temp.next;
        temp.next=newNode;

    }
    
    public void deleteAtIndex(int index) {
    Node temp = head;
    int count = 0;
    while (temp != null) {
        temp = temp.next;
        count++;
    }

    if (index < 0 || index >= count) {
        return;
    }

    if (index == 0) {
        head = head.next;
        return;
    }

    temp = head;

    while (index != 1) {
        temp = temp.next;
        index--;
    }

    temp.next = temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */