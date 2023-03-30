package org.acme.domain.model;

import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.value.ValueCommands;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import java.math.BigInteger;

@Singleton
public class Cache {


    private ReactiveKeyCommands<String> keyCommands;
    private ValueCommands<String, BigInteger> countCommands;

    public Cache(RedisDataSource ds, ReactiveRedisDataSource reactive) {
        countCommands = ds.value(BigInteger.class);
        keyCommands = reactive.key();
    }
    public BigInteger get(String key) {
        BigInteger value = countCommands.get(key);
        return value;
    }

    public void set(String key, BigInteger value) {
        countCommands.set(key, value);
    }

    public Uni<Void> del(String key) {
        return keyCommands.del(key)
                .replaceWithVoid();
    }

    public boolean notInCache(BigInteger value) {
        return value.equals(null);
    }

}
