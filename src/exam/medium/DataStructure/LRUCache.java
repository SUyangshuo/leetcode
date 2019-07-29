package exam.medium.DataStructure;

import java.util.HashMap;
import java.util.Map;

/**  146 LRU Cache
 * 制作一个数据结构，能够实现最近最久未使用的缓存，要求时间复杂度最好为1
 * 通过这个时间复杂度，可以知道需要有map结构，为了实现最近最久未使用的功能需要使用双向链表，
 * 可以在1的时间内实现节点增加和断裂
 * 暂定把最近的元素放在头部，最久的元素放在尾部，
 *
 * 实现get操作，通过给定的key给出vault
 * 实现set操作，
 */
class LRUCache {
    Map<Integer,LRU_Node> map;
    int capacity;
    //首尾节点
    LRU_Node head;
    LRU_Node end;

    public LRUCache(int capacity) {
        this.map=new HashMap<>(capacity);
        this.head=new LRU_Node(-1,0);
        this.end=new LRU_Node(-1,0);
        this.head.next=this.end;
        this.end.pre=this.head;
        this.capacity=capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        LRU_Node node=map.get(key);

        //操作节点，放在头部
        moveNode(node);

        return map.get(key).value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            LRU_Node node = map.get(key);
            node.value = value;
            moveNode(node);
        }else {
            LRU_Node node=new LRU_Node(key,value);
            //判断map是否可以放下，放不下的要删除最后一个元素
            if(map.size()==this.capacity){
                map.remove(end.pre.key);

                this.end.pre.pre.next=this.end;
                this.end.pre=this.end.pre.pre;
            }
            addNode(node);

        }

    }
    public void deletNode(LRU_Node  node){
        map.remove(node.key);
        node.next.pre=node.pre;
        node.pre.next=node.next;


    }
    public void addNode(LRU_Node  node){
        this.head.next.pre=node;
        node.next=this.head.next;
        node.pre=this.head;
        this.head.next=node;
        map.put(node.key,node);
    }
    //移动后的节点放在头节点
    public void moveNode(LRU_Node  node){
        deletNode(node);
        addNode(node);
    }
}
class LRU_Node{
    int value;
    int key;//暂时没什么特别大的作用，但是为了保持结构一致集中，暂时保留作为map的key
    LRU_Node pre;
    LRU_Node next;
    public LRU_Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}