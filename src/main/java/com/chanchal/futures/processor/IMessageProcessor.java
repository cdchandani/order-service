package com.chanchal.futures.processor;

public interface IMessageProcessor<K, V> {
    K processMessage(V request);
}
