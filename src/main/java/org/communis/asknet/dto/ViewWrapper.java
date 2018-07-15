package org.communis.asknet.dto;

import lombok.Data;
import org.communis.asknet.entity.View;


@Data
public class ViewWrapper implements ObjectWrapper<View> {

    private Long id;
    private String title;

    public ViewWrapper() {

    }

    public ViewWrapper(long id, String title) {
        this.id=id;
        this.title=title;
    }

    public ViewWrapper(View item) {
        toWrapper(item);
    }

    @Override
    public void toWrapper(View item) {
        if (item != null) {
            id = item.getId();
            title = item.getTitle();

        }
    }

    @Override
    public void fromWrapper(View item) {
        if (item != null) {
            item.setId(id);
            item.setTitle(title);
        }
    }
}