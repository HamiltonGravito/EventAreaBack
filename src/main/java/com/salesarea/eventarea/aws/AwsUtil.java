package com.salesarea.eventarea.aws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsUtil {
	
	  private static final String AWSID = "";
	 
	  private static final String AWSKEY = "";
	  
	  private static final String REGION = "sa-east-1";
	  
	  private static final String BUCKET = "eventarea";
	  
	  //Retornar Cliente Padrão
	  @Bean
	  public AmazonS3 s3client() {
	    BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSID, AWSKEY);
	    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	                			.withRegion(REGION)
	                				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
	    return s3Client;
	  }

	public String getBucket() {
		return BUCKET;
	}
}
