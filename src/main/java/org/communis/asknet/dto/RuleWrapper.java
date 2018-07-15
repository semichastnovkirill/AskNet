package org.communis.asknet.dto;

import lombok.Data;
import org.communis.asknet.entity.Rule;


@Data
public class RuleWrapper implements ObjectWrapper<Rule> {

    private Long id;
    private String title;

    public RuleWrapper() {

    }

    public RuleWrapper(long id, String title) {
        this.id=id;
        this.title=title;
    }

    public RuleWrapper(Rule item) {
        toWrapper(item);
    }

    @Override
    public void toWrapper(Rule item) {
        if (item != null) {
            id = item.getId();
            title = item.getTitle();

        }
    }

    @Override
    public void fromWrapper(Rule item) {
        if (item != null) {
            item.setId(id);
            item.setTitle(title);
        }
    }
}