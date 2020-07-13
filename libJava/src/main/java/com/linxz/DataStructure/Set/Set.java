package com.linxz.DataStructure.Set;

/**
 * @author Linxz
 * 创建日期：2020年07月11日 08:46
 * version：v4.5.4
 * 描述：不能添加重复元素
 *      底层实现多种多样，比如使用二分搜索树实现。
 *
 * 使用场景：客户统计、词汇量统计(一本小说有多个个词汇)
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
