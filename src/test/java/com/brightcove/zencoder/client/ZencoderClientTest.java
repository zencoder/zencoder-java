package com.brightcove.zencoder.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

import com.brightcove.zencoder.client.account.ZencoderAccountDetails;
import com.brightcove.zencoder.client.account.ZencoderAccountState;
import com.brightcove.zencoder.client.account.ZencoderBillingState;
import com.brightcove.zencoder.client.model.ContainerFormat;
import com.brightcove.zencoder.client.reports.ZencoderAllUsage;
import com.brightcove.zencoder.client.reports.ZencoderLiveUsage;
import com.brightcove.zencoder.client.reports.ZencoderVodUsage;
import com.brightcove.zencoder.client.request.ZencoderCreateJobRequest;
import com.brightcove.zencoder.client.request.ZencoderOutput;
import com.brightcove.zencoder.client.response.ZencoderCreateJobResponse;
import com.brightcove.zencoder.client.response.ZencoderInputOutputProgress;
import com.brightcove.zencoder.client.response.ZencoderJobDetail;

public class ZencoderClientTest {

    // This is an integration-mode only test key, please do not abuse it.
    public static final String TEST_API_KEY = "e7ee309db6ec095e4b14dd2291c7b303";

    @Test
    public void testSimpleTranscode() throws ZencoderClientException {
        ZencoderClient client = new ZencoderClient(TEST_API_KEY);

        ZencoderCreateJobRequest job = new ZencoderCreateJobRequest();
        job.setInput("s3://zencodertesting/test.mov");
        List<ZencoderOutput> outputs = new ArrayList<ZencoderOutput>();

        ZencoderOutput output1 = new ZencoderOutput();
        output1.setFormat(ContainerFormat.MP4);
        outputs.add(output1);

        ZencoderOutput output2 = new ZencoderOutput();
        output2.setFormat(ContainerFormat.WEBM);
        outputs.add(output2);

        job.setOutputs(outputs);
        ZencoderCreateJobResponse response = client.createZencoderJob(job);

        String jobId = response.getId();
        ZencoderJobDetail details = client.getZencoderJob(jobId);
        String inputId = details.getInputMediaFile().getId();
        String outputId1 = response.getOutputs().get(0).getId();
        String outputId2 = response.getOutputs().get(1).getId();

        ZencoderInputOutputProgress inputProgress = client.getInputProgress(inputId);
        assertNotNull(inputProgress);
        ZencoderInputOutputProgress outputProgress1 = client.getOutputProgress(outputId1);
        assertNotNull(outputProgress1);
        ZencoderInputOutputProgress outputProgress2 = client.getOutputProgress(outputId2);
        assertNotNull(outputProgress2);
    }

    @Test
    public void testAccounts() throws ZencoderClientException {
        ZencoderClient client = new ZencoderClient(TEST_API_KEY);
        ZencoderAccountDetails details = client.getAccountDetails();
        assertEquals(ZencoderAccountState.ACTIVE, details.getAccountState());
        assertEquals(ZencoderBillingState.NONE, details.getBillingState());
        assertTrue(details.getIntegrationMode());
        assertEquals((Long) 0L, details.getMinutesIncluded());
        assertTrue(details.getMinutesUsed() > -1);
    }

    @Test
    public void testReports() throws ZencoderClientException {
        ZencoderClient client = new ZencoderClient(TEST_API_KEY);
        ZencoderVodUsage vodUsage = client.getUsageForVod(null, null, null);
        assertNotNull(vodUsage);
        assertNotNull(vodUsage.getTotal());
        assertTrue(vodUsage.getTotal().getBillableMinutes() == 0);
        assertTrue(vodUsage.getTotal().getEncodedMinutes() >= 0);
        assertNotNull(vodUsage.getStatistics());
        assertEquals(0, vodUsage.getStatistics().size());

        ZencoderLiveUsage liveUsage = client.getUsageForLive(null, null, null);
        assertNotNull(liveUsage);
        assertNotNull(liveUsage.getTotal());
        assertTrue(liveUsage.getTotal().getBillableStreamHours() == 0);
        assertTrue(liveUsage.getTotal().getStreamHours() >= 0);
        assertNotNull(liveUsage.getStatistics());
        assertEquals(0, liveUsage.getStatistics().size());

        ZencoderAllUsage allUsage = client.getUsageForVodAndLive(null, null, null);
        assertNotNull(allUsage);
        assertNotNull(allUsage.getTotal());
        assertTrue(allUsage.getTotal().getVod().getBillableMinutes() == 0);
        assertTrue(allUsage.getTotal().getVod().getEncodedMinutes() >= 0);
        assertTrue(allUsage.getTotal().getLive().getBillableEncodedHours() == 0);
        assertTrue(allUsage.getTotal().getLive().getEncodedHours() >= 0);
    }
}
