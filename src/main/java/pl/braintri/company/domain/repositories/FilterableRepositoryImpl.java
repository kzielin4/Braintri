//package pl.braintri.company.domain.repositories;
//
//import org.hibernate.mapping.Filterable;
//import org.springframework.data.jpa.repository.support.JpaEntityInformation;
//import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
//import org.springframework.data.repository.NoRepositoryBean;
//
//import javax.persistence.EntityManager;
//import java.io.Serializable;
//import java.util.function.Predicate;
//
//@NoRepositoryBean
//public class FilterableRepositoryImpl<T, ID extends Serializable> extends QueryDslJpaRepository<T,ID> implements FilterableRepository<T,ID> {
//    @Override
//    public Iterable<T> findAll(Predicate predicate) {
//        return this.findAll(predicate);
//    }
//
//
//    public FilterableRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
//        super(entityInformation, entityManager);
//    }
//}
