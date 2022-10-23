package com.example.boardService.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEntityFileds is a Querydsl query type for EntityFileds
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QEntityFileds extends EntityPathBase<EntityFileds> {

    private static final long serialVersionUID = -1779951574L;

    public static final QEntityFileds entityFileds = new QEntityFileds("entityFileds");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public QEntityFileds(String variable) {
        super(EntityFileds.class, forVariable(variable));
    }

    public QEntityFileds(Path<? extends EntityFileds> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEntityFileds(PathMetadata metadata) {
        super(EntityFileds.class, metadata);
    }

}

