package pl.braintri.company.domain.criteria;

import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.List;

public class WorkerPredicatesBuilder {
    private List<SearchCriteria> params;

    public WorkerPredicatesBuilder() {
        params = new ArrayList<>();
    }

    public WorkerPredicatesBuilder with(
            String key, String operation, Object value) {

        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public WorkerPredicatesBuilder with(
            SearchCriteria searchCriteria) {
        params.add(searchCriteria);
        return this;
    }

    public BooleanExpression build() {
        if (params.size() == 0) {
            return null;
        }

        List<BooleanExpression> predicates = new ArrayList<>();
        WorkerPredicate predicate;
        for (SearchCriteria param : params) {
            predicate = new WorkerPredicate(param);
            BooleanExpression exp = predicate.getPredicate();
            if (exp != null) {
                predicates.add(exp);
            }
        }
        BooleanExpression result = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            result = result.and(predicates.get(i));
        }
        return result;
    }
}
