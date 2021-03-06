package com.salesarea.eventarea.aws;

import java.io.File;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

@Service
public class S3Service {

	@Autowired(required = true)
	AwsUtil awsUtil;
	
	private static final String urlPadrao = "https://eventarea.s3-us-west-1.amazonaws.com/";
	
	public String uploadFile(File file, String keyName) {
		String urlAws = null;
		try {
			TransferManager tm = TransferManagerBuilder.standard().withS3Client(awsUtil.s3client()).build();
			Upload upload = tm.upload(awsUtil.getBucket(), keyName, file);
			upload.waitForCompletion();
			urlAws = urlPadrao + keyName;
		} catch (Exception e) {
			System.out.println("Erro ao Salvar Imagem no S3 AWS" + e);
		}
		return urlAws;
	}
}
