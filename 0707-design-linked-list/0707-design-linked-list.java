class Node{
    int val;
    Node prev;
    Node next;

    Node(int val){
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}
class MyLinkedList {
    Node head;
    Node tail;
    public MyLinkedList() {
        head=null;
    }
    
    public int get(int index) {
        Node temp = head;

        while(temp != null){
            if(index == 0){
                return temp.val;
            }
            temp = temp.next;
            index--;
        }
        return -1;
        
    }
    
    public void addAtHead(int val) {
        Node newNode =new Node(val);
        if(head == null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);

        if(head == null){
            head=newNode;
            return;
        }
        Node temp=head;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next=newNode;
        newNode.prev=temp;
    }
    
    public void addAtIndex(int index, int val) {
        if(index <0){
            return;
        }
        
        if(index == 0){
            addAtHead(val);
            return;
        }
        Node temp= head;
        int count=0;
        while(temp != null){
            count++;
            temp = temp.next;
            
        }
        if(count == index){
            addAtTail(val);
            return;
        }
        if(index > count ){
            return ;
        }
        temp=head;
        Node newNode= new Node(val);
        while(temp != null){
            if(index == 1){
                newNode.next=temp.next;
                if(temp.next != null){
                    temp.next.prev=newNode;
                }
                newNode.prev=temp;
                temp.next=newNode;
                return;
            }
            temp = temp.next;
            index--;
        }
        
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0){
            return;
        }
        if(head == null){
            return;
        }
        if (head.next == null && index == 0) {
        head = null;
        return;
    }
        int count=0;
        Node temp= head;

        while(temp != null){
            count ++;
            temp = temp.next;
        }
        temp =head;

        if((count-1) == index){
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next=null;
            return;
        }
        if( index == 0){
            if( head == null){
                return;
            }
            head= head.next;
            if(head != null)
                head.prev=null;
            return;
        }
        temp= head;
        while(temp != null){
            if( index == 1){
                if (temp.next == null) return;
                temp.next =temp.next.next;
                if (temp.next != null)
                temp.next.prev=temp;
                return;
            }
            temp= temp.next;
            index--;
        }
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