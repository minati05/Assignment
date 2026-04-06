provider "aws" {
  region = "ap-south-1"
}

resource "aws_ecr_repository" "repo" {
  name = "order-service"
}

resource "aws_iam_role" "service_role" {
  name = "order-service-role"

  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [{
      Action = "sts:AssumeRole"
      Effect = "Allow"
      Principal = {
        Service = "ec2.amazonaws.com"
      }
    }]
  })
}
