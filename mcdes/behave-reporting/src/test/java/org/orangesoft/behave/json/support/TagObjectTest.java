package org.orangesoft.behave.json.support;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang.NotImplementedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.orangesoft.behave.ValidationException;
import org.orangesoft.behave.generators.integrations.PageTest;
import org.orangesoft.behave.json.Element;

/**
 * @author Damian Szczepanik (damianszczepanik@github)
 */
public class TagObjectTest extends PageTest {

    @Before
    public void setUp()  throws Exception{
        setUpWithJson(SAMPLE_JSON);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void TagObject_OnNullTagName_ThrowsException() {
        // given
        // nothing

        // then
        thrown.expect(ValidationException.class);
        TagObject to = new TagObject(null);
    }

    @Test
    public void getName_ReturnsTagName() {

        // given
        final String refName = "yourName";
        TagObject tag = new TagObject(refName);

        // when
        String name = tag.getName();

        // then
        assertThat(name).isEqualTo(refName);
    }

    @Test
    public void getReportFileName_ReturnsFileName() {

        // given
        TagObject tag = new TagObject("@client:output");

        // when
        String fileName = tag.getReportFileName();

        // then
        assertThat(fileName).isEqualTo("client-output.html");
    }

    @Test
    public void getElements_ReturnsExactAddedElement() {

        // given
        TagObject tag = new TagObject("@checkout");
        Element[] elements = this.features.get(0).getElements();

        // when
        for (Element element : elements) {
            tag.addElement(element);
        }

        // then
        assertThat(tag.getElements()).containsExactly(elements);
    }

    @Test
    public void getScenarios_ReturnsSumOfScenarios() {

        // given
        TagObject tag = new TagObject("@checkout");
        Element[] elements = this.features.get(0).getElements();

        // when
        for (Element element : elements) {
            tag.addElement(element);
        }

        // then
        assertThat(tag.getScenarios()).isEqualTo(elements.length);
    }

    @Test
    public void getPassedScenarios_ReturnsSumOfPassingScenarios() {

        // given
        TagObject tag = new TagObject("@checkout");
        Element[] elements = this.features.get(0).getElements();

        // when
        for (Element element : elements) {
            tag.addElement(element);
        }

        // then
        assertThat(tag.getPassedScenarios()).isEqualTo(1);
    }

    @Test
    public void getFailedScenarios_ReturnsSumOfFailedScenarios() {

        // given
        TagObject tag = new TagObject("@checkout");
        Element[] elements = this.features.get(0).getElements();

        // when
        for (Element element : elements) {
            tag.addElement(element);
        }

        // then
        assertThat(tag.getFailedScenarios()).isEqualTo(0);
    }

    @Test
    public void getDurations_ReturnsDurations() {

        // given
        TagObject tag = new TagObject("@checkout");
        Element[] elements = this.features.get(0).getElements();

        // when
        for (Element element : elements) {
            tag.addElement(element);
        }

        // then
        assertThat(tag.getDurations()).isEqualTo(460L);
        assertThat(tag.getFormattedDurations()).isEqualTo("460ms");
    }

    @Test
    public void getSteps_ReturnsSumOfSteps() {

        // given
        TagObject tag = new TagObject("@checkout");
        Element[] elements = this.features.get(0).getElements();

        // when
        for (Element element : elements) {
            tag.addElement(element);
        }

        // then
        assertThat(tag.getSteps()).isEqualTo(7);
    }

    @Test
    public void getNumberOfStatus_OnStatus__ReturnsSumOfStatuses() {

        // given
        TagObject tag = new TagObject("@checkout");
        Element[] elements = this.features.get(0).getElements();

        // when
        for (Element element : elements) {
            tag.addElement(element);
        }

        // then
        assertThat(tag.getNumberOfStatus(Status.PASSED)).isEqualTo(7);
        assertThat(tag.getNumberOfStatus(Status.FAILED)).isEqualTo(0);
        assertThat(tag.getNumberOfStatus(Status.PENDING)).isEqualTo(0);
        assertThat(tag.getNumberOfStatus(Status.MISSING)).isEqualTo(0);
    }

    @Test
    public void getRawStatus_ReturnsRawOfFinalStatus() {

        // given
        TagObject tag = new TagObject("@checkout");
        Element[] elements = this.features.get(0).getElements();

        // when
        for (Element element : elements) {
            tag.addElement(element);
        }

        // then
        assertThat(tag.getRawStatus()).isEqualTo(Status.PASSED.getRawName());
    }

    @Test
    public void getDeviceName_ThrowsException() {
        // given
        TagObject tag = new TagObject("@checkout");

        // then
        thrown.expect(NotImplementedException.class);
        tag.getDeviceName();
    }

    @Test
    public void compareTo_OnDifferentTagName_ReturnsNoneZero() {

        // given
        TagObject tag1 = new TagObject("one");
        TagObject tag2 = new TagObject("two");

        // when
        int result = tag1.compareTo(tag2);

        // then
        assertThat(result).isNotEqualTo(0);
    }

    @Test
    public void compareTo_OnSameLocation_ReturnsZero() {

        // given
        TagObject tag1 = new TagObject("one");
        TagObject tag2 = new TagObject("one");

        // when
        int result = tag1.compareTo(tag2);

        // then
        assertThat(result).isEqualTo(0);
    }
}
