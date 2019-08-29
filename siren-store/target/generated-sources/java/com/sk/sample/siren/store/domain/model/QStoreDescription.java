package com.sk.sample.siren.store.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStoreDescription is a Querydsl query type for StoreDescription
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStoreDescription extends BeanPath<StoreDescription> {

    private static final long serialVersionUID = -167136391L;

    public static final QStoreDescription storeDescription = new QStoreDescription("storeDescription");

    public final StringPath storeInfo = createString("storeInfo");

    public final EnumPath<StoreType> storeType = createEnum("storeType", StoreType.class);

    public QStoreDescription(String variable) {
        super(StoreDescription.class, forVariable(variable));
    }

    public QStoreDescription(Path<? extends StoreDescription> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStoreDescription(PathMetadata metadata) {
        super(StoreDescription.class, metadata);
    }

}

