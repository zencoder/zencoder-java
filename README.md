zencoder-java
====================

Java library for interacting with the Zencoder API.

### Getting Started

Add the library as a dependancy to your project.

If you're using Maven, add this to your pom.xml file:

        <dependency>
              <groupId>com.brightcove.zencoder.api</groupId>
              <artifactId>zencoder-java</artifactId>
              <version>2.0.19</version>
        </dependency>


Import the client and related classes:

```java
import com.brightcove.zencoder.client.ZencoderClient;
import com.brightcove.zencoder.client.ZencoderClientException;
import com.brightcove.zencoder.client.model.*
import com.brightcove.zencoder.client.request.*
import com.brightcove.zencoder.client.response.*;
```

Instantiate a new client with your API key:

```java
ZencoderClient client = new ZencoderClient("INSERT_API_KEY_HERE");
```

### Usage

Create a new job:

```java
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
```

Query an existing job:

```java
String jobId = response.getId();
ZencoderJobDetail details = client.getZencoderJob(jobId);
String inputId = details.getInputMediaFile().getId();
String outputId1 = response.getOutputs().get(0).getId();
String outputId2 = response.getOutputs().get(1).getId();
        
ZencoderInputOutputProgress inputProgress = client.getInputProgress(inputId);
ZencoderInputOutputProgress outputProgress1 = client.getOutputProgress(outputId1);
ZencoderInputOutputProgress outputProgress2 = client.getOutputProgress(outputId2);
```

Cancel and resubmit an existing job:

```java
client.cancelJob(jobId);
client.resubmitJob(jobId);
```

## Copyright
See LICENSE.txt for details.
