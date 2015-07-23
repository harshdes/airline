package com.github.rvesse.airline.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.Predicate;

public class AirlineUtils {

    public static <T> List<T> arrayToList(T[] array) {
        return IteratorUtils.toList(IteratorUtils.arrayIterator(array));
    }

    public static <T> T first(Iterable<T> iterable) {
        return first(iterable.iterator(), null);
    }

    public static <T> T first(Iterator<T> iterator) {
        return first(iterator, null);
    }

    public static <T> T first(Iterable<T> iterable, T defaultValue) {
        return first(iterable.iterator(), defaultValue);
    }

    public static <T> T first(Iterator<T> iter, T defaultValue) {
        if (iter.hasNext()) {
            return iter.next();
        } else {
            return defaultValue;
        }
    }

    public static <T> T last(Iterable<T> iterable) {
        return last(iterable.iterator(), null);
    }

    public static <T> T last(Iterator<T> iterator) {
        return last(iterator, null);
    }

    public static <T> T last(Iterable<T> iterable, T defaultValue) {
        return last(iterable.iterator(), defaultValue);
    }

    public static <T> T last(Iterator<T> iter, T defaultValue) {
        T value = defaultValue;
        while (iter.hasNext()) {
            value = iter.next();
        }
        return value;
    }

    public static <T> List<T> singletonList(T item) {
        List<T> list = new ArrayList<T>();
        list.add(item);
        return list;
    }

    public static <T> Set<T> singletonSet(T item) {
        Set<T> set = new HashSet<T>();
        set.add(item);
        return set;
    }
    
    public static <K, V> Map<K, V> singletonMap(K key, V value) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(key, value);
        return map;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> intersection = new HashSet<T>();
        for (T item : a) {
            if (b.contains(item))
                intersection.add(item);
        }
        return intersection;
    }

    public static <T> List<T> listCopy(Collection<T> collection) {
        if (collection == null)
            return new ArrayList<T>();
        return new ArrayList<T>(collection);
    }

    public static <T> List<T> listCopy(Iterable<T> iterable) {
        if (iterable == null)
            return new ArrayList<T>();
        return IteratorUtils.toList(iterable.iterator());
    }

    public static <T> List<T> unmodifiableListCopy(Collection<T> collection) {
        if (collection == null)
            return Collections.emptyList();
        return ListUtils.unmodifiableList(new ArrayList<T>(collection));
    }

    public static <T> List<T> unmodifiableListCopy(Iterable<T> iterable) {
        if (iterable == null)
            return Collections.emptyList();
        return ListUtils.unmodifiableList(IteratorUtils.toList(iterable.iterator()));
    }

    public static <T> List<T> unmodifiableListCopy(T[] array) {
        if (array == null)
            return Collections.emptyList();
        return ListUtils.unmodifiableList(arrayToList(array));
    }

    public static <K, V> Map<K, V> unmodifiableMapCopy(Map<K, V> map) {
        if (map == null)
            return Collections.emptyMap();
        return Collections.unmodifiableMap(new LinkedHashMap<K, V>(map));
    }

    public static <T> Set<T> unmodifiableSetCopy(Iterable<T> iterable) {
        if (iterable == null)
            return Collections.emptySet();
        LinkedHashSet<T> set = new LinkedHashSet<T>();
        Iterator<T> iter = iterable.iterator();
        while (iter.hasNext()) {
            set.add(iter.next());
        }
        return Collections.unmodifiableSet(set);
    }

    public static <T> Set<T> unmodifiableSetCopy(Set<T> set) {
        if (set == null)
            return Collections.emptySet();
        return Collections.unmodifiableSet(new LinkedHashSet<T>(set));
    }

    public static <T> T find(Iterable<T> collection, Predicate<T> predicate, T defaultValue) {
        if (collection == null)
            return defaultValue;
        T value = CollectionUtils.find(collection, predicate);
        if (value == null)
            return defaultValue;
        return value;
    }
}