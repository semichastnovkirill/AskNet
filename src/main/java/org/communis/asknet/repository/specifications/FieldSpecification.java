package org.communis.asknet.repository.specifications;

import org.communis.asknet.dto.filters.FieldFilterWrapper;
import org.communis.asknet.entity.Field;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FieldSpecification implements Specification<Field>
{
    private FieldSpecification(){}

    public static FieldSpecification build(final FieldFilterWrapper filter)
    {
        return new FieldSpecification()
        {
            @Override
            public Predicate toPredicate(Root<Field> root, CriteriaQuery<?> cq, CriteriaBuilder cb)
            {
                final List predicates = new ArrayList();

                if (filter != null) {
                    if (filter.getSearch() != null && !filter.getSearch().isEmpty()) {
                        predicates.add(cb.like(cb.upper(root.get("title")), '%' + filter.getSearch().toUpperCase() + '%'));
                    }

                    if(!filter.getWithout().isEmpty()) {
                        List<Long> ids = filter.getWithout().stream().map(p -> new Long(p.getId())).collect(Collectors.toList());
                        predicates.add(cb.not(root.get("id").in(ids)));
                    }
                }

                return cb.and((Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

}