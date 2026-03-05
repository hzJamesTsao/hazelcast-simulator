/*
 * Copyright (c) 2008-2016, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hazelcast.simulator.tests.map;

import com.github.javafaker.Faker;
import com.hazelcast.map.IMap;
import com.hazelcast.simulator.hz.HazelcastTest;
import com.hazelcast.simulator.test.BaseThreadState;
import com.hazelcast.simulator.test.annotations.Prepare;
import com.hazelcast.simulator.test.annotations.Setup;
import com.hazelcast.simulator.test.annotations.Teardown;
import com.hazelcast.simulator.test.annotations.TimeStep;
import com.hazelcast.simulator.test.annotations.Verify;
import com.hazelcast.simulator.tests.map.domain.MarketDataHazelcastEntity;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MapMarketDataTest extends HazelcastTest {

    // properties
    public int initEntityCount = 1000;
    public int maxKeys = 1000000;
    public String keyPrefix = "MY-KEY-PREFIX-";

    private IMap<String, MarketDataHazelcastEntity> map;
    private MarketDataHazelcastEntity[] entities; 

    @Setup
    public void setUp() {
        logger.info("======== SETUP =========");
        map = targetInstance.getMap(name);

        logger.info("Map name is: " + map.getName());
    }

    @Prepare
    public void prepare() {
        logger.info("======== PREPARE =========");

        // it takes ~5ms to execute generateMarketDataEntity, so pre-generate objects and pick
        // a random one to insert

        entities = new MarketDataHazelcastEntity[initEntityCount];

        // generate entities
        for (int i = 0; i < initEntityCount; i++) {
            MarketDataHazelcastEntity value = generateMarketDataEntity();
            entities[i] = value;
        }

        // pre-populate map and set a predictable key
        for (int x = 0; x < maxKeys; x++) {
            int index = ThreadLocalRandom.current().nextInt(initEntityCount);
            String key = keyPrefix+(maxKeys + x);
            MarketDataHazelcastEntity value = entities[index];
            value.setId(key);
            map.set(key, value);
        }

        logger.info("Initialized market data entities: " + entities.length);
        logger.info("Pre-populated keys: " + map.size());

    }

    @TimeStep(prob = 0.0)
    public MarketDataHazelcastEntity put(BaseThreadState state) {
        String key = keyPrefix+(state.randomInt(maxKeys)+maxKeys);
        MarketDataHazelcastEntity marketdata = entities[state.randomInt(initEntityCount)];
        marketdata.setId(key);
        return map.put(key, marketdata);

    }

    @TimeStep(prob = 0.5)
    public void set(BaseThreadState state) {
        String key = keyPrefix+(state.randomInt(maxKeys)+maxKeys);
        MarketDataHazelcastEntity marketdata = entities[state.randomInt(initEntityCount)];
        marketdata.setId(key);
        map.set(key, marketdata);
    }

    @TimeStep(prob = 0.5)
    public MarketDataHazelcastEntity get(BaseThreadState state) {
        String key = keyPrefix+(maxKeys + (state.randomInt(maxKeys)+maxKeys));
        return map.get(key);
    }

    @TimeStep(prob = 0.0)
    public Map<String, MarketDataHazelcastEntity> getAll(BaseThreadState state) {
        // may not be the most efficient method to generate 20 random keys to perform getAll
        Set<String> keys = new HashSet<String>();
        String key;
        for (int i=0;i<20;i++) {
            key = keyPrefix+(maxKeys + (state.randomInt(maxKeys)+maxKeys));
            keys.add(key);
        }
        return map.getAll(keys);
    }


    @Verify
    public void verify() {
        logger.info("======== VERIFYING =========");
        logger.info("Map size is: " + map.size());

        /*
        for (int i = 0; i < maxKeys; i++) {
            String actualValue = map.get(i);
            if (actualValue != null) {
                String expectedValue = "value" + i;
                assertEquals(expectedValue, actualValue);
            }
        }
        */
    }

    @Teardown
    public void tearDown() {
        logger.info("======== TEAR DOWN =========");
        map.destroy();
        logger.info("======== THE END =========");
    }

    private MarketDataHazelcastEntity generateMarketDataEntity() {

        Faker ukFaker = new Faker(new Locale("en-GB"));
        String symbol = ukFaker.stock().nyseSymbol();

        return new MarketDataHazelcastEntity(
            "REPLACE_ME_ID", 
            null, 
            symbol, 
            symbol, 
            "REUTERS",
            BigDecimal.valueOf(ukFaker.number().randomDouble(3,100,200)), 
            BigDecimal.valueOf(ukFaker.number().randomDouble(3,100,200)),
            BigDecimal.valueOf(ukFaker.number().randomDouble(3,80,100)), 
            BigDecimal.valueOf(ukFaker.number().randomDouble(3,200,220)), 
            BigDecimal.valueOf(ukFaker.number().randomDouble(3,100,200)), 
            BigDecimal.valueOf(ukFaker.number().randomDouble(3,100,150)),
            BigDecimal.valueOf(ukFaker.number().randomDouble(0,100,10000)),
            BigDecimal.valueOf(ukFaker.number().randomDouble(0,100,10000)), 
            BigDecimal.valueOf(ukFaker.number().randomDouble(0,1000,10000)), 
            BigDecimal.valueOf(ukFaker.number().randomDouble(0,100,1000)), 
            BigDecimal.valueOf(ukFaker.number().randomDouble(3,0,1)), 
            BigDecimal.valueOf(ukFaker.number().randomDouble(3,100,200)), 
            ukFaker.date().past(1, TimeUnit.HOURS).toInstant().atZone(ZoneId.of("GMT")).toLocalDateTime(), 
            ukFaker.date().past(1, TimeUnit.HOURS).toInstant().atZone(ZoneId.of("GMT")).toLocalDateTime(), 
            "THMPSN-RTRS", 
            ukFaker.date().past(1, TimeUnit.HOURS).toInstant().atZone(ZoneId.of("GMT")).toLocalDateTime(), 
            "NYSE", 
            ukFaker.bothify("?????-#####-?????-?????").toUpperCase(), 
            ukFaker.date().past(1, TimeUnit.HOURS).toInstant().atZone(ZoneId.of("GMT")).toLocalDateTime());
    }


}
