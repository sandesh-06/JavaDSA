package HashMap.Concepts;

import java.util.LinkedList;

public class HM_3_ImplementOwnHashMap {
    static class MyHashMap<K, V>{ //since key and value can be of any datatype
        //1. THE DEFAULT CAPACITY OF HASHMAP IN COLLECTION FRAMEWORK IS 16
        public static final int DEFAULT_CAPACITY = 4; //we are taking as 4

        //2. THE DEFAULT LOAD FACTOR IS 0.75, WHEN THE LOAD FACTOR IS EXCEEDED, THE CAPACITY IS DOUBLED
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;

        //3. REQUIRED PARAMETERS
        private int n; //the no.of entries
        private class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private LinkedList<Node>[] buckets; //array of linked lists to store the elements

        //4. CREATING DEFAULT CONSTRUCTOR
        private void initBuckets(int N){ //N - capacity/size of buckets array
            buckets = new LinkedList[N];
            for(int i = 0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }
        }
        public MyHashMap(){
            initBuckets(DEFAULT_CAPACITY); //initializing empty linked lists on every index of the array
        }
        public int getBucketLength(){
            return buckets.length;
        }
        //5. HASHMAP FUNCTIONS
        public int size(){ //returns total entries of HashMap
            return n;
        }

        private void rehash(){
            //1. STORE THE OLD BUCKET VALUES
            LinkedList<Node>[] old_bucket = buckets;
            //2. INITIALIZE NEW BUCKETS WITH NEW CAPACITY
            initBuckets(old_bucket.length * 2);
            //3. RESET THE NO OF ENTRIES
            n = 0;
            //4. COPY ALL THE ELEMENTS TO NEW BUCKET
            for(var bucket: old_bucket){ //traverse each index of array
                for(var node: bucket){ //traverse each node in the index
                    put(node.key, node.value);
                }
            }
        }
        private int hashFunc(K key){
            int hash_code = key.hashCode(); //gives the hash code which can be of any length and even -ve
            return  (Math.abs(hash_code) % buckets.length);
        }
        private int searchInBucket(K key, LinkedList<Node> bucket){
            for(int i = 0; i<bucket.size(); i++){
                if(bucket.get(i).key == key) return i;
            }
            return -1;
        }
        public void put(K key, V value){
            //1. GET THE BUCKET INDEX
            int buck_idx = hashFunc(key);
            //2. TRAVERSE THE NODES IN THE INDEX AND MAKE SURE THE KEY DOESN'T EXIST ALREADY
            LinkedList<Node> curr_buck = buckets[buck_idx];
            int key_idx = searchInBucket(key, curr_buck); //return -1 if key not found
            //3. CHECK IF THE KEY EXIST OR NOT AND PERFORM ACCORDINGLY
            if(key_idx == -1){ //key doesn't exist, add new node
                Node node = new Node(key, value);
                curr_buck.add(node);
                n++; //increase the no.of entries
            }else{ //if key already exist, update it
                curr_buck.get(key_idx).value = value;
            }

            //4. IF THE NO.OF ENTRIES EXCEEDS THE LOAD FACTOR, PREFORM REHASHING (DOUBLE THE CAPACITY OF NO OF BUCKETS AND INSERT THE EXISTING ELEMENTS IN THE NEW BUCKETS)
            if(n >= buckets.length * DEFAULT_LOAD_FACTOR) rehash();
        }

        public V get(K key){
            //1. GET THE BUCKET INDEX
            int buck_idx = hashFunc(key);
            //2. TRAVERSE THE NODES IN THE INDEX AND GET THE VALUE FOR THE KEY, IF VALUE DOESN'T EXIST RETURN NULL
            LinkedList<Node> curr_buck = buckets[buck_idx];
            int key_idx = searchInBucket(key, curr_buck);

            if(key_idx == -1) return null;
            else{
                return curr_buck.get(key_idx).value;
            }
        }

        public V remove(K key){
            //1. GET THE BUCKET INDEX
            int buck_idx = hashFunc(key);
            //2. TRAVERSE THE NODES IN THE INDEX AND GET THE VALUE FOR THE KEY
            LinkedList<Node> curr_buck = buckets[buck_idx];
            int key_idx = searchInBucket(key, curr_buck);

            if(key_idx == -1) return null;
            else{
                V val = curr_buck.get(key_idx).value;
                curr_buck.remove(key_idx);
                n--;
                return val;
            }
        }
    }

    public static void main(String[] args) {

        MyHashMap<Integer, String> mp = new MyHashMap<>();

        mp.put(22, "Solar");
        mp.put(20, "Lunar");
        System.out.println(mp.get(20));
        System.out.println(mp.get(22));
        mp.remove(20);
        System.out.println(mp.get(20));
        System.out.println("Length " + mp.getBucketLength());

        mp.put(55, "Moonar");
        mp.put(67, "Kolar");
        mp.put(78, "Palar");
        mp.put(55, "Updated 55");
        System.out.println(mp.get(55));
        System.out.println(mp.get(78));
        System.out.println(mp.size());
        System.out.println("Length " + mp.getBucketLength());
    }
}
