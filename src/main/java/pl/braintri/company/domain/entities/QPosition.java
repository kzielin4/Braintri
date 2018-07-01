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
//
//public class QPosition extends EntityPathBase<Position> {
//
//    public QPosition(String variable) {
//        this(Position.class, PathMetadataFactory.forVariable(variable), INITS);
//    }
//
//    public QPosition(Class<? extends Position> type, String variable) {
//        super(type, variable);
//    }
//
//    public QPosition(Class<? extends Position> type, PathMetadata metadata) {
//        super(type, metadata);
//    }
//
//    public QPosition(PathMetadata metadata, @Nullable PathInits inits) {
//        this(Position.class,metadata,inits);
//    }
//
//    public QPosition(Class<? extends Position> type, PathMetadata metadata, @Nullable PathInits inits) {
//        super(type, metadata, inits);
//        this.id = this.createNumber("id",Long.class);
//        this.name = this.createString("name");
//        this.version = this.createNumber("version",Long.class);
//
//    }
//    public static final PathInits INITS;
//    public static final QPosition position;
//    public final NumberPath<Long> id;
//    public final StringPath name;
//    public final NumberPath<Long> version;
//
//    static {
//        INITS = PathInits.DIRECT2;
//        position = new QPosition("position");
//    }
//
//}

//package pl.braintri.company.domain.entities;
//
//import static com.querydsl.core.types.PathMetadataFactory.*;
//
//import com.querydsl.core.types.dsl.*;
//
//import com.querydsl.core.types.PathMetadata;
//import javax.annotation.Generated;
//import com.querydsl.core.types.Path;
//
//
///**
// * QPosition is a Querydsl query type for Position
// */
//@Generated("com.querydsl.codegen.EntitySerializer")
//public class QPosition extends EntityPathBase<Position> {
//
//    private static final long serialVersionUID = 1019469028L;
//
//    public static final QPosition position = new QPosition("position1");
//
//    public final NumberPath<Long> id = createNumber("id", Long.class);
//
//    public final StringPath name = createString("name");
//
//    public final NumberPath<Long> version = createNumber("version", Long.class);
//
//    public QPosition(String variable) {
//        super(Position.class, forVariable(variable));
//    }
//
//    public QPosition(Path<? extends Position> path) {
//        super(path.getType(), path.getMetadata());
//    }
//
//    public QPosition(PathMetadata metadata) {
//        super(Position.class, metadata);
//    }
//
//}
