resource "aws_ecs_service" "config-app-service" {
  count = var.CONFIG_APP_SERVICE_ENABLED
  name = "hrs-configuration-service"
  cluster = aws_ecs_cluster.config-app-cluster.id
  task_definition = aws_ecs_task_definition.config-app-task-definition.arn
  desired_count = 1
  iam_role = aws_iam_role.ecs-config-app-role.arn
  depends_on = [aws_iam_policy_attachment.ecs-config-app-attach]

  load_balancer {
    elb_name = ""
    container_name = "hsr-configuration-service"
    container_port = 8085
  }
  lifecycle {
    ignore_changes = [task_definition]
  }
}

resource "aws_ecs_task_definition" "config-app-task-definition" {
  container_definitions = data.template_file.myapp-task-definition-template.rendered
  family = "config-app"
}

data "template_file" "myapp-task-definition-template" {
  template = file("templates/app.json.tpl")
}

resource "aws_ecs_cluster" "config-app-cluster" {
  name = "config-app-cluster"
}

# load balancer
resource "aws_elb" "config-app-elb" {
  listener {
    instance_port = 8085
    instance_protocol = "http"
    lb_port = 80
    lb_protocol = "http"
  }

  health_check {
    healthy_threshold = 3
    interval = 60
    target = "HTTP:8085/"
    timeout = 20
    unhealthy_threshold = 3
  }

  cross_zone_load_balancing = true
  idle_timeout = 400
  connection_draining = true
  connection_draining_timeout = 400

  subnets = [aws_subnet.main-public-1.id]
}

resource "aws_ecr_repository" "hrs-configuration-service" {
  name = "hrs-configuration-service"
}
