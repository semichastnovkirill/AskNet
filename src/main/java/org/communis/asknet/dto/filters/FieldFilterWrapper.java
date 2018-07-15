package org.communis.asknet.dto.filters;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.communis.asknet.dto.FieldWrapper;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class FieldFilterWrapper extends ObjectFilter {

    private List<FieldWrapper> without = new ArrayList<>(0);

    public FieldFilterWrapper(){}

    public FieldFilterWrapper(List<FieldWrapper> without){
        this.without = without;
    }

    public FieldFilterWrapper(String search){
        setSearch(search);
    }
}
