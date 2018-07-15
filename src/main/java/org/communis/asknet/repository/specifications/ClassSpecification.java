package org.communis.asknet.repository.specifications;

import org.communis.asknet.dto.filters.ClassFilterWrapper;
import org.communis.asknet.entity.Issue;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public abstract class ClassSpecification implements Specification<Issue>
{
    private ClassSpecification(){}

    public static ClassSpecification build(final ClassFilterWrapper filter)
    {
        return new ClassSpecification()
        {
            @Override
            public Predicate toPredicate(Root<Issue> root, CriteriaQuery<?> cq, CriteriaBuilder cb)
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