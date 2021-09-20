import boto3
import os
from botocore.exceptions import NoCredentialsError


def upload_to_aws(local_file, bucket, s3_file):
    s3 = boto3.client('s3')

    try:
        s3.upload_file(local_file, bucket, s3_file,
                       ExtraArgs={'ACL': 'public-read'})
        print("Upload Successful")
        return True
    except FileNotFoundError:
        print("The file was not found")
        return False
    except NoCredentialsError:
        print("Credentials not available")
        return False


def upload_folder_to_aws(path, bucket, s3_folder):
    for _, _, files in os.walk(path):
        for file in files:
            s3 = boto3.client('s3')
            local_file = f"{path}/{file}"
            s3_file = f"{s3_folder}/{local_file}"
            try:
                s3.upload_file(local_file, bucket, s3_file,
                               ExtraArgs={'ACL': 'public-read'})
                print("Upload Successful")
                return True
            except FileNotFoundError:
                print("The file was not found")
                return False
            except NoCredentialsError:
                print("Credentials not available")
                return False
