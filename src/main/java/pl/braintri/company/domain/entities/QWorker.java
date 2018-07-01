//package pl.braintri.company.domain.entities;
//
//import com.querydsl.core.types.PathMetadata;
//import com.querydsl.core.types.PathMetadataFactory;
//import com.querydsl.core.types.dsl.EntityPathBase;
//import com.querydsl.core.types.dsl.NumberPath;
//import com.querydsl.core.types.dsl.PathInits;
//import com.querydsl.core.types.dsl.StringPath;
//
//import javax.annotation.Nullable;
//import java.math.BigDecimal;
//
//public class QWorker extends EntityPathBase<Worker> {
//
//    public QWorker(String variable) {
//        this(Worker.class, PathMetadataFactory.forVariable(variable), INITS);
//    }
//
//    public QWorker(Class<? extends Worker> type, String variable) {
//        super(type, variable);
//    }
//
//    public QWorker(Class<? extends Worker> type, PathMetadata metadata) {
//        super(type, metadata);
//    }
//
//    public QWorker(PathMetadata metadata, @Nullable PathInits inits) {
//        this(Worker.class, metadata, inits);
//    }
//
//    public QWorker(Class<? extends Worker> type, PathMetadata metadata, @Nullable PathInits inits) {
//        super(type, metadata, inits);
//        this.id = this.createNumber("id", Long.class);
//        this.firstName = this.createString("firstName");
//        this.otherName = this.createString("otherName");
//        this.lastName = this.createString("lastName");
//        this.email = this.createString("email");
//        this.salary = this.createNumber("salary", BigDecimal.class);
//        this.version = this.createNumber("version", Long.class);
//        this.position = inits.isInitialized("position") ? new QPosition(this.forProperty("position"), inits.get("position")) : null;
//
//    }
//
//    private static final long serialVersionUID = 1L;
//    public static final PathInits INITS;
//    public static final QWorker worker;
//    public final NumberPath<Long> id;
//    public final StringPath firstName;
//    public final StringPath otherName;
//    public final StringPath lastName;
//    public final StringPath email;
//    public final NumberPath<BigDecimal> salary;
//    public final QPosition position;
//    private NumberPath<Long> version;
//
//    static {
//        INITS = PathInits.DIRECT2;
//        worker = new QWorker("worker");
//    }
//}


//package pl.braintri.company.domain.entities;
//import com.querydsl.core.types.dsl.*;
//
//import com.querydsl.core.types.PathMetadata;
//import javax.annotation.Generated;
//import com.querydsl.core.types.Path;
//import com.querydsl.core.types.dsl.PathInits;
//import pl.braintri.company.domain.entities.QPosition;
//import pl.braintri.company.domain.entities.Worker;
//
//import static com.querydsl.core.types.PathMetadataFactory.forVariable;
//
//
///**
// * QWorker is a Querydsl query type for Worker
// */
//@Generated("com.querydsl.codegen.EntitySerializer")
//public class QWorker extends EntityPathBase<Worker> {
//
//    private static final long serialVersionUID = -218674695L;
//
//    private static final PathInits INITS = PathInits.DIRECT2;
//
//    public static final QWorker worker = new QWorker("worker");
//
//    public final StringPath email = createString("email");
//
//    public final StringPath firstName = createString("firstName");
//
//    public final NumberPath<Long> id = createNumber("id", Long.class);
//
//    public final StringPath lastName = createString("lastName");
//
//    public final StringPath otherName = createString("otherName");
//
//    public final QPosition position;
//
//    public final NumberPath<java.math.BigDecimal> salary = createNumber("salary", java.math.BigDecimal.class);
//
//    public final NumberPath<Long> version = createNumber("version", Long.class);
//
//    public QWorker(String variable) {
//        this(Worker.class, forVariable(variable), INITS);
//    }
//
//    public QWorker(Path<? extends Worker> path) {
//        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
//    }
//
//    public QWorker(PathMetadata metadata) {
//        this(metadata, PathInits.getFor(metadata, INITS));
//    }
//
//    public QWorker(PathMetadata metadata, PathInits inits) {
//        this(Worker.class, metadata, inits);
//    }
//
//    public QWorker(Class<? extends Worker> type, PathMetadata metadata, PathInits inits) {
//        super(type, metadata, inits);
//        this.position = inits.isInitialized("position") ? new QPosition(forProperty("position")) : null;
//    }
//
//}
