/*
 * Copyright 2013 EMC Corporation. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.emc.vipr.s3.sample;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.StringInputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class _00_CreateBucket {

	public static void main(String[] args) throws Exception {
		System.out.println( "Enter the bucket name:" );
		String bn = new BufferedReader( new InputStreamReader( System.in ) ).readLine();


    	// create the AWS S3 Client
		AmazonS3 s3 = AWSS3Factory.getS3Client();

    	// create the bucket - used for subsequent demo operations
		s3.createBucket(bn);

        // get bucket listing to retrieve the bucket name
        ObjectListing objects = s3.listObjects(bn);

        // print bucket name for validation
    	System.out.println( String.format("Successfully created bucket [%s]", 
    			objects.getBucketName()));

    }
}
