output "ecr-config-app-uri" {
  value = aws_ecr_repository.hrs-configuration-service.repository_url
}

//output "service-url" {
//  value = aws_ecs_service.config-app-service.
//}