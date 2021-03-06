package org.orangesoft.behave.generators;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.velocity.VelocityContext;
import org.junit.Before;
import org.junit.Test;

import mockit.Deencapsulation;
import org.orangesoft.behave.generators.integrations.PageTest;
import org.orangesoft.behave.json.support.TagObject;

/**
 * @author Damian Szczepanik (damianszczepanik@github)
 */
public class TagReportPageTest extends PageTest {

    @Before
    public void setUp() throws Exception {
        setUpWithJson(SAMPLE_JSON);
    }

    @Test
    public void getWebPage_ReturnsFeatureFileName() {

        // give
        TagObject tag = tags.get(0);
        page = new TagReportPage(reportResult, configuration, tag);

        // when
        String fileName = page.getWebPage();

        // then
        assertThat(fileName).isEqualTo(tag.getReportFileName());
    }

    @Test
    public void prepareReportAddsCustomProperties() {

        // give
        TagObject tag = tags.get(1);
        page = new TagReportPage(reportResult, configuration, tag);

        // when
        page.prepareReport();

        // then
        VelocityContext context = Deencapsulation.getField(page, "context");
        assertThat(context.getKeys()).hasSize(6);
        assertThat(context.get("tag")).isEqualTo(tag);
    }
}
