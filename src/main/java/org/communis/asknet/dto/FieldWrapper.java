package org.communis.asknet.dto;

import lombok.Data;
import org.communis.asknet.entity.Field;

@Data
public class FieldWrapper implements ObjectWrapper<Field> {

    private Long id;
    private String title;
    private SupportedDataTypeWrapper type = new SupportedDataTypeWrapper();

    public FieldWrapper() {

    }

    public FieldWrapper(long id, String title) {
        this.id=id;
        this.title=title;
    }

    public FieldWrapper(Field item) {
        toWrapper(item);
    }

    @Override
    public void toWrapper(Field item) {
        if (item != null) {
            id = item.getId();
            title = item.getTitle();
            type=new SupportedDataTypeWrapper(item.getType());
        }
    }

    @Override
    public void fromWrapper(Field item) {
        if (item != null) {
            item.setId(id);
            item.setTitle(title);
        }
    }
}