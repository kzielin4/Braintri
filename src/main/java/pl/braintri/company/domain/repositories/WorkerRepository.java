package pl.braintri.company.domain.repositories;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.braintri.company.domain.entities.QWorker;
import pl.braintri.company.domain.entities.Worker;

@Transactional
public interface WorkerRepository extends CrudRepository<Worker, Long>, QueryDslPredicateExecutor<Worker>, JpaSpecificationExecutor<Worker>, QuerydslBinderCustomizer<QWorker> {
    Worker getById(Long id);

    default public void customize(
            QuerydslBindings bindings, QWorker root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
        bindings.excluding(root.email);
    }
}
