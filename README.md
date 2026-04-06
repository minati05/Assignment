<<<<<<< HEAD
</> Markdown
# Deployment Portal Backend

## Features
- Register new microservice
- Generates Terraform, Kubernetes YAML, and Jenkins pipeline

## API
POST /api/deploy

Request:
{
  "serviceName": "order-service",
  "teamName": "payments",
  "repoUrl": "https://github.com/example/repo"
}

## Output
- Terraform (ECR + IAM)
- Kubernetes deployment
- Jenkins pipeline

## How to Run
1. Run Spring Boot app(deplyoment-portal)
2. Call API using Postman
=======
# Assignment
Spring Boot User Metadata Service with Retry, Circuit Breaker, Metrics, and Logging
>>>>>>> 5c369016070a0d4e03bd870615316cfcae5d6f17
