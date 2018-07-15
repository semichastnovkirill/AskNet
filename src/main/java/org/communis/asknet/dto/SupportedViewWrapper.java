package org.communis.asknet.dto;

import lombok.Data;
import org.communis.asknet.entity.SupportedView;

@Data
public class SupportedViewWrapper implements ObjectWrapper<SupportedView> {

    private String id;
    private String name;

    public SupportedViewWrapper() {}


    public SupportedViewWrapper(SupportedView item) {
        toWrapper(item);
    }

    @Override
    public void toWrapper(SupportedView item) {
        if (item != null) {
            id = item.getId();
            name = item.getName();
        }
    }

    @Override
    public void fromWrapper(SupportedView item) {

    }
}