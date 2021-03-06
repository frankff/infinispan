package org.infinispan.persistence.leveldb;

import java.io.File;

import org.infinispan.commons.util.Util;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.persistence.ParallelIterationTest;
import org.infinispan.persistence.leveldb.configuration.LevelDBStoreConfigurationBuilder;
import org.infinispan.test.TestingUtil;
import org.testng.annotations.Test;

/**
 * @author Mircea Markus
 * @since 6.0
 */
@Test (groups = "functional", testName = "persistence.leveldb.LevelDBParallelIterationTest")
public class LevelDBParallelIterationTest extends ParallelIterationTest {

   private String tmpDirectory;

   @Override
   protected void configurePersistence(ConfigurationBuilder cb) {
      tmpDirectory = TestingUtil.tmpDirectory(this.getClass());
      new File(tmpDirectory).mkdirs();
      cb.persistence()
            .addStore(LevelDBStoreConfigurationBuilder.class)
            .location(tmpDirectory + "/data")
            .expiredLocation(tmpDirectory + "/expiry")
            .clearThreshold(2);
   }

   @Override
   protected void teardown() {
      Util.recursiveFileRemove(tmpDirectory);
      super.teardown();
   }

}
