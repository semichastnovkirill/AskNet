package org.communis.asknet.dto;

import lombok.Data;
import org.communis.asknet.entity.SupportedDataType;

@Data
public class SupportedDataTypeWrapper implements ObjectWrapper<SupportedDataType> {

    private String id;
    private String name;

    public SupportedDataTypeWrapper() {}


    public SupportedDataTypeWrapper(SupportedDataType item) {
        toWrapper(item);
    }

    @Override
    public void toWrapper(SupportedDataType item) {
        if (item != null) {
            id = item.getId();
            name = item.getName();
        }
    }

    @Override
    public void fromWrapper(SupportedDataType item) {

    }
}