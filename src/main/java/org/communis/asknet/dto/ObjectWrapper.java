package org.communis.asknet.dto;

import java.io.Serializable;

public interface ObjectWrapper<T> extends Serializable
{
    void toWrapper(T item);

    void fromWrapper(T item);
}
