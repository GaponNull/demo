[
  {
    "essential": true,
    "memory": 256,
    "name": "config-app",
    "cpu": 256,
    "image": "hsr-configuration-service",
    "command": ["./gradlew", "bootRun"],
    "portMappings": [
        {
            "containerPort": 8085,
            "hostPort": 8085
        }
    ]
  }
]