

package dev.zacsweers.metro.compiler;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link dev.zacsweers.metro.compiler.GenerateTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler-tests/src/test/data/dump/fir")
@TestDataPath("$PROJECT_ROOT")
public class FirDumpTestGenerated extends AbstractFirDumpTest {
  @Test
  public void testAllFilesPresentInFir() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler-tests/src/test/data/dump/fir"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Nested
  @TestMetadata("compiler-tests/src/test/data/dump/fir/aggregation")
  @TestDataPath("$PROJECT_ROOT")
  public class Aggregation {
    @Test
    public void testAllFilesPresentInAggregation() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler-tests/src/test/data/dump/fir/aggregation"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("ContributingTypes.kt")
    public void testContributingTypes() {
      runTest("compiler-tests/src/test/data/dump/fir/aggregation/ContributingTypes.kt");
    }

    @Test
    @TestMetadata("ContributingTypesDependency.kt")
    public void testContributingTypesDependency() {
      runTest("compiler-tests/src/test/data/dump/fir/aggregation/ContributingTypesDependency.kt");
    }
  }
}
