package org.acme.domain.model;

import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.string.SetArgs;
import io.quarkus.redis.datasource.value.ValueCommands;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;

@ApplicationScoped
public class Cache {


    private ReactiveKeyCommands<String> keyCommands;
    private ValueCommands<String, Long> countCommands;

    public Cache(RedisDataSource ds, ReactiveRedisDataSource reactive) {
        countCommands = ds.value(Long.class);
        keyCommands = reactive.key();
    }
    public Long get(String key) {
        Long value = countCommands.get(key);
        return value;
    }

    public void set(String key, Long value) {
        countCommands.set(key, value);
    }

    public Uni<Void> del(String key) {
        return keyCommands.del(key)
                .replaceWithVoid();
    }

    public boolean notInCache(Long value) {
        return value.equals(null);
    }

    public boolean inCache(Long value){
        return !notInCache(value);
    }

}
