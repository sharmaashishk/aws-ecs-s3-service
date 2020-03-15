package com.example.springbootawss3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage")
public class S3StorageBucketController {

	private AmazonClientComponent amazonClient;

	@Autowired
	private S3StorageBucketController(AmazonClientComponent amazonClient)
	{
		this.amazonClient=amazonClient;
	}

	@PostMapping("/uploadFile")
	public String uploadFile(@RequestPart(value="file") MultipartFile file)
	{
		return amazonClient.uploadFile(file);
	}

	@DeleteMapping("/deleteFile")
	public String deleteFile(@RequestPart(value = "url") String fileUrl) {
		return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
	}

}
