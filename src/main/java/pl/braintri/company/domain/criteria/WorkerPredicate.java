package pl.braintri.company.domain.criteria;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import pl.braintri.company.domain.entities.Worker;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

public class WorkerPredicate {

    public WorkerPredicate(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    private SearchCriteria criteria;

    public BooleanExpression getPredicate() {
        PathBuilder<Worker> entityPath = new PathBuilder<>(Worker.class, "worker");

        if (isNumeric(criteria.getValue().toString())) {
            NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
            int value = Integer.parseInt(criteria.getValue().toString());
            switch (criteria.getOperation()) {
                case ":":
                    return path.eq(value);
                case ">":
                    return path.goe(value);
                case "<":
                    return path.loe(value);
            }
        } else {
            StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equalsIgnoreCase(":")) {
                return path.containsIgnoreCase(criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase("cont")) {
                return path.contains(criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase("like")) {
                return path.like(criteria.getValue().toString());
            }
        }
        return null;
    }
}
