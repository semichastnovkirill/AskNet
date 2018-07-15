package org.communis.asknet.repository.specifications;

import org.communis.asknet.dto.filters.ViewFilterWrapper;
import org.communis.asknet.entity.View;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public abstract class ViewSpecification implements Specification<View>
{
    private ViewSpecification(){}

    public static ViewSpecification build(final ViewFilterWrapper filter)
    {
        return new ViewSpecification()
        {
            @Override
            public Predicate toPredicate(Root<View> root, CriteriaQuery<?> cq, CriteriaBuilder cb)
            {
                final List predicates = new ArrayList();

                if (filter != null)
                {
                    if (filter.getSearch() != null && !filter.getSearch().isEmpty())
                    {
                        predicates.add(cb.like(cb.upper(root.get("title")), '%' + filter.getSearch().toUpperCase() + '%'));
                    }
                }

                return cb.and((Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

}