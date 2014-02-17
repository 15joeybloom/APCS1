/**
 * @author Joey Bloom
 * Assignment #
 * 
 */

import java.util.HashMap;

public class TwoWayHashMap<K,V>
{
    private HashMap<K,V> map;
    private HashMap<V,K> reverseMap;
    
    public TwoWayHashMap()
    {
        map = new HashMap<K,V>();
        reverseMap = new HashMap<V,K>();
    }
    public V put(K key, V value)
    {
        map.put(key,value);
        reverseMap.put(value,key);
        return value;
    }
    public V getByKey(K key)
    {
        return map.get(key);
    }
    public K getByValue(V value)
    {
        return reverseMap.get(value);
    }
}

