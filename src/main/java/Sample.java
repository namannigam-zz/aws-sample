import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;

public class Sample {

    public static void main(String[] args) {
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProtocol(Protocol.HTTP);

        String accessKey = "********";
        String secretKey = "*******";
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        AmazonS3 conn = new AmazonS3Client(credentials, clientConfig);
        conn.setEndpoint("http://10.x.x.x");
        conn.setS3ClientOptions(new S3ClientOptions().withPathStyleAccess(true));

        String bucketName = "raw-content-stage";

        Bucket bucket = conn.createBucket(bucketName);
        conn.putObject(new PutObjectRequest(bucketName, "key", new File("test-file.flv")));

        System.out.println("hold-door");
    }
}
