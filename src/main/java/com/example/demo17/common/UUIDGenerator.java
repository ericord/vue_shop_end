package com.example.demo17.common;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;
import java.util.UUID;

public class UUIDGenerator extends IdentityGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)  {
        Object id = UUID.randomUUID().toString();
        if (id != null) {
            return (Serializable) id;
        }
        return super.generate(session, object);
    }
}