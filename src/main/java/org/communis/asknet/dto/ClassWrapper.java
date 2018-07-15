package org.communis.asknet.dto;

import lombok.Data;
import org.communis.asknet.entity.Field;
import org.communis.asknet.entity.Issue;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClassWrapper implements ObjectWrapper<Issue> {

    private Long id;
    private String title;
    private List<FieldWrapper> fields = new ArrayList<>();

    public ClassWrapper() {

    }

    public ClassWrapper(long id, String title) {
        this.id=id;
        this.title=title;
    }

    public ClassWrapper(Issue item) {
        toWrapper(item);
    }

    @Override
    public void toWrapper(Issue item) {
        if (item != null) {
            id = item.getId();
            title = item.getTitle();

            for(Field field:item.getFieldList()) {
                fields.add(new FieldWrapper(field));
            }
        }
    }

    @Override
    public void fromWrapper(Issue item) {
        if (item != null) {
            item.setId(id);
            item.setTitle(title);
        }
    }
}