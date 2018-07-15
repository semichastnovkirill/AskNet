package org.communis.asknet.dto.filters;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class MainFilterWrapper extends ObjectFilter {

    private Long idView;
    private Map<String, Long> idData;
}
